package com.boot.questionpro.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "qp_mazda_response_set")
@Getter
@Setter
@NoArgsConstructor
public class QpResponseSet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private int surveyId;
	@Column(columnDefinition = "INT DEFAULT NULL")
	private Integer respondentId;
	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL")
	private String extRef;
	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String emailAddr;
	@Column(length = 46, columnDefinition = "VARCHAR(46) DEFAULT NULL")
	private String ip;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
	private Date t;
	@Column(columnDefinition = "INT DEFAULT NULL")
	private Integer timeTaken;
	@Column(columnDefinition = "INT DEFAULT NULL")
	private Integer categoryId;
	@Column(columnDefinition = "BIGINT DEFAULT 0")
	private long externalId;
	@Column(columnDefinition = "BIT DEFAULT 0")
	private boolean duplicate;
	@Column(length = 30, columnDefinition = "VARCHAR(30) DEFAULT NULL")
	private String emailGroup;
	@Column(columnDefinition = "INT DEFAULT NULL")
	private Integer externalEmailId;
	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL")
	private String geoCodeCountry;
	@Column(length = 2, columnDefinition = "VARCHAR(2) DEFAULT NULL")
	private String geoCodeCountryCode;
	@Column(columnDefinition = "BIT DEFAULT NULL")
	private Boolean terminatedSurvey;
	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String geoCodeRegion;
	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String geoCodeCity;
	@Column(length = 3, columnDefinition = "VARCHAR(3) DEFAULT NULL")
	private String geoCodeAreaCode;
	@Column(length = 3, columnDefinition = "VARCHAR(3) DEFAULT NULL")
	private String geoCodeDmaCode;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String insetList;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String custom1;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String custom2;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String custom3;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String custom4;
	@Column(columnDefinition = "INT DEFAULT NULL")
	private Integer panelMemberId;
	@Column(columnDefinition = "FLOAT DEFAULT NULL")
	private Float weight;
	@Column(length = 1024, columnDefinition = "VARCHAR(1024) DEFAULT NULL")
	private String custom5;
	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL")
	private String guid;
	@Column(columnDefinition = "BIT DEFAULT 0")
	private boolean quotaOverlimit;
	@Column(columnDefinition = "INT DEFAULT 0")
	private int panelId;
	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL")
	private String refererDomain;
	@Lob
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String userAgent;
	@Column(precision = 15, scale = 12, columnDefinition = "DECIMAL(15,12) DEFAULT 0.000000000000")
	private BigDecimal longitude;
	@Column(precision = 15, scale = 12, columnDefinition = "DECIMAL(15,12) DEFAULT 0.000000000000")
	private BigDecimal latitude;
	@Column(precision = 7, scale = 2, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal radius;
	@Column(columnDefinition = "INT DEFAULT 0")
	private int cxBusinessUnitId;
	@Column(columnDefinition = "INT DEFAULT 0")
	private int surveyLinkId;
	@Column(columnDefinition = "BIT DEFAULT 0")
	private boolean dataQualityFlag;
	@Column(columnDefinition = "FLOAT DEFAULT 0")
	private Float dataQualityScore;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
	private Date updatedTs;
	@Column(columnDefinition = "INT DEFAULT 0")
	private int channel;
	@Column(columnDefinition = "SMALLINT DEFAULT 0")
	private short alternateFlipOrder;
	@Column(columnDefinition = "TINYINT DEFAULT -1")
	private byte surveyType;

}
