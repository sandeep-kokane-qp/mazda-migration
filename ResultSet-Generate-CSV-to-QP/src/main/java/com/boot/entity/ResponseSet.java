package com.boot.entity;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseSet {

	private int id;
	private int surveyId;
	private Integer respondentId;
	private String extRef;
	private String emailAddr;
	private String ip;
	private Date t;
	private Integer timeTaken;
	private Integer categoryId;
	private long externalId;
	private boolean duplicate;
	private String emailGroup;
	private Integer externalEmailId;
	private String geoCodeCountry;
	private String geoCodeCountryCode;
	private Boolean terminatedSurvey;
	private String geoCodeRegion;
	private String geoCodeCity;
	private String geoCodeAreaCode;
	private String geoCodeDmaCode;
	private String insetList;
	private String custom1;
	private String custom2;
	private String custom3;
	private String custom4;
	private Integer panelMemberId;
	private Float weight;
	private String custom5;
	private String guid;
	private boolean quotaOverlimit;
	private int panelId;
	private String refererDomain;
	private String userAgent;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private BigDecimal radius;
	private int cxBusinessUnitId;
	private int surveyLinkId;
	private boolean dataQualityFlag;
	private Float dataQualityScore;
	private Date updatedTs;
	private int channel;
	private short alternateFlipOrder;
	private byte surveyType;

}
