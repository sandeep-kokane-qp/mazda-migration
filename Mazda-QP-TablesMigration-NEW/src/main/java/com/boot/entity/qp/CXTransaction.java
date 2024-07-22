package com.boot.entity.qp;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "qp_mazda_cx_transaction")
@Getter
@Setter
@NoArgsConstructor
public class CXTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "cx_customer_id", nullable = false)
	private int cxCustomerId;

	@Column(name = "cx_feedback_id", nullable = false)
	private int cxFeedbackId;

	@Column(name = "cx_store_id", nullable = false)
	private int cxStoreId;

	@Column(name = "cx_user_id", nullable = false)
	private int cxUserId;

	@Column(name = "type_id")
	private Integer typeId;

	@Column(name = "ts", nullable = false)
	private Date ts;

	@Column(name = "cx_date")
	private Date cxDate;

	@Column(name = "cx_panel_member_id", nullable = false)
	private int cxPanelMemberId;

	@Column(name = "resting_time", nullable = false)
	private Date restingTime;

	@Column(name = "tansaction_batch_id")
	private Integer tansactionBatchId;

	@Column(name = "touch_point_id")
	private Integer touchPointId;

	@Column(name = "status", nullable = false)
	private int status;

	@Column(name = "custom1", length = 512)
	private String custom1;

	@Column(name = "custom2", length = 512)
	private String custom2;

	@Column(name = "custom3", length = 512)
	private String custom3;

	@Column(name = "custom4", length = 512)
	private String custom4;

	@Column(name = "custom5", length = 512)
	private String custom5;

	@Column(name = "custom6", length = 512)
	private String custom6;

	@Column(name = "custom7", length = 512)
	private String custom7;

	@Column(name = "custom8", length = 512)
	private String custom8;

	@Column(name = "custom9", length = 512)
	private String custom9;

	@Column(name = "custom10", length = 512)
	private String custom10;

	@Column(name = "custom11", length = 512)
	private String custom11;

	@Column(name = "custom12", length = 512)
	private String custom12;

	@Column(name = "custom13", length = 512)
	private String custom13;

	@Column(name = "custom14", length = 512)
	private String custom14;

	@Column(name = "custom15", length = 512)
	private String custom15;

	@Column(name = "custom16", length = 512)
	private String custom16;

	@Column(name = "custom17", length = 512)
	private String custom17;

	@Column(name = "custom18", length = 512)
	private String custom18;

	@Column(name = "custom19", length = 512)
	private String custom19;

	@Column(name = "custom20", length = 512)
	private String custom20;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "response_set_id", nullable = false)
	private int responseSetId;

	@Column(name = "wave_id", nullable = false)
	private int waveId;

	@Column(name = "member_status", nullable = false)
	private int memberStatus;

	@Column(name = "cx_distribution_batch_id")
	private Integer cxDistributionBatchId;

	@Column(name = "survey_id")
	private Integer surveyId;

	@Column(name = "language_id")
	private Integer languageId;

	@Column(name = "custom21", columnDefinition = "NVARCHAR(MAX)")
	private String custom21;

	@Column(name = "custom22", columnDefinition = "NVARCHAR(MAX)")
	private String custom22;

	@Column(name = "custom23", columnDefinition = "NVARCHAR(MAX)")
	private String custom23;

	@Column(name = "custom24", columnDefinition = "NVARCHAR(MAX)")
	private String custom24;

	@Column(name = "custom25", columnDefinition = "NVARCHAR(MAX)")
	private String custom25;

	@Column(name = "custom26", columnDefinition = "NVARCHAR(MAX)")
	private String custom26;

	@Column(name = "custom27", columnDefinition = "NVARCHAR(MAX)")
	private String custom27;

	@Column(name = "custom28", columnDefinition = "NVARCHAR(MAX)")
	private String custom28;

	@Column(name = "custom29", columnDefinition = "NVARCHAR(MAX)")
	private String custom29;

	@Column(name = "custom30", columnDefinition = "NVARCHAR(MAX)")
	private String custom30;

	@Column(name = "custom31", columnDefinition = "NVARCHAR(MAX)")
	private String custom31;

	@Column(name = "custom32", columnDefinition = "NVARCHAR(MAX)")
	private String custom32;

	@Column(name = "custom33", columnDefinition = "NVARCHAR(MAX)")
	private String custom33;

	@Column(name = "custom34", columnDefinition = "NVARCHAR(MAX)")
	private String custom34;

	@Column(name = "custom35", columnDefinition = "NVARCHAR(MAX)")
	private String custom35;

	@Column(name = "custom36", columnDefinition = "NVARCHAR(MAX)")
	private String custom36;

	@Column(name = "custom37", columnDefinition = "NVARCHAR(MAX)")
	private String custom37;

	@Column(name = "custom38", columnDefinition = "NVARCHAR(MAX)")
	private String custom38;

	@Column(name = "custom39", columnDefinition = "NVARCHAR(MAX)")
	private String custom39;

	@Column(name = "custom40", columnDefinition = "NVARCHAR(MAX)")
	private String custom40;

	@Column(name = "custom41", columnDefinition = "NVARCHAR(MAX)")
	private String custom41;

	@Column(name = "custom42", columnDefinition = "NVARCHAR(MAX)")
	private String custom42;

	@Column(name = "custom43", columnDefinition = "NVARCHAR(MAX)")
	private String custom43;

	@Column(name = "custom44", columnDefinition = "NVARCHAR(MAX)")
	private String custom44;

	@Column(name = "custom45", columnDefinition = "NVARCHAR(MAX)")
	private String custom45;

	@Column(name = "custom46", columnDefinition = "NVARCHAR(MAX)")
	private String custom46;

	@Column(name = "custom47", columnDefinition = "NVARCHAR(MAX)")
	private String custom47;

	@Column(name = "custom48", columnDefinition = "NVARCHAR(MAX)")
	private String custom48;

	@Column(name = "custom49", columnDefinition = "NVARCHAR(MAX)")
	private String custom49;

	@Column(name = "custom50", columnDefinition = "NVARCHAR(MAX)")
	private String custom50;

	@Column(name = "org_id", nullable = false)
	private int orgId;

	@Column(name = "transaction_owner_emails", columnDefinition = "NVARCHAR(MAX)")
	private String transactionOwnerEmails;

	@Column(name = "send_survey_ts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sendSurveyTs;

	@Column(name = "email_template_id")
	private Integer emailTemplateId;

	@Column(name = "sms_template_id")
	private Integer smsTemplateId;

	@Column(name = "send_option")
	private Integer sendOption;

	@Column(name = "applied_rules", columnDefinition = "NVARCHAR(MAX)")
	private String appliedRules;

	@Column(name = "product_group_id")
	private Integer productGroupId;

	@Column(name = "invitation_sent_ts")
	private Date invitationSentTs;

	@Column(name = "reminder_count")
	private Integer reminderCount;

	@Column(name = "next_reminder_ts")
	private Date nextReminderTs;

	@Column(name = "max_reminder_count")
	private Integer maxReminderCount;

	@Column(name = "import_type")
	private Integer importType;

	@Column(name = "workflow_process_id", nullable = false)
	private int workflowProcessId;

	@Column(name = "panel_log_id", nullable = false)
	private int panelLogId;

	@Column(name = "response_status", nullable = false)
	private int responseStatus;

}
