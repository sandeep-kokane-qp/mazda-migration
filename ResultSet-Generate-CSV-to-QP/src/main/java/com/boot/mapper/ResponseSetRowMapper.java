package com.boot.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boot.entity.ResponseSet;

public class ResponseSetRowMapper implements RowMapper<ResponseSet> {
	@Override
	public ResponseSet mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResponseSet responseSet = new ResponseSet();

		responseSet.setId(rs.getInt("id"));
		responseSet.setSurveyId(rs.getInt("survey_id"));
		responseSet.setRespondentId(rs.getObject("respondent_id", Integer.class));
		responseSet.setExtRef(rs.getString("ext_ref"));
		responseSet.setEmailAddr(rs.getString("email_addr"));
		responseSet.setIp(rs.getString("ip"));
		responseSet.setT(rs.getDate("t"));
		responseSet.setTimeTaken(rs.getObject("time_taken", Integer.class));
		responseSet.setCategoryId(rs.getObject("category_id", Integer.class));
		responseSet.setExternalId(rs.getLong("external_id"));
		responseSet.setDuplicate(rs.getBoolean("duplicate"));
		responseSet.setEmailGroup(rs.getString("email_group"));
		responseSet.setExternalEmailId(rs.getObject("external_email_id", Integer.class));
		responseSet.setGeoCodeCountry(rs.getString("geo_code_country"));
		responseSet.setGeoCodeCountryCode(rs.getString("geo_code_country_code"));
		responseSet.setTerminatedSurvey(rs.getObject("terminated_survey", Boolean.class));
		responseSet.setGeoCodeRegion(rs.getString("geo_code_region"));
		responseSet.setGeoCodeCity(rs.getString("geo_code_city"));
		responseSet.setGeoCodeAreaCode(rs.getString("geo_code_area_code"));
		responseSet.setGeoCodeDmaCode(rs.getString("geo_code_dma_code"));
		responseSet.setInsetList(rs.getString("inset_list"));
		responseSet.setCustom1(rs.getString("custom1"));
		responseSet.setCustom2(rs.getString("custom2"));
		responseSet.setCustom3(rs.getString("custom3"));
		responseSet.setCustom4(rs.getString("custom4"));
		responseSet.setPanelMemberId(rs.getObject("panel_member_id", Integer.class));
		responseSet.setWeight(rs.getObject("weight", Float.class));
		responseSet.setCustom5(rs.getString("custom5"));
		responseSet.setGuid(rs.getString("guid"));
		responseSet.setQuotaOverlimit(rs.getBoolean("quota_overlimit"));
		responseSet.setPanelId(rs.getInt("panel_id"));
		responseSet.setRefererDomain(rs.getString("referer_domain"));
		responseSet.setUserAgent(rs.getString("user_agent"));
		responseSet.setLongitude(rs.getObject("longitude", BigDecimal.class));
		responseSet.setLatitude(rs.getObject("latitude", BigDecimal.class));
		responseSet.setRadius(rs.getObject("radius", BigDecimal.class));
		responseSet.setCxBusinessUnitId(rs.getInt("cx_business_unit_id"));
		responseSet.setSurveyLinkId(rs.getInt("survey_link_id"));
		responseSet.setDataQualityFlag(rs.getBoolean("data_quality_flag"));
		responseSet.setDataQualityScore(rs.getObject("data_quality_score", Float.class));
		responseSet.setUpdatedTs(rs.getDate("updated_ts"));
		responseSet.setChannel(rs.getInt("channel"));
		responseSet.setAlternateFlipOrder(rs.getShort("alternate_flip_order"));
		responseSet.setSurveyType(rs.getByte("survey_type"));

		return responseSet;
	}
}
