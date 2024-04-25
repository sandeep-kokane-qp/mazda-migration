package com.boot.migration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class VehicleDataRowMapper implements RowMapper<VehicleData> {

	@Override
	public VehicleData mapRow(ResultSet rs, int rowNum) throws SQLException {
		VehicleData vh = new VehicleData();
		vh.setSrcVehicleSalesDataID(rs.getInt("srcVehicleSalesDataID"));
		vh.setId(rs.getString("ID"));
		vh.setDistrict(rs.getString("District"));
		vh.setSaleTypeCode(rs.getString("SaleTypeCode"));
		vh.setVin(rs.getString("VIN"));
		vh.setModelCode(rs.getString("ModelCode"));
		vh.setModelYear(rs.getString("ModelYear"));
		vh.setEmissionTypeCode(rs.getString("EmissionTypeCode"));
		vh.setExteriorColorCode(rs.getString("ExteriorColorCode"));
		vh.setInteriorColorCode(rs.getString("InteriorColorCode"));
		vh.setSsn(rs.getString("SSN"));
		vh.setRetailDealerCode(rs.getString("RetailDealerCode"));
		vh.setRetailSalesDate(rs.getString("RetailSalesDate"));
		vh.setRetailProcessDate(rs.getString("RetailProcessDate"));
		vh.setAccessoryCode(rs.getString("AccessoryCode"));
		vh.setShipToDealerCode(rs.getString("ShipToDealerCode"));
		vh.setMgrssn(rs.getString("MGRSSN"));
		vh.setSalesPersonLastName(rs.getString("SalesPersonLastName"));
		vh.setSalesPersonFirstName(rs.getString("SalesPersonFirstName"));
		vh.setMiddleName(rs.getString("MiddleName"));
		vh.setBuyerLastName(rs.getString("BuyerLastName"));
		vh.setBuyerFirstName(rs.getString("BuyerFirstName"));
		vh.setBuyerMiddleName(rs.getString("BuyerMiddleName"));
		vh.setBuyerAddress1(rs.getString("BuyerAddress1"));
		vh.setBuyerAddress2(rs.getString("BuyerAddress2"));
		vh.setBuyerAddress3(rs.getString("BuyerAddress3"));
		vh.setBuyerCity(rs.getString("BuyerCity"));
		vh.setBuyerState(rs.getString("BuyerState"));
		vh.setBuyerZipCode(rs.getString("BuyerZipCode"));
		vh.setBuyerHomePhone(rs.getString("BuyerHomePhone"));
		vh.setBuyerWorkPhone(rs.getString("BuyerWorkPhone"));
		vh.setBuyerWorkPhoneExt(rs.getString("BuyerWorkPhoneExt"));
		vh.setSaleTimeStamp(rs.getString("SaleTimeStamp"));
		vh.setFnclSourceCode(rs.getString("FNCLSourceCode"));
		vh.setEmpSupplierCode(rs.getString("EmpSupplierCode"));
		vh.setMscCode(rs.getString("MSCCode"));
		vh.setOdometer(rs.getString("Odometer"));
		vh.setFill(rs.getString("Fill"));
		vh.setBuyerEmailAddress(rs.getString("BuyerEmailAddress"));
		vh.setCustID(rs.getString("CustID"));
		vh.setNoContactFlag(rs.getString("NoContactFlag"));
		vh.setDoNotCallHomeFlag(rs.getString("DoNotCallHomeFlag"));
		vh.setDoNotCallWorkFlag(rs.getString("DoNotCallWorkFlag"));
		vh.setDoNotEmailFlag(rs.getString("DoNotEmailFlag"));
		vh.setActProdDate(rs.getString("ActProdDate"));
		vh.setFill21C(rs.getString("Fill21C"));
		vh.setMis(rs.getInt("MIS"));

		// Vehicle Table data
		vh.setVehicleID(rs.getInt("VehicleID"));
		vh.setProgramID(rs.getInt("ProgramID"));

		/// Buyer Table data
		vh.setBuyerId(rs.getInt("BuyerID"));
		vh.setBuyerName(rs.getString("BuyerName"));
		vh.setBuyerHomeNumber(rs.getString("BuyerHomeNumber"));
		vh.setBuyerSMSNumber(rs.getString("BuyerSMSNumber"));
		vh.setBuyerAltNumber(rs.getString("BuyerAltNumber"));
		vh.setBuyerBirthday(
				rs.getString("BuyerBirthday") != null ? LocalDateTime.parse(rs.getString("BuyerBirthday")) : null);
		vh.setBuyerPostCode(rs.getString("BuyerPostCode"));
		vh.setBuyerAddress(rs.getString("BuyerAddress"));
		vh.setBuyerStateProvince(rs.getString("BuyerStateProvince"));
		vh.setBuyerRegion(rs.getString("BuyerRegion"));
		vh.setBuyerCountry(rs.getString("BuyerCountry"));
		vh.setOptOut(rs.getInt("OptOut"));
		String buyerCreateDate = rs.getString("BuyerCreateDate");
		vh.setBuyerCreateDate(buyerCreateDate != null
				? LocalDateTime.parse(buyerCreateDate.substring(0, buyerCreateDate.lastIndexOf(".")),
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
				: null);
		vh.setBuyerEmailAddressDomain(rs.getString("BuyerEmailAddressDomain"));

		// Tracking Table Data
		vh.setTrackingID(rs.getInt("TrackingID"));
		vh.setSurveyStatusID(rs.getInt("SurveyStatusID"));
		vh.setInterviewID(rs.getInt("InterviewID"));
		String interviewStartDate = rs.getString("InterviewStartDate");
		vh.setInterviewStartDate(
				LocalDateTime.parse(interviewStartDate.substring(0, interviewStartDate.lastIndexOf(".")),
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		String interviewFinishDate = rs.getString("InterviewFinishDate");
		vh.setInterviewFinishDate(
				LocalDateTime.parse(interviewFinishDate.substring(0, interviewFinishDate.lastIndexOf(".")),
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		vh.setCampaignID(rs.getInt("CampaignID"));
		String trackCreateDate = rs.getString("TrackCreateDate");
		vh.setTrackCreateDate(LocalDateTime.parse(trackCreateDate.substring(0, trackCreateDate.lastIndexOf(".")),
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		String modifyDate = rs.getString("TrackModifyDate");
		vh.setTrackModifyDate(LocalDateTime.parse(modifyDate.substring(0, modifyDate.lastIndexOf(".")),
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		return vh;

	}

}
