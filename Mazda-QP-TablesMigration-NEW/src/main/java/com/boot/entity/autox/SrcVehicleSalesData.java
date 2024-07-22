package com.boot.entity.autox;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "srcVehicleSalesDataCX_90", schema = "mazdaus")
@Getter
@Setter
public class SrcVehicleSalesData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "srcVehicleSalesDataID", nullable = false)
	private int srcVehicleSalesDataID;

	@Column(name = "ID", length = 2)
	private String id;

	@Column(name = "District", length = 50)
	private String district;

	@Column(name = "SaleTypeCode", length = 2)
	private String saleTypeCode;

	@Column(name = "VIN", length = 17)
	private String vin;

	@Column(name = "ModelCode", length = 12)
	private String modelCode;

	@Column(name = "ModelYear", length = 4)
	private String modelYear;

	@Column(name = "EmissionTypeCode", length = 2)
	private String emissionTypeCode;

	@Column(name = "ExteriorColorCode", length = 3)
	private String exteriorColorCode;

	@Column(name = "InteriorColorCode", length = 3)
	private String interiorColorCode;

	@Column(name = "SSN", length = 9)
	private String ssn;

	@Column(name = "RetailDealerCode", length = 5)
	private String retailDealerCode;

	@Column(name = "RetailSalesDate", length = 6)
	private String retailSalesDate;

	@Column(name = "RetailProcessDate", length = 6)
	private String retailProcessDate;

	@Column(name = "AccessoryCode", length = 60)
	private String accessoryCode;

	@Column(name = "ShipToDealerCode", length = 5)
	private String shipToDealerCode;

	@Column(name = "MGRSSN", length = 9)
	private String mgrSsn;

	@Column(name = "SalesPersonLastName", length = 20)
	private String salesPersonLastName;

	@Column(name = "SalesPersonFirstName", length = 15)
	private String salesPersonFirstName;

	@Column(name = "MiddleName", length = 15)
	private String middleName;

	@Column(name = "BuyerLastName", length = 40)
	private String buyerLastName;

	@Column(name = "BuyerFirstName", length = 40)
	private String buyerFirstName;

	@Column(name = "BuyerMiddleName", length = 15)
	private String buyerMiddleName;

	@Column(name = "BuyerAddress1", length = 40)
	private String buyerAddress1;

	@Column(name = "BuyerAddress2", length = 40)
	private String buyerAddress2;

	@Column(name = "BuyerAddress3", length = 40)
	private String buyerAddress3;

	@Column(name = "BuyerCity", length = 25)
	private String buyerCity;

	@Column(name = "BuyerState", length = 3)
	private String buyerState;

	@Column(name = "BuyerZipCode", length = 9)
	private String buyerZipCode;

	@Column(name = "BuyerHomePhone", length = 40)
	private String buyerHomePhone;

	@Column(name = "BuyerWorkPhone", length = 40)
	private String buyerWorkPhone;

	@Column(name = "BuyerWorkPhoneExt", length = 40)
	private String buyerWorkPhoneExt;

	@Column(name = "SaleTimeStamp", length = 26)
	private String saleTimeStamp;

	@Column(name = "FNCLSourceCode", length = 2)
	private String fnclSourceCode;

	@Column(name = "EmpSupplierCode", length = 2)
	private String empSupplierCode;

	@Column(name = "MSCCode", length = 7)
	private String mscCode;

	@Column(name = "Odometer", length = 7)
	private String odometer;

	@Column(name = "Fill", length = 20)
	private String fill;

	@Column(name = "BuyerEmailAddress", length = 100)
	private String buyerEmailAddress;

	@Column(name = "CustID", length = 10)
	private String custId;

	@Column(name = "NoContactFlag", length = 2)
	private String noContactFlag;

	@Column(name = "DoNotCallHomeFlag", length = 2)
	private String doNotCallHomeFlag;

	@Column(name = "DoNotCallWorkFlag", length = 2)
	private String doNotCallWorkFlag;

	@Column(name = "DoNotEmailFlag", length = 2)
	private String doNotEmailFlag;

	@Column(name = "ActProdDate", length = 10)
	private String actProdDate;

	@Column(name = "Fill21C", length = 16)
	private String fill21C;

	@Column(name = "MIS")
	private Integer mis;

	@Column(name = "FailedValidation")
	private Boolean failedValidation;

	@Column(name = "JobFileID", nullable = false)
	private int jobFileID;

	@Column(name = "LoadDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date loadDate;

	@Column(name = "ProcessDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date processDate;

	@Column(name = "ProcessStatus", length = 255)
	private String processStatus;

	@Column(name = "PIIPurged", nullable = false)
	private boolean piiPurged;

	@Column(name = "VehicleID")
	private Integer vehicleID;

//	@Column(name = "InterviewID")
//	private Integer interviewID;

}
