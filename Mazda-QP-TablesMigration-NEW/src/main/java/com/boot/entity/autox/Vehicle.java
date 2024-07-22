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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Vehicle", schema = "ods")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VehicleID", nullable = false)
	private int vehicleID;

	@Column(name = "ProgramID", nullable = false)
	private int programID;

	@Column(name = "VIN", nullable = false, length = 17)
	private String vin;

	@Column(name = "VehicleLineID", nullable = false)
	private int vehicleLineID;

	@Column(name = "Make", length = 50)
	private String make;

	@Column(name = "ModelYear")
	private Short modelYear;

	@Column(name = "Trim", length = 50)
	private String trim;

	@Column(name = "TrimDescription", length = 50)
	private String trimDescription;

	@Column(name = "Market", length = 50)
	private String market;

	@Column(name = "CreateDate", nullable = false)
	private Date createDate;

	@Column(name = "ModifyDate", nullable = false)
	private Date modifyDate;

	@Column(name = "BodyDescription", length = 60)
	private String bodyDescription;

	@Column(name = "EngineDescription", length = 60)
	private String engineDescription;

	@Column(name = "TransmissionDescription", length = 60)
	private String transmissionDescription;

	@Column(name = "Radio", length = 50)
	private String radio;

	@Column(name = "Navigation", length = 30)
	private String navigation;

	@Column(name = "Telephone", length = 30)
	private String telephone;

	@Column(name = "AirConditioning", length = 30)
	private String airConditioning;

	@Column(name = "CruiseControl", length = 50)
	private String cruiseControl;

	@Column(name = "MirrorScreen", length = 30)
	private String mirrorScreen;

	@Column(name = "MfrDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mfrDate;

	@Column(name = "migrationID")
	private Integer migrationID;

	@Column(name = "ModelCode", length = 35)
	private String modelCode;

	@Column(name = "InteriorCode", length = 35)
	private String interiorCode;

	@Column(name = "ExteriorCode", length = 35)
	private String exteriorCode;

	@Column(name = "OptionCode", length = 35)
	private String optionCode;

	@Column(name = "DealerCode", length = 50)
	private String dealerCode;

	@Column(name = "DealerName", length = 200)
	private String dealerName;

	@Column(name = "DealerRegion", length = 10)
	private String dealerRegion;

	@Column(name = "SalesRegion", length = 40)
	private String salesRegion;

	@Column(name = "SalesDistrict", length = 30)
	private String salesDistrict;

	@Column(name = "PlantDescription", length = 100)
	private String plantDescription;

	@Column(name = "TransmissionTypeCode", length = 50)
	private String transmissionTypeCode;

	@Column(name = "EngineTypeCode", length = 50)
	private String engineTypeCode;

	@Column(name = "CPOS", length = 50)
	private String cpos;

	@Column(name = "SalesTypeCode", length = 50)
	private String salesTypeCode;

	@Column(name = "TransferCaseTypeCode", length = 50)
	private String transferCaseTypeCode;

	@Column(name = "FrontAxleTypeCode", length = 50)
	private String frontAxleTypeCode;

	@Column(name = "RearAxleTypeCode", length = 50)
	private String rearAxleTypeCode;

	@Column(name = "ModelDescription", length = 256)
	private String modelDescription;

	@Column(name = "EntuneEquipped", length = 1)
	private String entuneEquipped;

	@Column(name = "TelematicsEnabled", length = 1)
	private String telematicsEnabled;

	@Column(name = "HeadUnitTypeCode", length = 10)
	private String headUnitTypeCode;

	@Column(name = "HeadUnitDescription", length = 50)
	private String headUnitDescription;

	@Column(name = "MaterialCode", length = 40)
	private String materialCode;

	@Column(name = "MaterialDescription", length = 100)
	private String materialDescription;

	@Column(name = "ExteriorColorCode", length = 40)
	private String exteriorColorCode;

	@Column(name = "ExteriorColorDescription", length = 100)
	private String exteriorColorDescription;

	@Column(name = "InteriorColorCode", length = 40)
	private String interiorColorCode;

	@Column(name = "InteriorColorDescription", length = 100)
	private String interiorColorDescription;

	@Column(name = "ShortVINYear", length = 10)
	private String shortVINYear;

	@Column(name = "ShortVINSeries", length = 10)
	private String shortVINSeries;

	@Column(name = "ShortVINFamily", length = 10)
	private String shortVINFamily;

	@Column(name = "ShortVINDoor", length = 10)
	private String shortVINDoor;

	@Column(name = "ShortVINTrim", length = 10)
	private String shortVINTrim;

	@Column(name = "ShortVINTrans", length = 10)
	private String shortVINTrans;

	@Column(name = "ShortVINDriveTrain", length = 255)
	private String shortVINDriveTrain;

	@Column(name = "ShortVINEngineType", length = 255)
	private String shortVINEngineType;

	@Column(name = "ShortVINEmissionType", length = 255)
	private String shortVINEmissionType;

	@Column(name = "PlantCode", length = 10)
	private String plantCode;

	@Column(name = "BlueLink", length = 50)
	private String blueLink;

	@Column(name = "WheelDrive", length = 50)
	private String wheelDrive;

	@Column(name = "DealerRegionCode", length = 50)
	private String dealerRegionCode;

	@Column(name = "Fuel", length = 50)
	private String fuel;

	@Column(name = "Cylinders", length = 50)
	private String cylinders;

	@Column(name = "SurveyTemplate", length = 50)
	private String surveyTemplate;

	@Column(name = "WifiEnabled", length = 2)
	private String wifiEnabled;

	@Column(name = "DriveType", length = 20)
	private String driveType;

	@Column(name = "KickSensor", length = 2)
	private String kickSensor;

	@Column(name = "PortInstalledEquipment", length = 150)
	private String portInstalledEquipment;

	@Column(name = "DealerReportingDistrictCode", length = 2)
	private String dealerReportingDistrictCode;

}
