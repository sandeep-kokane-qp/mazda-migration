package com.boot.entity.qp;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "qp_mazda_cx_transaction_extended_custom_fields")
@Getter
@Setter
@NoArgsConstructor
public class CXTransactionExtendedCustomFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "cx_feedback_id", nullable = false)
	private int cxFeedbackId;

	@Column(name = "cx_transaction_id")
	private Integer cxTransactionId;

	@Column(name = "cx_workflow_id")
	private Integer cxWorkflowId;

	@Column(name = "cx_workflow_rule_id")
	private Integer cxWorkflowRuleId;

	@Column(name = "type")
	private Integer type;

	@Column(name = "ts", nullable = false)
	private Date ts;

	@Column(name = "custom51", columnDefinition = "NVARCHAR(MAX)")
	private String custom51;

	@Column(name = "custom52", columnDefinition = "NVARCHAR(MAX)")
	private String custom52;

	@Column(name = "custom53", columnDefinition = "NVARCHAR(MAX)")
	private String custom53;

	@Column(name = "custom54", columnDefinition = "NVARCHAR(MAX)")
	private String custom54;

	@Column(name = "custom55", columnDefinition = "NVARCHAR(MAX)")
	private String custom55;

	@Column(name = "custom56", columnDefinition = "NVARCHAR(MAX)")
	private String custom56;

	@Column(name = "custom57", columnDefinition = "NVARCHAR(MAX)")
	private String custom57;

	@Column(name = "custom58", columnDefinition = "NVARCHAR(MAX)")
	private String custom58;

	@Column(name = "custom59", columnDefinition = "NVARCHAR(MAX)")
	private String custom59;

	@Column(name = "custom60", columnDefinition = "NVARCHAR(MAX)")
	private String custom60;

	@Column(name = "custom61", columnDefinition = "NVARCHAR(MAX)")
	private String custom61;

	@Column(name = "custom62", columnDefinition = "NVARCHAR(MAX)")
	private String custom62;

	@Column(name = "custom63", columnDefinition = "NVARCHAR(MAX)")
	private String custom63;

	@Column(name = "custom64", columnDefinition = "NVARCHAR(MAX)")
	private String custom64;

	@Column(name = "custom65", columnDefinition = "NVARCHAR(MAX)")
	private String custom65;

	@Column(name = "custom66", columnDefinition = "NVARCHAR(MAX)")
	private String custom66;

	@Column(name = "custom67", columnDefinition = "NVARCHAR(MAX)")
	private String custom67;

	@Column(name = "custom68", columnDefinition = "NVARCHAR(MAX)")
	private String custom68;

	@Column(name = "custom69", columnDefinition = "NVARCHAR(MAX)")
	private String custom69;

	@Column(name = "custom70", columnDefinition = "NVARCHAR(MAX)")
	private String custom70;

	@Column(name = "custom71", columnDefinition = "NVARCHAR(MAX)")
	private String custom71;

	@Column(name = "custom72", columnDefinition = "NVARCHAR(MAX)")
	private String custom72;

	@Column(name = "custom73", columnDefinition = "NVARCHAR(MAX)")
	private String custom73;

	@Column(name = "custom74", columnDefinition = "NVARCHAR(MAX)")
	private String custom74;

	@Column(name = "custom75", columnDefinition = "NVARCHAR(MAX)")
	private String custom75;

	@Column(name = "custom76", columnDefinition = "NVARCHAR(MAX)")
	private String custom76;

	@Column(name = "custom77", columnDefinition = "NVARCHAR(MAX)")
	private String custom77;

	@Column(name = "custom78", columnDefinition = "NVARCHAR(MAX)")
	private String custom78;

	@Column(name = "custom79", columnDefinition = "NVARCHAR(MAX)")
	private String custom79;

	@Column(name = "custom80", columnDefinition = "NVARCHAR(MAX)")
	private String custom80;

	@Column(name = "custom81", columnDefinition = "NVARCHAR(MAX)")
	private String custom81;

	@Column(name = "custom82", columnDefinition = "NVARCHAR(MAX)")
	private String custom82;

	@Column(name = "custom83", columnDefinition = "NVARCHAR(MAX)")
	private String custom83;

	@Column(name = "custom84", columnDefinition = "NVARCHAR(MAX)")
	private String custom84;

	@Column(name = "custom85", columnDefinition = "NVARCHAR(MAX)")
	private String custom85;

	@Column(name = "custom86", columnDefinition = "NVARCHAR(MAX)")
	private String custom86;

	@Column(name = "custom87", columnDefinition = "NVARCHAR(MAX)")
	private String custom87;

	@Column(name = "custom88", columnDefinition = "NVARCHAR(MAX)")
	private String custom88;

	@Column(name = "custom89", columnDefinition = "NVARCHAR(MAX)")
	private String custom89;

	@Column(name = "custom90", columnDefinition = "NVARCHAR(MAX)")
	private String custom90;

	@Column(name = "custom91", columnDefinition = "NVARCHAR(MAX)")
	private String custom91;

	@Column(name = "custom92", columnDefinition = "NVARCHAR(MAX)")
	private String custom92;

	@Column(name = "custom93", columnDefinition = "NVARCHAR(MAX)")
	private String custom93;

	@Column(name = "custom94", columnDefinition = "NVARCHAR(MAX)")
	private String custom94;

	@Column(name = "custom95", columnDefinition = "NVARCHAR(MAX)")
	private String custom95;

	@Column(name = "custom96", columnDefinition = "NVARCHAR(MAX)")
	private String custom96;

	@Column(name = "custom97", columnDefinition = "NVARCHAR(MAX)")
	private String custom97;

	@Column(name = "custom98", columnDefinition = "NVARCHAR(MAX)")
	private String custom98;

	@Column(name = "custom99", columnDefinition = "NVARCHAR(MAX)")
	private String custom99;

	@Column(name = "custom100", columnDefinition = "NVARCHAR(MAX)")
	private String custom100;

	@Column(name = "additional_info_json", columnDefinition = "NVARCHAR(MAX)")
	private String additionalInfoJson;

}
