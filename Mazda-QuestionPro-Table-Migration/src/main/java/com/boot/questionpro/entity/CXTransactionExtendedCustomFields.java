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
@Table(name = "qp_cx_transaction_extended_custom_fields")
@Getter
@Setter
@NoArgsConstructor
public class CXTransactionExtendedCustomFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "cx_feedback_id")
	private Integer cxFeedbackId;
	@Column(name = "cx_transaction_id")
	private Integer cxTransactionId;
	@Column(name = "cx_workflow_id")
	private Integer cxWorkflowId;
	@Column(name = "cx_workflow_rule_id")
	private Integer cxWorkflowRuleId;
	private Integer type;
	private Timestamp ts;
	@Column(name = "additional_info_json")
	private String additionalInfoJson;

	private String custom51;
	private String custom52;
	private String custom53;
	private String custom54;
	private String custom55;
	private String custom56;
	private String custom57;
	private String custom58;
	private String custom59;
	private String custom60;

	private String custom61;
	private String custom62;
	private String custom63;
	private String custom64;
	private String custom65;
	private String custom66;
	private String custom67;
	private String custom68;
	private String custom69;
	private String custom70;

	private String custom71;
	private String custom72;
	private String custom73;
	private String custom74;
	private String custom75;
	private String custom76;
	private String custom77;
	private String custom78;
	private String custom79;
	private String custom80;

	private String custom81;
	private String custom82;
	private String custom83;
	private String custom84;
	private String custom85;
	private String custom86;
	private String custom87;
	private String custom88;
	private String custom89;
	private String custom90;

	private String custom91;
	private String custom92;
	private String custom93;
	private String custom94;
	private String custom95;
	private String custom96;
	private String custom97;
	private String custom98;
	private String custom99;
	private String custom100;

}
