package com.boot.migration;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.boot.questionpro.entity.PanelMember;
import com.boot.questionpro.repo.CXTransactionExtendedCFRepo;
import com.boot.questionpro.repo.CXTransactionRepo;
import com.boot.questionpro.repo.PanelMemberRepo;
import com.boot.questionpro.repo.ResponseSetRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class VehicleDataItemWriter implements ItemWriter<VehicleData> {

	private final PanelMemberRepo panelMemberRepo;
	private final ResponseSetRepo responseSetRepo;
	private final CXTransactionRepo cxTransactionRepo;
	private final CXTransactionExtendedCFRepo cxTransactionExtendedCFRepo;

	@Value("${autox.survey.template.id}")
	private Integer surveyTempId;
	@Value("${qp.user.id}")
	private Integer userId;
	@Value("${qp.cx.feedback.id}")
	private Integer cxFeedbackId;
	@Value("${qp.cx.feedback.survey.id}")
	private Integer cxSurveyId;
	@Value("${qp.cx.feedback.cxuser.id}")
	private Integer cxUserId;
	@Value("${qp.cx.feedback.segment.id}")
	private Integer cxSegmentId;
	@Value("${qp.cx.feedback.panel.id}")
	private Integer panelId;
	@Value("${qp.cx.feedback.applied.rules}")
	private String appliedRules;
	@Value("${qp.cx.feedback.workflow.process.id}")
	private Integer workflowProcessId;

	static Map<Integer, Integer> surveyStatusMap = Map.of(-1, 4, 0, 0, 1, 0, 2, 2, 3, 1, 4, 0, 5, 0, 6, 1);

	@Override
	public void write(List<? extends VehicleData> items) throws Exception {
		for (VehicleData vehicleData : items) {
//			 create panel_member
			PanelMember pm = null;
			if (!PanelMemberStore.getPanelMembersMap().containsKey(String.valueOf(vehicleData.getBuyerId()))) {
				pm = new PanelMember();
				pm.setPanelId(panelId);
				pm.setUserId(userId);
				pm.setEmailAddress(vehicleData.getBuyerEmailAddress());
				pm.setCreationDate(vehicleData.getBuyerCreateDate());
				pm.setFirstname(vehicleData.getBuyerFirstName());
				pm.setMiddlename(vehicleData.getBuyerMiddleName());
				pm.setLastname(vehicleData.getBuyerLastName());
				pm.setDomainName(vehicleData.getBuyerEmailAddressDomain());
				pm.setAddress1(vehicleData.getBuyerAddress1());
				pm.setAddress2(vehicleData.getBuyerAddress2());
				pm.setCity(vehicleData.getBuyerCity());
				pm.setState(vehicleData.getBuyerState());
				pm.setZipcode(vehicleData.getBuyerZipCode());
				pm.setCountry(vehicleData.getBuyerCountry());
				pm.setMobileNumber(vehicleData.getBuyerHomePhone());
				pm.setBirthday(vehicleData.getBuyerBirthday() != null
						? Date.valueOf(vehicleData.getBuyerBirthday().toLocalDate())
						: null);
				pm.setCustom1(String.valueOf(vehicleData.getBuyerId()));
				// save panelmember
				pm = panelMemberRepo.save(pm);
				PanelMemberStore.putPanelMember(pm);
				log.info("saved for buyerid : " + vehicleData.getBuyerId());
			}
//			else {
//				pm = PanelMemberStore.getPanelMember(String.valueOf(vehicleData.getBuyerId()));
//
//			}

//			 create responses set
			/**
			 * ResponseSet responseSet = new ResponseSet();
			 * responseSet.setSurveyId(cxSurveyId); responseSet.setRespondentId(pm.getId());
			 * responseSet.setEmailAddr(pm.getEmailAddress());
			 * responseSet.setPanelId(panelId); responseSet.setPanelMemberId(pm.getId());
			 * responseSet.setCxBusinessUnitId(cxSegmentId);
			 * responseSet.setCustom1(String.valueOf(vehicleData.getTrackingID()));
			 * responseSet.setCustom2(String.valueOf(vehicleData.getInterviewID()));
			 * responseSet.setUpdatedTs(Timestamp.valueOf(vehicleData.getTrackModifyDate()));
			 * responseSet.setSurveyType(3);
			 * responseSet.setT(Timestamp.valueOf(vehicleData.getTrackCreateDate()));
			 * responseSet.setTimeTaken(Duration
			 * .between(vehicleData.getInterviewStartDate(),
			 * vehicleData.getInterviewFinishDate()).getSeconds());
			 * 
			 * // save responseset ResponseSet savedResponseSet =
			 * responseSetRepo.save(responseSet);
			 * 
			 * // create transaction CXTransaction cxTransaction = new CXTransaction();
			 * cxTransaction.setCxCustomerId(0);
			 * cxTransaction.setCxFeedbackId(cxFeedbackId);
			 * cxTransaction.setCxStoreId(cxSegmentId); cxTransaction.setCxUserId(cxUserId);
			 * cxTransaction.setTypeId(0);
			 * cxTransaction.setTs(Timestamp.valueOf(vehicleData.getSaleTimeStamp()));
			 * cxTransaction.setCxDate(Timestamp.valueOf(vehicleData.getTrackCreateDate()));
			 * cxTransaction.setTouchPointId(cxSurveyId);
			 * cxTransaction.setSurveyId(cxSurveyId);
			 * cxTransaction.setResponseSetId(savedResponseSet.getId());
			 * cxTransaction.setAppliedRules(appliedRules);
			 * cxTransaction.setWorkflowProcessId(workflowProcessId);
			 * cxTransaction.setImportType(9);
			 * cxTransaction.setResponseStatus(surveyStatusMap.get(vehicleData.getSurveyStatusID()));
			 * 
			 * cxTransaction.setCustom1(String.valueOf(vehicleData.getSrcVehicleSalesDataID()));
			 * cxTransaction.setCustom2(vehicleData.getId());
			 * cxTransaction.setCustom3(vehicleData.getDistrict());
			 * cxTransaction.setCustom4(vehicleData.getSaleTypeCode());
			 * cxTransaction.setCustom5(vehicleData.getVin());
			 * cxTransaction.setCustom6(vehicleData.getModelCode());
			 * cxTransaction.setCustom7(vehicleData.getModelYear());
			 * cxTransaction.setCustom8(vehicleData.getEmissionTypeCode());
			 * cxTransaction.setCustom9(vehicleData.getExteriorColorCode());
			 * cxTransaction.setCustom10(vehicleData.getInteriorColorCode());
			 * cxTransaction.setCustom11(vehicleData.getSsn());
			 * cxTransaction.setCustom12(vehicleData.getRetailDealerCode());
			 * cxTransaction.setCustom13(vehicleData.getRetailSalesDate());
			 * cxTransaction.setCustom14(vehicleData.getRetailProcessDate());
			 * cxTransaction.setCustom15(vehicleData.getAccessoryCode());
			 * cxTransaction.setCustom16(vehicleData.getShipToDealerCode());
			 * cxTransaction.setCustom17(vehicleData.getMgrssn());
			 * cxTransaction.setCustom18(vehicleData.getSalesPersonLastName());
			 * cxTransaction.setCustom19(vehicleData.getSalesPersonFirstName());
			 * cxTransaction.setCustom20(vehicleData.getMiddleName());
			 * cxTransaction.setCustom21(vehicleData.getBuyerWorkPhone());
			 * cxTransaction.setCustom22(vehicleData.getBuyerWorkPhoneExt());
			 * cxTransaction.setCustom23(vehicleData.getSaleTimeStamp());
			 * cxTransaction.setCustom24(vehicleData.getFnclSourceCode());
			 * cxTransaction.setCustom25(vehicleData.getEmpSupplierCode());
			 * cxTransaction.setCustom26(vehicleData.getMscCode());
			 * cxTransaction.setCustom27(vehicleData.getOdometer());
			 * cxTransaction.setCustom28(vehicleData.getFill());
			 * cxTransaction.setCustom29(vehicleData.getCustID());
			 * cxTransaction.setCustom30(vehicleData.getNoContactFlag());
			 * cxTransaction.setCustom31(vehicleData.getDoNotCallHomeFlag());
			 * cxTransaction.setCustom32(vehicleData.getDoNotCallWorkFlag());
			 * cxTransaction.setCustom33(vehicleData.getDoNotEmailFlag());
			 * cxTransaction.setCustom34(vehicleData.getActProdDate());
			 * cxTransaction.setCustom35(vehicleData.getFill21C()); // save transaction
			 * CXTransaction savedCxTransaction = cxTransactionRepo.save(cxTransaction);
			 * 
			 * // Custom Fields Details CXTransactionExtendedCustomFields
			 * extendedCustomFields = new CXTransactionExtendedCustomFields();
			 * extendedCustomFields.setUserId(userId);
			 * extendedCustomFields.setCxFeedbackId(cxFeedbackId);
			 * extendedCustomFields.setCxTransactionId(savedCxTransaction.getId());
			 * extendedCustomFields.setCxWorkflowId(cxTransaction.getWorkflowProcessId());
			 * extendedCustomFields.setType(cxTransaction.getTypeId());
			 * cxTransactionExtendedCFRepo.save(extendedCustomFields);
			 * 
			 * log.info("updated for srcDateId: " + vehicleData.getSrcVehicleSalesDataID());
			 **/
		}

	}

}
