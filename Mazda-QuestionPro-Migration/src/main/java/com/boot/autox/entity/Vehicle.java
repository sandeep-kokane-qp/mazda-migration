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
@Table(name = "vh_Vehicle")
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {

	// one vehicle has one buyer

	@Id
	@Column(name = "VehicleID")
	private Integer vehicleID;
	@Column(name = "ProgramID")
	private Integer programID;
	@Column(name = "VIN")
	private String vin;
	@Column(name = "VehicleLineId")
	private Integer VehicleLineId;
	@Column(name = "Make")
	private String make;
	@Column(name = "ModelYear")
	private Integer modelYear;
	@Column(name = "Trim")
	private String trim;
	@Column(name = "TrimDescription")
	private String trimDescription;
	@Column(name = "Market")
	private String market;
	@Column(name = "CreateDate")
	private LocalDateTime createDate;
	@Column(name = "ModifyDate")
	private LocalDateTime modifyDate;
	@Column(name = "BodyDescription")
	private String bodyDescription;
	@Column(name = "EngineDescription")
	private String engineDescription;
	@Column(name = "TransmissionDescription")
	private String transmissionDescription;
	@Column(name = "Radio")
	private String radio;
	@Column(name = "Navigation")
	private String navigation;
	@Column(name = "Telephone")
	private String telephone;
	@Column(name = "AirConditioning")
	private String airConditioning;
	@Column(name = "CruiseControl")
	private String cruiseControl;
	@Column(name = "MirrorScreen")
	private String mirrorScreen;
	@Column(name = "MfrDate")
	private LocalDateTime mfrDate;
	@Column(name = "migrationID")
	private Integer migrationID;
	@Column(name = "ModelCode")
	private String modelCode;
	@Column(name = "InteriorCode")
	private String interiorCode;
	@Column(name = "ExteriorCode")
	private String exteriorCode;
	@Column(name = "OptionCode")
	private String optionCode;
	@Column(name = "DealerCode")
	private String dealerCode;
	@Column(name = "DealerName")
	private String dealerName;
	@Column(name = "DealerRegion")
	private String dealerRegion;
	@Column(name = "SalesRegion")
	private String salesRegion;
	@Column(name = "SalesDistrict")
	private String salesDistrict;

}
