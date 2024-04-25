package com.boot.autox.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vh_srcVehicleSalesData")
@Getter
@Setter
@NoArgsConstructor
public class SrcVehicleSalesData {

	@Id
	private Integer srcVehicleSalesDataID;
	@Column(name = "ID")
	private Integer id;
	@Column(name = "District")
	private String district;
	@Column(name = "SaleTypeCode")
	private String saleTypeCode;
	@Column(name = "VIN")
	private String vin;
	@Column(name = "ModelCode")
	private String modelCode;
	@Column(name = "ModelYear")
	private String modelYear;
	@Column(name = "EmissionTypeCode")
	private String emissionTypeCode;
	@Column(name = "ExteriorColorCode")
	private String exteriorColorCode;
	@Column(name = "InteriorColorCode")
	private String interiorColorCode;
	@Column(name = "SSN")
	private String ssn;
	@Column(name = "RetailDealerCode")
	private String retailDealerCode;
	@Column(name = "RetailSalesDate")
	private String retailSalesDate;
	@Column(name = "RetailProcessDate")
	private String retailProcessDate;
	@Column(name = "AccessoryCode")
	private String accessoryCode;
	@Column(name = "ShipToDealerCode")
	private String shipToDealerCode;
	@Column(name = "MGRSSN")
	private String mgrssn;
	@Column(name = "SalesPersonLastName")
	private String salesPersonLastName;
	@Column(name = "SalesPersonFirstName")
	private String salesPersonFirstName;
	@Column(name = "MiddleName")
	private String middleName;
	@Column(name = "BuyerLastName")
	private String buyerLastName;
	@Column(name = "BuyerFirstName")
	private String buyerFirstName;
	@Column(name = "BuyerMiddleName")
	private String buyerMiddleName;
	@Column(name = "BuyerAddress1")
	private String buyerAddress1;
	@Column(name = "BuyerAddress2")
	private String buyerAddress2;
	@Column(name = "BuyerAddress3")
	private String buyerAddress3;
	@Column(name = "BuyerCity")
	private String buyerCity;
	@Column(name = "BuyerState")
	private String buyerState;
	@Column(name = "BuyerZipCode")
	private String buyerZipCode;
	@Column(name = "BuyerHomePhone")
	private String buyerHomePhone;
	@Column(name = "BuyerWorkPhone")
	private String buyerWorkPhone;
	@Column(name = "BuyerWorkPhoneExt")
	private String buyerWorkPhoneExt;
	@Column(name = "SaleTimeStamp")
	private String saleTimeStamp;
	@Column(name = "FNCLSourceCode")
	private String fnclSourceCode;
	@Column(name = "EmpSupplierCode")
	private String empSupplierCode;
	@Column(name = "Odometer")
	private String odometer;
	@Column(name = "Fill")
	private String fill;
	@Column(name = "BuyerEmailAddress")
	private String buyerEmailAddress;
	@Column(name = "CustID")
	private String custID;
	@Column(name = "NoContactFlag")
	private String noContactFlag;
	@Column(name = "DoNoCallHomeFlag")
	private String doNoCallHomeFlag;
	@Column(name = "DoNotEmailFlag")
	private String doNotEmailFlag;
	@Column(name = "ActProdDate")
	private String actProdDate;
	@Column(name = "Fill21C")
	private String fill21C;
	@Column(name = "MIS")
	private Integer mis;
	@Column(name = "FailedValidation")
	private Integer failedValidation;
	@Column(name = "JobFileId")
	private Integer jobFileId;
	@Column(name = "LoadDate")
	private LocalDateTime loadDate;
	@Column(name = "ProcessDate")
	private LocalDateTime processDate;
	@Column(name = "ProcessStatus")
	private String processStatus;
	@Column(name = "PIIPurged")
	private Integer pIIPurged;
	@Column(name = "VehicleID")
	private Integer vehicleID;

	// one vin has one vehicle id

}
