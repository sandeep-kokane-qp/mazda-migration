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
@Table(name = "qp_new_answer")
@Getter
@Setter
@NoArgsConstructor
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "q_id")
	private Integer qId;
	@Column(name = "ord_num")
	private Integer ordNum;
	@Column(name = "a_text")
	private String aText;
	@Column(name = "text_box")
	private Integer textBox;
	@Column(name = "branch_id")
	private Integer branchId;
	@Column(name = "comp_id")
	private Integer compId;
	@Column(name = "comp_value")
	private Integer compValue;
	private Integer other;
	@Column(name = "survey_id")
	private Integer surveyId;
	@Column(name = "enable_quota")
	private Integer enableQuota;
	private Integer quota;
	@Column(name = "quota_branch_id")
	private Integer quotaBranchId;
	@Column(name = "piping_text")
	private String pipingText;
	@Column(name = "extraction_source_id")
	private Integer extractionSourceId;
	@Column(name = "exclusive_option")
	private Integer exclusiveOption;
	private String code;
	private Integer size;
	@Column(name = "exclude_randomize")
	private Integer excludeRandomize;
	private Integer location;
	@Column(name = "enable_mean_calculation")
	private Integer enableMeanCalculation;
	@Column(name = "matrix_extraction_source")
	private String matrixExtractionSource;
	@Column(name = "answer_code")
	private String answerCode;
	private Integer height;
	private Float scale;
	@Column(name = "enable_custom_scale")
	private Integer enableCustomScale;
	@Column(name = "chain_survey_id")
	private Integer chainSurveyId;
	private String suffix;
	@Column(name = "is_default")
	private Integer isDefault;
	@Column(name = "report_text")
	private String reportText;
	@Column(name = "attached_custom_var")
	private Integer attachedCustomVar;
	@Column(name = "standard_profile_option_id")
	private Integer standardProfileOptionId;
	@Column(name = "create_ts")
	private Timestamp createTs;
	@Column(name = "update_ts")
	private Timestamp updateTs;
	@Column(name = "generic_settings_json")
	private String genericSettingsJson;
	@Column(name = "answer_group_id")
	private Integer answerGroupId;
	@Column(name = "created_by_actor_id")
	private Integer createdByActorId;
	@Column(name = "updated_by_actor_id")
	private Integer updatedByActorId;

}
