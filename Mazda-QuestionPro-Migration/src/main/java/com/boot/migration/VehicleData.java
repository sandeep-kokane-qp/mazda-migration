package com.boot.migration;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VehicleData {

	private Integer srcVehicleSalesDataID;
	private Integer id;
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
	private String odometer;
	private String fill;
	private String buyerEmailAddress;
	private String custID;
	private String noContactFlag;
	private String doNoCallHomeFlag;
	private String doNotEmailFlag;
	private String actProdDate;
	private String fill21C;
	private Integer mis;
	private Integer failedValidation;
	private Integer jobFileId;
	private LocalDateTime loadDate;
	private LocalDateTime processDate;
	private String processStatus;
	private Integer pIIPurged;

	// Vehicle Table data
	private Integer vehicleID;
	private Integer programID;
	private Integer VehicleLineId;
	private String make;
	private String trim;
	private String trimDescription;
	private String market;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	private String bodyDescription;
	private String engineDescription;
	private String transmissionDescription;
	private String radio;
	private String navigation;
	private String telephone;
	private String airConditioning;
	private String cruiseControl;
	private String mirrorScreen;
	private LocalDateTime mfrDate;
	private Integer migrationID;
	private String interiorCode;
	private String exteriorCode;
	private String optionCode;
	private String dealerCode;
	private String dealerName;
	private String dealerRegion;
	private String salesRegion;
	private String salesDistrict;

	// Buyer Table Data

	private Integer buyerId;
	private Integer vehicleId;
	private String buyerName;
	private String buyerSalutation;
	private String buyerSuffix;
	private String buyerHomeNumber;
	private String buyerSMSNumber;
	private String buyerAltNumber;
	private String buyerSex;
	private LocalDateTime buyerBirthday;
	private String buyerPostCode;
	private String buyerAddress;
	private String buyerStateProvince;
	private String buyerRegion;
	private String buyerCountry;
	private String buyerFaxNumber;
	private Integer messageTypeId;
	private Integer isEmployee;
	private Integer doNotContact;
	private Integer optOut;
	private String campaignTrigger;
	private LocalDateTime buyerCreateDate;
	private Integer migrationId;
	private Integer consumerId;
	private String householdId;
	private Integer piiPurged;
	private String buyerIQSRegion;
	private String buyerISQCityTier;
	private String buyerSecondaryUnit;
	private Integer isValidEmail;
	private String buyerEmailAddressDomain;

	// Tracking Table Data
	private Integer trackingID;
	private Integer buyerID;
	private Integer surveyStatusID;
	private Integer interviewID;
	private LocalDateTime interviewStartDate;
	private LocalDateTime interviewFinishDate;
	private Integer inviteSent;
	private Integer reminderSent;
	private Integer thankYouSent;
	private Integer campaignID;
	private LocalDateTime trackCreateDate;
	private LocalDateTime trackingModifyDate;

}
