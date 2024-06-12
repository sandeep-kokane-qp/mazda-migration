package com.boot.questionpro.entity;

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
@Table(name = "response_set")
@Getter
@Setter
@NoArgsConstructor
public class ResponseSet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "survey_id")
	private Integer surveyId;
	@Column(name = "respondent_id")
	private Integer respondentId;
	@Column(name = "ext_ref")
	private String extRef;
	@Column(name = "email_addr")
	private String emailAddr;
	private String ip;
	private Timestamp t;
	@Column(name = "time_taken")
	private Long timeTaken;
	@Column(name = "category_id")
	private Integer categoryId;
	private Integer duplicate;
	@Column(name = "email_group")
	private String emailGroup;
	@Column(name = "external_email_id")
	private Integer externalEmailId;
	@Column(name = "geo_code_country")
	private String geoCodeCountry;
	@Column(name = "geo_code_country_code")
	private String geoCodeCountryCode;
	@Column(name = "terminated_survey")
	private Integer terminatedSurvey;
	@Column(name = "geo_code_region")
	private String geoCodeRegion;
	@Column(name = "geo_code_city")
	private String geoCodeCity;
	@Column(name = "geo_code_area_code")
	private String geoCodeAreaCode;
	@Column(name = "geo_code_dma_code")
	private String geoCodeDmaCode;
	@Column(name = "restart_url")
	private String restartUrl;
	@Column(name = "inset_list")
	private String insetList;
	@Column(name = "panel_member_id")
	private Integer panelMemberId;
	@Column(name = "external_id")
	private Integer externalId;
	private Float weight;
	@Column(name = "quota_overlimit")
	private Integer quotaOverLimit;
	@Column(name = "panel_id")
	private Integer panelId;
	@Column(name = "referer_url")
	private String refererUrl;
	@Column(name = "referer_domain")
	private String refererDomain;
	@Column(name = "user_agent")
	private String userAgent;
	private Double longitude;
	private Double latitude;
	private Double radius;
	@Column(name = "cx_business_unit_id")
	private Integer cxBusinessUnitId;
	@Column(name = "survey_link_id")
	private Integer surveyLinkId;
	private Integer channel;
	@Column(name = "data_quality_flag")
	private Integer dataQualityFlag;
	@Column(name = "data_quality_score")
	private Double dataQualityScore;
	@Column(name = "updated_ts")
	private Timestamp updatedTs;
	@Column(name = "alternate_flip_order")
	private Integer alternateFlipOrder;
	@Column(name = "survey_type")
	private Integer surveyType;

	private String custom1;
	private String custom2;
	private String custom3;
	private String custom4;
	private String custom5;

}
