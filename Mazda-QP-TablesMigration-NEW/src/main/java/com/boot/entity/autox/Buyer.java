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
@Table(name = "Buyer", schema = "ods")
public class Buyer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BuyerID", nullable = false)
	private int buyerID;

	@Column(name = "VehicleID", nullable = false)
	private int vehicleID;

	@Column(name = "RetailSalesDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date retailSalesDate;

	@Column(name = "BuyerName", nullable = false, length = 125)
	private String buyerName;

	@Column(name = "BuyerLastName", length = 60)
	private String buyerLastName;

	@Column(name = "BuyerFirstName", length = 60)
	private String buyerFirstName;

	@Column(name = "BuyerSalutation", length = 50)
	private String buyerSalutation;

	@Column(name = "BuyerMiddleName", length = 40)
	private String buyerMiddleName;

	@Column(name = "BuyerSuffix", length = 10)
	private String buyerSuffix;

	@Column(name = "BuyerHomeNumber", length = 40)
	private String buyerHomeNumber;

	@Column(name = "BuyerSMSNumber", length = 40)
	private String buyerSMSNumber;

	@Column(name = "BuyerAltNumber", length = 40)
	private String buyerAltNumber;

	@Column(name = "BuyerEmailAddress", length = 150)
	private String buyerEmailAddress;

	@Column(name = "BuyerSex", length = 20)
	private String buyerSex;

	@Column(name = "BuyerBirthday")
	@Temporal(TemporalType.TIMESTAMP)
	private Date buyerBirthday;

	@Column(name = "BuyerPostCode", length = 20)
	private String buyerPostCode;

	@Column(name = "BuyerAddress", length = 150)
	private String buyerAddress;

	@Column(name = "BuyerCity", length = 100)
	private String buyerCity;

	@Column(name = "BuyerStateProvince", length = 50)
	private String buyerStateProvince;

	@Column(name = "BuyerRegion", length = 50)
	private String buyerRegion;

	@Column(name = "BuyerCountry", length = 50)
	private String buyerCountry;

	@Column(name = "BuyerFaxNumber", length = 50)
	private String buyerFaxNumber;

	@Column(name = "MessageTypeID", nullable = false)
	private short messageTypeID;

	@Column(name = "IsEmployee", nullable = false)
	private byte isEmployee;

	@Column(name = "DoNotContact", nullable = false)
	private byte doNotContact;

	@Column(name = "OptOut", nullable = false)
	private byte optOut;

	@Column(name = "CampaignTrigger", length = 50)
	private String campaignTrigger;

	@Column(name = "CreateDate", nullable = false)
	private Date createDate;

	@Column(name = "ModifyDate", nullable = false)
	private Date modifyDate;

	@Column(name = "migrationID")
	private Integer migrationID;

	@Column(name = "ConsumerID")
	private Integer consumerID;

	@Column(name = "HouseholdID", length = 50)
	private String householdID;

	@Column(name = "PiiPurged", nullable = false)
	private boolean piiPurged;

	@Column(name = "BuyerIQSRegion", length = 50)
	private String buyerIQSRegion;

	@Column(name = "BuyerIQSCityTier", length = 50)
	private String buyerIQSCityTier;

	@Column(name = "BuyerSecondaryUnit", length = 50)
	private String buyerSecondaryUnit;

	@Column(name = "IsValidEmail")
	private Boolean isValidEmail;

	@Column(name = "BuyerEmailAddressDomain", length = 255)
	private String buyerEmailAddressDomain;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "VehicleID", insertable = false, updatable = false)
//	private Vehicle vehicle;

}
