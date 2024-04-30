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
@Table(name = "qp_new_cx_transaction")
@Getter
@Setter
@NoArgsConstructor
public class CXTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "cx_customer_id")
	private Integer cxCustomerId;
	@Column(name = "cx_feedback_id")
	private Integer cxFeedbackId;
	@Column(name = "cx_store_id")
	private Integer cxStoreId;
	@Column(name = "cx_user_id")
	private Integer cxUserId;
	@Column(name = "type_id")
	private Integer typeId;
	private String ts;
	@Column(name = "cx_date")
	private String cxDate;
	@Column(name = "cx_panel_member_id")
	private Integer cxPanelMemberId;
	@Column(name = "tansaction_batch_id")
	private Integer tansactionBatchId;
	@Column(name = "touch_point_id")
	private Integer touchPointId;
	private Integer status;
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "response_set_id")
	private Integer responseSetId;
	@Column(name = "wave_id")
	private Integer waveId;
	@Column(name = "member_status")
	private Integer memberStatus;
	@Column(name = "language_id")
	private Integer languageId;
	@Column(name = "org_id")
	private Integer orgId;
	@Column(name = "transaction_owner_emails")
	private String transactionOwnerEmails;
	@Column(name = "cx_distribution_batch_id")
	private Integer cxDistributionBatchId;
	@Column(name = "survey_id")
	private Integer surveyId;
	@Column(name = "send_survey_ts")
	private Timestamp sendSurveyId;
	@Column(name = "survey_template_id")
	private Integer emailTemplateId;
	@Column(name = "send_option")
	private Integer sendOption;
	@Column(name = "applied_rules")
	private String appliedRules;
	@Column(name = "product_group_id")
	private Integer productGroupId;
	@Column(name = "invitation_sent_ts")
	private Timestamp invitationSentTs;
	@Column(name = "reminder_count")
	private Integer reminderCount;
	@Column(name = "next_reminder_count")
	private Timestamp nextReminderCount;
	@Column(name = "import_type")
	private Integer importType;
	@Column(name = "workflow_process_id")
	private Integer workflowProcessId;
	@Column(name = "panel_log_id")
	private Integer panelLogId;
	@Column(name = "response_status")
	private Integer responseStatus;

	private String custom1;
	private String custom2;
	private String custom3;
	private String custom4;
	private String custom5;
	private String custom6;
	private String custom7;
	private String custom8;
	private String custom9;
	private String custom10;
	private String custom11;
	private String custom12;
	private String custom13;
	private String custom14;
	private String custom15;
	private String custom16;
	private String custom17;
	private String custom18;
	private String custom19;
	private String custom20;
	private String custom21;
	private String custom22;
	private String custom23;
	private String custom24;
	private String custom25;
	private String custom26;
	private String custom27;
	private String custom28;
	private String custom29;
	private String custom30;
	private String custom31;
	private String custom32;
	private String custom33;
	private String custom34;
	private String custom35;
	private String custom36;
	private String custom37;
	private String custom38;
	private String custom39;
	private String custom40;
	private String custom41;
	private String custom42;
	private String custom43;
	private String custom44;
	private String custom45;
	private String custom46;
	private String custom47;
	private String custom48;
	private String custom49;
	private String custom50;

}
