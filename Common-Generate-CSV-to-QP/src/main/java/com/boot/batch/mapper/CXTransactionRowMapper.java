package com.boot.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boot.entity.CXTransaction;

public class CXTransactionRowMapper implements RowMapper<CXTransaction> {

	@Override
	public CXTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		CXTransaction transaction = new CXTransaction();
		transaction.setId(rs.getInt("id"));
		transaction.setCxCustomerId(rs.getInt("cx_customer_id"));
		transaction.setCxFeedbackId(rs.getInt("cx_feedback_id"));
		transaction.setCxStoreId(rs.getInt("cx_store_id"));
		transaction.setCxUserId(rs.getInt("cx_user_id"));
		transaction.setTypeId(rs.getObject("type_id") != null ? rs.getInt("type_id") : null);
		transaction.setTs(rs.getTimestamp("ts"));
		transaction.setCxDate(rs.getTimestamp("cx_date"));
		transaction.setCxPanelMemberId(rs.getInt("cx_panel_member_id"));
		transaction.setRestingTime(rs.getTimestamp("resting_time"));
		transaction.setTansactionBatchId(
				rs.getObject("tansaction_batch_id") != null ? rs.getInt("tansaction_batch_id") : null);
		transaction.setTouchPointId(rs.getObject("touch_point_id") != null ? rs.getInt("touch_point_id") : null);
		transaction.setStatus(rs.getInt("status"));
		transaction.setCustom1(rs.getString("custom1"));
		transaction.setCustom2(rs.getString("custom2"));
		transaction.setCustom3(rs.getString("custom3"));
		transaction.setCustom4(rs.getString("custom4"));
		transaction.setCustom5(rs.getString("custom5"));
		transaction.setCustom6(rs.getString("custom6"));
		transaction.setCustom7(rs.getString("custom7"));
		transaction.setCustom8(rs.getString("custom8"));
		transaction.setCustom9(rs.getString("custom9"));
		transaction.setCustom10(rs.getString("custom10"));
		transaction.setCustom11(rs.getString("custom11"));
		transaction.setCustom12(rs.getString("custom12"));
		transaction.setCustom13(rs.getString("custom13"));
		transaction.setCustom14(rs.getString("custom14"));
		transaction.setCustom15(rs.getString("custom15"));
		transaction.setCustom16(rs.getString("custom16"));
		transaction.setCustom17(rs.getString("custom17"));
		transaction.setCustom18(rs.getString("custom18"));
		transaction.setCustom19(rs.getString("custom19"));
		transaction.setCustom20(rs.getString("custom20"));
		transaction.setProductId(rs.getObject("product_id") != null ? rs.getInt("product_id") : null);
		transaction.setResponseSetId(rs.getInt("response_set_id"));
		transaction.setWaveId(rs.getInt("wave_id"));
		transaction.setMemberStatus(rs.getInt("member_status"));
		transaction.setCxDistributionBatchId(
				rs.getObject("cx_distribution_batch_id") != null ? rs.getInt("cx_distribution_batch_id") : null);
		transaction.setSurveyId(rs.getObject("survey_id") != null ? rs.getInt("survey_id") : null);
		transaction.setLanguageId(rs.getObject("language_id") != null ? rs.getInt("language_id") : null);
		transaction.setCustom21(rs.getString("custom21"));
		transaction.setCustom22(rs.getString("custom22"));
		transaction.setCustom23(rs.getString("custom23"));
		transaction.setCustom24(rs.getString("custom24"));
		transaction.setCustom25(rs.getString("custom25"));
		transaction.setCustom26(rs.getString("custom26"));
		transaction.setCustom27(rs.getString("custom27"));
		transaction.setCustom28(rs.getString("custom28"));
		transaction.setCustom29(rs.getString("custom29"));
		transaction.setCustom30(rs.getString("custom30"));
		transaction.setCustom31(rs.getString("custom31"));
		transaction.setCustom32(rs.getString("custom32"));
		transaction.setCustom33(rs.getString("custom33"));
		transaction.setCustom34(rs.getString("custom34"));
		transaction.setCustom35(rs.getString("custom35"));
		transaction.setCustom36(rs.getString("custom36"));
		transaction.setCustom37(rs.getString("custom37"));
		transaction.setCustom38(rs.getString("custom38"));
		transaction.setCustom39(rs.getString("custom39"));
		transaction.setCustom40(rs.getString("custom40"));
		transaction.setCustom41(rs.getString("custom41"));
		transaction.setCustom42(rs.getString("custom42"));
		transaction.setCustom43(rs.getString("custom43"));
		transaction.setCustom44(rs.getString("custom44"));
		transaction.setCustom45(rs.getString("custom45"));
		transaction.setCustom46(rs.getString("custom46"));
		transaction.setCustom47(rs.getString("custom47"));
		transaction.setCustom48(rs.getString("custom48"));
		transaction.setCustom49(rs.getString("custom49"));
		transaction.setCustom50(rs.getString("custom50"));
		transaction.setOrgId(rs.getInt("org_id"));
		transaction.setTransactionOwnerEmails(rs.getString("transaction_owner_emails"));
		transaction.setSendSurveyTs(rs.getTimestamp("send_survey_ts"));
		transaction
				.setEmailTemplateId(rs.getObject("email_template_id") != null ? rs.getInt("email_template_id") : null);
		transaction.setSmsTemplateId(rs.getObject("sms_template_id") != null ? rs.getInt("sms_template_id") : null);
		transaction.setSendOption(rs.getObject("send_option") != null ? rs.getInt("send_option") : null);
		transaction.setAppliedRules(rs.getString("applied_rules"));
		transaction.setProductGroupId(rs.getObject("product_group_id") != null ? rs.getInt("product_group_id") : null);
		transaction.setInvitationSentTs(rs.getTimestamp("invitation_sent_ts"));
		transaction.setReminderCount(rs.getObject("reminder_count") != null ? rs.getInt("reminder_count") : null);
		transaction.setNextReminderTs(rs.getTimestamp("next_reminder_ts"));
		transaction.setMaxReminderCount(
				rs.getObject("max_reminder_count") != null ? rs.getInt("max_reminder_count") : null);
		transaction.setImportType(rs.getObject("import_type") != null ? rs.getInt("import_type") : null);
		transaction.setWorkflowProcessId(rs.getInt("workflow_process_id"));
		transaction.setPanelLogId(rs.getInt("panel_log_id"));
		transaction.setResponseStatus(rs.getInt("response_status"));

		return transaction;
	}
}
