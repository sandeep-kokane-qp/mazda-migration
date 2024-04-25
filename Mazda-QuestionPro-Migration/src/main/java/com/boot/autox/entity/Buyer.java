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
@Table(name = "vh_buyer")
@Getter
@Setter
@NoArgsConstructor
public class Buyer {

	@Id
	@Column(name = "BuyerID")
	private Integer buyerId;
	@Column(name = "VehicleID")
	private Integer vehicleId;
	@Column(name = "RetailSalesDate")
	private LocalDateTime retailSalesDate;
	@Column(name = "BuyerName")
	private String buyerName;
	@Column(name = "BuyerLastName")
	private String buyerLastName;
	@Column(name = "BuyerSalutation")
	private String buyerSalutation;
	@Column(name = "BuyerMiddleName")
	private String buyerMiddleName;
	@Column(name = "BuyerSuffix")
	private String buyerSuffix;
	@Column(name = "BuyerHomeNumber")
	private String buyerHomeNumber;
	@Column(name = "BuyerSMSNumber")
	private String buyerSMSNumber;
	@Column(name = "BuyerAltNumber")
	private String buyerAltNumber;
	@Column(name = "BuyerEmailAddress")
	private String buyerEmailAddress;
	@Column(name = "BuyerSex")
	private String buyerSex;
	@Column(name = "BuyerBirthday")
	private LocalDateTime buyerBirthday;
	@Column(name = "BuyerPostCode")
	private String buyerPostCode;
	@Column(name = "BuyerAddress")
	private String buyerAddress;
	@Column(name = "BuyerCity")
	private String buyerCity;
	@Column(name = "BuyerStateProvince")
	private String buyerStateProvince;
	@Column(name = "BuyerRegion")
	private String buyerRegion;
	@Column(name = "BuyerCountry")
	private String buyerCountry;
	@Column(name = "BuyerFaxNumber")
	private String buyerFaxNumber;
	@Column(name = "MessageTypeID")
	private Integer messageTypeId;
	@Column(name = "IsEmployee")
	private Integer isEmployee;
	@Column(name = "DoNotContact")
	private Integer doNotContact;
	@Column(name = "OptOut")
	private Integer optOut;
	@Column(name = "CampaignTrigger")
	private String campaignTrigger;
	private LocalDateTime createDate;
	@Column(name = "MigrationID")
	private Integer migrationId;
	@Column(name = "ConsumerID")
	private Integer consumerId;
	@Column(name = "HouseHoldID")
	private String householdId;
	@Column(name = "PiiPurged")
	private Integer piiPurged;
	@Column(name = "BuyerISQRegion")
	private String buyerIQSRegion;
	@Column(name = "BuyerISQCityTier")
	private String buyerISQCityTier;
	@Column(name = "BuyerSecondaryUnit")
	private String buyerSecondaryUnit;
	@Column(name = "IsValidEmail")
	private Integer isValidEmail;
	@Column(name = "BuyerEmailAddressDomain")
	private String buyerEmailAddressDomain;

}
