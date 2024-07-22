package com.boot.entity.qp;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "qp_response_set")
@Getter
@Setter
@NoArgsConstructor
public class ResponseSet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0", name = "survey_id")
	private int surveyId;

	@Column(columnDefinition = "INT DEFAULT NULL", name = "respondent_id")
	private Integer respondentId;

	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL", name = "ext_ref")
	private String extRef;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL", name = "email_addr")
	private String emailAddr;

	@Column(length = 46, columnDefinition = "VARCHAR(46) DEFAULT NULL")
	private String ip;
	@Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
	private Date t;
	@Column(columnDefinition = "INT DEFAULT NULL", name = "time_taken")
	private Integer timeTaken;
	@Column(columnDefinition = "INT DEFAULT NULL", name = "category_id")
	private Integer categoryId;
	@Column(columnDefinition = "BIGINT DEFAULT 0", name = "external_id")
	private long externalId;
	@Column(columnDefinition = "BIT DEFAULT 0")
	private boolean duplicate;
	@Column(length = 30, columnDefinition = "VARCHAR(30) DEFAULT NULL", name = "email_group")
	private String emailGroup;
	@Column(columnDefinition = "INT DEFAULT NULL", name = "external_email_id")
	private Integer externalEmailId;
	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL", name = "geo_code_country")
	private String geoCodeCountry;
	@Column(length = 2, columnDefinition = "VARCHAR(2) DEFAULT NULL", name = "geo_code_country_code")
	private String geoCodeCountryCode;
	@Column(columnDefinition = "BIT DEFAULT NULL", name = "terminated_survey")
	private Boolean terminatedSurvey;
	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL", name = "geo_code_region")
	private String geoCodeRegion;
	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL", name = "geo_code_city")
	private String geoCodeCity;
	@Column(length = 3, columnDefinition = "VARCHAR(3) DEFAULT NULL", name = "geo_code_area_code")
	private String geoCodeAreaCode;
	@Column(length = 3, columnDefinition = "VARCHAR(3) DEFAULT NULL", name = "geo_code_dma_code")
	private String geoCodeDmaCode;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL", name = "inset_list")
	private String insetList;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String custom1;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String custom2;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String custom3;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String custom4;
	@Column(columnDefinition = "INT DEFAULT NULL", name = "panel_member_id")
	private Integer panelMemberId;
	@Column(columnDefinition = "FLOAT DEFAULT NULL")
	private Float weight;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String custom5;
	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL")
	private String guid;
	@Column(columnDefinition = "BIT DEFAULT 0", name = "quota_overlimit")
	private boolean quotaOverlimit;
	@Column(columnDefinition = "INT DEFAULT 0", name = "panel_id")
	private int panelId;
	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL", name = "referer_domain")
	private String refererDomain;
	@Lob
	@Column(columnDefinition = "NVARCHAR(MAX)", name = "user_agent")
	private String userAgent;
	@Column(precision = 15, scale = 12, columnDefinition = "DECIMAL(15,12) DEFAULT 0.000000000000")
	private BigDecimal longitude;
	@Column(precision = 15, scale = 12, columnDefinition = "DECIMAL(15,12) DEFAULT 0.000000000000")
	private BigDecimal latitude;
	@Column(precision = 7, scale = 2, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal radius;
	@Column(columnDefinition = "INT DEFAULT 0", name = "cx_business_unit_id")
	private int cxBusinessUnitId;
	@Column(columnDefinition = "INT DEFAULT 0", name = "survey_link_id")
	private int surveyLinkId;
	@Column(columnDefinition = "BIT DEFAULT 0", name = "data_quality_flag")
	private boolean dataQualityFlag;
	@Column(columnDefinition = "FLOAT DEFAULT 0", name = "data_quality_score")
	private Float dataQualityScore;
	@Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()", name = "updated_ts")
	private Date updatedTs;
	@Column(columnDefinition = "INT DEFAULT 0")
	private int channel;
	@Column(columnDefinition = "SMALLINT DEFAULT 0", name = "alternate_flip_order")
	private short alternateFlipOrder;
	@Column(columnDefinition = "TINYINT DEFAULT -1", name = "survey_type")
	private byte surveyType;

}
