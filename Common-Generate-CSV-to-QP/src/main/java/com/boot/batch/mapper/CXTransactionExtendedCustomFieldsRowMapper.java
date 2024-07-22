package com.boot.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boot.entity.CXTransactionExtendedCustomFields;

public class CXTransactionExtendedCustomFieldsRowMapper implements RowMapper<CXTransactionExtendedCustomFields> {
	@Override
	public CXTransactionExtendedCustomFields mapRow(ResultSet rs, int rowNum) throws SQLException {
		CXTransactionExtendedCustomFields transaction = new CXTransactionExtendedCustomFields();
		transaction.setId(rs.getInt("id"));
		transaction.setUserId(rs.getInt("user_id"));
		transaction.setCxFeedbackId(rs.getInt("cx_feedback_id"));
		transaction.setCxTransactionId(rs.getObject("cx_transaction_id", Integer.class));
		transaction.setCxWorkflowId(rs.getObject("cx_workflow_id", Integer.class));
		transaction.setCxWorkflowRuleId(rs.getObject("cx_workflow_rule_id", Integer.class));
		transaction.setType(rs.getObject("type", Integer.class));
		transaction.setTs(rs.getTimestamp("ts"));
		transaction.setCustom51(rs.getString("custom51"));
		transaction.setCustom52(rs.getString("custom52"));
		transaction.setCustom53(rs.getString("custom53"));
		transaction.setCustom54(rs.getString("custom54"));
		transaction.setCustom55(rs.getString("custom55"));
		transaction.setCustom56(rs.getString("custom56"));
		transaction.setCustom57(rs.getString("custom57"));
		transaction.setCustom58(rs.getString("custom58"));
		transaction.setCustom59(rs.getString("custom59"));
		transaction.setCustom60(rs.getString("custom60"));
		transaction.setCustom61(rs.getString("custom61"));
		transaction.setCustom62(rs.getString("custom62"));
		transaction.setCustom63(rs.getString("custom63"));
		transaction.setCustom64(rs.getString("custom64"));
		transaction.setCustom65(rs.getString("custom65"));
		transaction.setCustom66(rs.getString("custom66"));
		transaction.setCustom67(rs.getString("custom67"));
		transaction.setCustom68(rs.getString("custom68"));
		transaction.setCustom69(rs.getString("custom69"));
		transaction.setCustom70(rs.getString("custom70"));
		transaction.setCustom71(rs.getString("custom71"));
		transaction.setCustom72(rs.getString("custom72"));
		transaction.setCustom73(rs.getString("custom73"));
		transaction.setCustom74(rs.getString("custom74"));
		transaction.setCustom75(rs.getString("custom75"));
		transaction.setCustom76(rs.getString("custom76"));
		transaction.setCustom77(rs.getString("custom77"));
		transaction.setCustom78(rs.getString("custom78"));
		transaction.setCustom79(rs.getString("custom79"));
		transaction.setCustom80(rs.getString("custom80"));
		transaction.setCustom81(rs.getString("custom81"));
		transaction.setCustom82(rs.getString("custom82"));
		transaction.setCustom83(rs.getString("custom83"));
		transaction.setCustom84(rs.getString("custom84"));
		transaction.setCustom85(rs.getString("custom85"));
		transaction.setCustom86(rs.getString("custom86"));
		transaction.setCustom87(rs.getString("custom87"));
		transaction.setCustom88(rs.getString("custom88"));
		transaction.setCustom89(rs.getString("custom89"));
		transaction.setCustom90(rs.getString("custom90"));
		transaction.setCustom91(rs.getString("custom91"));
		transaction.setCustom92(rs.getString("custom92"));
		transaction.setCustom93(rs.getString("custom93"));
		transaction.setCustom94(rs.getString("custom94"));
		transaction.setCustom95(rs.getString("custom95"));
		transaction.setCustom96(rs.getString("custom96"));
		transaction.setCustom97(rs.getString("custom97"));
		transaction.setCustom98(rs.getString("custom98"));
		transaction.setCustom99(rs.getString("custom99"));
		transaction.setCustom100(rs.getString("custom100"));
		transaction.setAdditionalInfoJson(rs.getString("additional_info_json"));
		return transaction;
	}
}
