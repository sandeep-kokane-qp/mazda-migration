package com.boot.migration;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VehicleData {

	private Integer surveyTempID;
	private Integer isTestInterview;
	private Integer srcVehicleSalesDataID;
	private String id;
	private String district;
	private String saleTypeCode;
	private String vin;
	private String modelCode;
	private String modelYear;
	private String emissionTypeCode;
	private String exteriorColorCode;
	private String interiorColorCode;
	private String ssn;
	private String retailDealerCode;
	private String retailSalesDate;
	private String retailProcessDate;
	private String accessoryCode;
	private String shipToDealerCode;
	private String mgrssn;
	private String salesPersonLastName;
	private String salesPersonFirstName;
	private String middleName;
	private String buyerLastName;
	private String buyerFirstName;
	private String buyerMiddleName;
	private String buyerAddress1;
	private String buyerAddress2;
	private String buyerAddress3;
	private String buyerCity;
	private String buyerState;
	private String buyerZipCode;
	private String buyerHomePhone;
	private String buyerWorkPhone;
	private String buyerWorkPhoneExt;
	private String saleTimeStamp;
	private String fnclSourceCode;
	private String empSupplierCode;
	private String mscCode;
	private String odometer;
	private String fill;
	private String buyerEmailAddress;
	private String custID;
	private String noContactFlag;
	private String doNotCallHomeFlag;
	private String doNotCallWorkFlag;
	private String doNotEmailFlag;
	private String actProdDate;
	private String fill21C;
	private Integer mis;

	// Vehicle Table data
	private Integer vehicleID;
	private Integer programID;
	private Integer VehicleLineId;
	private String make;
	private String trim;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	private String interiorCode;
	private String exteriorCode;
	private String optionCode;

	// Buyer Table Data
	private Integer buyerId;
	private String buyerName;
	private String buyerHomeNumber;
	private String buyerSMSNumber;
	private String buyerAltNumber;
	private LocalDateTime buyerBirthday;
	private String buyerPostCode;
	private String buyerAddress;
	private String buyerStateProvince;
	private String buyerRegion;
	private String buyerCountry;
	private Integer optOut;
	private LocalDateTime buyerCreateDate;
	private String buyerEmailAddressDomain;

	// Tracking Table Data
	private Integer trackingID;
	private Integer surveyStatusID;
	private Integer interviewID;
	private LocalDateTime interviewStartDate;
	private LocalDateTime interviewFinishDate;

	private Integer campaignID;
	private LocalDateTime trackCreateDate;
	private LocalDateTime trackModifyDate;

}
