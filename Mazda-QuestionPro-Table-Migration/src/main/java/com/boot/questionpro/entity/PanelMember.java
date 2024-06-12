package com.boot.questionpro.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "panel_member")
@Getter
@Setter
@NoArgsConstructor
public class PanelMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "panel_id")
	private Integer panelId;
	private Integer status;
	@Column(name = "email_address")
	private String emailAddress;
	private String password;
	@Column(name = "creation_date")
	private Date creationDate;
	@Column(name = "country_code_weight")
	private Float countryCodeWeight;
	private String firstname;
	private String middlename;
	private String lastname;
	@Column(name = "last_app_used")
	private Timestamp lastAppUsed;

	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "domain_name")
	private String domainName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	@Column(name = "zipcode_4")
	private String zipCode4;
	@Column(name = "mobile_number")
	private String mobileNumber;
	private String username;
	private String birthday;
	@Column(name = "profile_pic_updated")
	private Integer profilePicUpdated;

	private String custom1;
	private String custom2;
	private String custom3;
	private String custom4;
	private String custom5;

}
