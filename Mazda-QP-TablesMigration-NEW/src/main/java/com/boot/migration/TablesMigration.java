package com.boot.migration;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.boot.entity.autox.Buyer;
import com.boot.entity.autox.SrcVehicleSalesData;
import com.boot.entity.autox.Tracking;
import com.boot.entity.autox.Vehicle;
import com.boot.entity.qp.CXTransaction;
import com.boot.entity.qp.CXTransactionExtendedCustomFields;
import com.boot.entity.qp.PanelMember;
import com.boot.entity.qp.ResponseSet;
import com.boot.repository.autox.BuyerRepository;
import com.boot.repository.autox.CampaignRepository;
import com.boot.repository.autox.SrcVehicleSalesDataRepository;
import com.boot.repository.autox.TrackingRepository;
import com.boot.repository.autox.VehicleRepository;
import com.boot.repository.qp.CXTransactionExtendedCustomFieldsRepository;
import com.boot.repository.qp.CXTransactionRepository;
import com.boot.repository.qp.PanelMemberRepository;
import com.boot.repository.qp.ResponseSetRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
@RequiredArgsConstructor
public class TablesMigration implements ApplicationRunner {

	private final SrcVehicleSalesDataRepository srcVehicleSalesDataRepository;
	private final VehicleRepository vehicleRepository;
	private final BuyerRepository buyerRepository;
	private final TrackingRepository trackingRepository;
	private final CampaignRepository campaignRepository;

	private final PanelMemberRepository panelMemberRepository;
	private final ResponseSetRepository responseSetRepositor;
	private final CXTransactionRepository cxTransactionRepository;
	private final CXTransactionExtendedCustomFieldsRepository cxTransactionExtendedCustomFieldsRepository;

	@Value("${autox.program.id}")
	private Integer programID;
	@Value("${autox.program.vehicle.line.id}")
	private Integer vehicleLineID;
	@Value("${qp.user.id}")
	private Integer userID;
	@Value("${qp.cx.feedback.id}")
	private Integer cxFeedbackID;
	@Value("${qp.cx.feedback.panel.id}")
	private Integer panelID;
	@Value("${qp.cx.feedback.segment.id}")
	private Integer segmentID;
	@Value("${qp.cx.feedback.survey.id}")
	private Integer surveyID;
	@Value("${qp.cx.feedback.cxuser.id}")
	private Integer cxUserID;
	@Value("${qp.cx.feedback.applied.rules}")
	private String appliedRule;
	@Value("${qp.cx.feedback.workflow.process.id}")
	private Integer workflowProcessID;

	static Map<Integer, Integer> surveyStatusMap = Map.of(-1, 4, 0, 0, 1, 0, 2, 2, 3, 1, 4, 0, 5, 0, 6, 1);
	static Map<Integer, Integer> transactionStatusMap = Map.of(-1, 0, 0, 0, 1, 0, 2, 10, 3, 3, 4, 3, 5, 2, 6, 10);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("TablesMigration.run()");
		// get srcSalesVehicleData from cx-90_new
		List<SrcVehicleSalesData> srcVehicleSalesDataList = srcVehicleSalesDataRepository
				.findByProcessStatusNotLike("IGNORE%");
		log.info("srcVehicleSalesDataList size :: " + srcVehicleSalesDataList.size());
		// List<Campaign> campaignList =
		// campaignRepository.findAllByProgramId(programID);
		for (SrcVehicleSalesData srcVehicleSalesData : srcVehicleSalesDataList) {
			// ignore all the salesData which are not with NEW and UPD ProcessStatus
			Optional<Vehicle> optionalVehicle = vehicleRepository
					.findByVehicleIDAndVehicleLineID(srcVehicleSalesData.getVehicleID(), vehicleLineID);
			if (optionalVehicle.isPresent()) {
				Vehicle vehicle = optionalVehicle.get();
				Optional<Buyer> optionalBuyer = buyerRepository.findByVehicleID(vehicle.getVehicleID());
				if (optionalBuyer.isPresent()) {
					Buyer buyer = optionalBuyer.get();
					// get related tracking
					List<Tracking> trackingList = trackingRepository
							.findByBuyerIDAndCampaignIDIn(buyer.getBuyerID(), List.of(400, 401)) // campaignList.stream().map(Campaign::getCampaignId).toList())
							.stream().filter(tr -> tr.getInterviewStartDate() != null).toList();
					// log.info("tracking list size :: " + trackingList.size());
					// get panel member
					Optional<PanelMember> optionalPanelMember = panelMemberRepository
							.findByEmailAddress(srcVehicleSalesData.getBuyerEmailAddress());
					if (optionalPanelMember.isPresent()) {
						PanelMember panelMember = optionalPanelMember.get();
						for (Tracking tracking : trackingList) {
							// process only the tracking which has Submitted and Auto-Closed responses
							if (
//									(tracking.getInterviewID().equals(srcVehicleSalesData.getInterviewID()))
//									&& 
							(tracking.getSurveyStatusID() == 2 || tracking.getSurveyStatusID() == 6)) {
								// create response set
								ResponseSet responseSet = getResponseSet(tracking, panelMember);
								// create transaction
								CXTransaction cxTransaction = getCXTransaction(responseSet, panelMember,
										srcVehicleSalesData, tracking);
								// create transaction extended custom fields
								getCXTransactionExtendedCustomFields(cxTransaction, srcVehicleSalesData);
								log.info("tracking id inserted  :: " + tracking.getTrackingID());
								break;
							}
						}
					}
				}
			}
		}
		log.info("Done creating tables");
	}

	private CXTransactionExtendedCustomFields getCXTransactionExtendedCustomFields(CXTransaction cxTransaction,
			SrcVehicleSalesData srcVehicleSalesData) {
		CXTransactionExtendedCustomFields cxTransactionExtendedCustomFields = new CXTransactionExtendedCustomFields();
		cxTransactionExtendedCustomFields.setUserId(userID);
		cxTransactionExtendedCustomFields.setCxFeedbackId(cxFeedbackID);
		cxTransactionExtendedCustomFields.setCxTransactionId(cxTransaction.getId());
		cxTransactionExtendedCustomFields.setCxWorkflowId(workflowProcessID);//
		cxTransactionExtendedCustomFields.setCxWorkflowRuleId(workflowProcessID);
		cxTransactionExtendedCustomFields.setType(0);
		cxTransactionExtendedCustomFields.setTs(cxTransaction.getTs());
		// set custom variables
		return cxTransactionExtendedCustomFieldsRepository.save(cxTransactionExtendedCustomFields);
	}

	private CXTransaction getCXTransaction(ResponseSet responseSet, PanelMember panelMember,
			SrcVehicleSalesData srcVehicleSalesData, Tracking tracking) {
		CXTransaction cxTransaction = new CXTransaction();
		cxTransaction.setCxCustomerId(0);
		cxTransaction.setCxFeedbackId(cxFeedbackID);
		cxTransaction.setCxStoreId(segmentID);
		cxTransaction.setCxUserId(cxUserID);
		cxTransaction.setTypeId(0);
		cxTransaction.setTs(srcVehicleSalesData.getProcessDate());
		cxTransaction.setCxDate(srcVehicleSalesData.getLoadDate());
		cxTransaction.setCxPanelMemberId(panelMember.getId());
		cxTransaction.setTansactionBatchId(-99);
		cxTransaction.setTouchPointId(surveyID);
		cxTransaction.setStatus(0); //
		cxTransaction.setProductGroupId(0); //
		cxTransaction.setProductId(0); //
		cxTransaction.setMemberStatus(0); //
		cxTransaction.setCxDistributionBatchId(0); //
		cxTransaction.setSurveyId(surveyID);
		cxTransaction.setLanguageId(0); //
		cxTransaction.setOrgId(0); //
		cxTransaction.setTransactionOwnerEmails("");
		cxTransaction.setSendSurveyTs(panelMember.getCreationDate());//
		cxTransaction.setEmailTemplateId(0); //
		cxTransaction.setSmsTemplateId(0); //
		cxTransaction.setAppliedRules(appliedRule);
		cxTransaction.setInvitationSentTs(null); //
		cxTransaction.setNextReminderTs(null); //
		cxTransaction.setRestingTime(srcVehicleSalesData.getProcessDate());
		cxTransaction.setMaxReminderCount(0);//
		cxTransaction.setImportType(9); //
		cxTransaction.setWorkflowProcessId(workflowProcessID);
		cxTransaction.setPanelLogId(0);
		cxTransaction.setResponseSetId(responseSet.getId());
		cxTransaction.setResponseStatus(transactionStatusMap.get((int) tracking.getSurveyStatusID()));
		// set custom variables
		cxTransaction.setCustom1(String.valueOf(srcVehicleSalesData.getSrcVehicleSalesDataID()));
		cxTransaction.setCustom2(String.valueOf(srcVehicleSalesData.getId()));
		cxTransaction.setCustom3(String.valueOf(srcVehicleSalesData.getDistrict()));
		cxTransaction.setCustom4(String.valueOf(srcVehicleSalesData.getSaleTypeCode()));
		cxTransaction.setCustom5(String.valueOf(srcVehicleSalesData.getVin()));
		cxTransaction.setCustom6(String.valueOf(srcVehicleSalesData.getModelCode()));
		cxTransaction.setCustom7(String.valueOf(srcVehicleSalesData.getModelYear()));
		cxTransaction.setCustom8(String.valueOf(srcVehicleSalesData.getEmissionTypeCode()));
		cxTransaction.setCustom9(String.valueOf(srcVehicleSalesData.getExteriorColorCode()));
		cxTransaction.setCustom10(String.valueOf(srcVehicleSalesData.getInteriorColorCode()));
		cxTransaction.setCustom11(String.valueOf(srcVehicleSalesData.getSsn()));
		cxTransaction.setCustom12(String.valueOf(srcVehicleSalesData.getRetailDealerCode()));
		cxTransaction.setCustom13(String.valueOf(srcVehicleSalesData.getRetailSalesDate()));
		cxTransaction.setCustom14(String.valueOf(srcVehicleSalesData.getRetailProcessDate()));
		cxTransaction.setCustom15(String.valueOf(srcVehicleSalesData.getAccessoryCode()));
		cxTransaction.setCustom16(String.valueOf(srcVehicleSalesData.getShipToDealerCode()));
		cxTransaction.setCustom17(String.valueOf(srcVehicleSalesData.getMgrSsn()));
		cxTransaction.setCustom18(String.valueOf(srcVehicleSalesData.getSalesPersonFirstName()));
		cxTransaction.setCustom19(String.valueOf(srcVehicleSalesData.getSalesPersonLastName()));
		cxTransaction.setCustom20(String.valueOf(srcVehicleSalesData.getMiddleName()));
		cxTransaction.setCustom21(String.valueOf(srcVehicleSalesData.getBuyerWorkPhone()));
		cxTransaction.setCustom22(String.valueOf(srcVehicleSalesData.getBuyerWorkPhoneExt()));
		cxTransaction.setCustom23(String.valueOf(srcVehicleSalesData.getSaleTimeStamp()));
		cxTransaction.setCustom24(String.valueOf(srcVehicleSalesData.getFnclSourceCode()));
		cxTransaction.setCustom25(String.valueOf(srcVehicleSalesData.getEmpSupplierCode()));
		cxTransaction.setCustom26(String.valueOf(srcVehicleSalesData.getMscCode()));
		cxTransaction.setCustom27(String.valueOf(srcVehicleSalesData.getOdometer()));
		cxTransaction.setCustom28(String.valueOf(srcVehicleSalesData.getFill()));
		cxTransaction.setCustom29(String.valueOf(srcVehicleSalesData.getCustId()));
		cxTransaction.setCustom30(String.valueOf(srcVehicleSalesData.getNoContactFlag()));
		cxTransaction.setCustom31(String.valueOf(srcVehicleSalesData.getDoNotCallHomeFlag()));
		cxTransaction.setCustom32(String.valueOf(srcVehicleSalesData.getDoNotCallWorkFlag()));
		cxTransaction.setCustom33(String.valueOf(srcVehicleSalesData.getDoNotEmailFlag()));
		cxTransaction.setCustom34(String.valueOf(srcVehicleSalesData.getActProdDate()));
		cxTransaction.setCustom35(String.valueOf(srcVehicleSalesData.getFill21C()));
		return cxTransactionRepository.save(cxTransaction);
	}

	private ResponseSet getResponseSet(Tracking tracking, PanelMember panelMember) {
		ResponseSet rs = new ResponseSet();
		rs.setSurveyId(surveyID);
		rs.setT(tracking.getCreateDate());
		rs.setTimeTaken(
				(int) (tracking.getInterviewFinishDate().getTime() - tracking.getInterviewStartDate().getTime()));
		rs.setDuplicate(false);
		rs.setCustom1(String.valueOf(tracking.getTrackingID()));
		rs.setCustom2(String.valueOf(tracking.getInterviewID()));
		rs.setPanelMemberId(panelMember.getId());
		rs.setPanelId(panelID);
		rs.setCxBusinessUnitId(segmentID);
		rs.setUpdatedTs(tracking.getModifyDate());
		rs.setSurveyType((byte) 0); //
		// update user agent info from tblInterviewDeviceLogs while importing answers
		return responseSetRepositor.save(rs);
	}
}
