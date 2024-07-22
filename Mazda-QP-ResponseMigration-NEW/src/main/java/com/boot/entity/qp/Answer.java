package com.boot.entity.qp;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "qp_answer", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Answer {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "q_id", nullable = false, columnDefinition = "int default 0")
	private int qId;

	@Column(name = "ord_num", nullable = false, columnDefinition = "int default 0")
	private int ordNum;

	@Column(name = "a_text", columnDefinition = "nvarchar(max)")
	private String aText;

	@Column(name = "text_box", columnDefinition = "int default 0")
	private int textBox;

	@Column(name = "branch_id", columnDefinition = "int default null")
	private Integer branchId;

	@Column(name = "comp_id", columnDefinition = "int default null")
	private Integer compId;

	@Column(name = "comp_value", columnDefinition = "int default 0")
	private int compValue;

	@Column(name = "other", nullable = false, columnDefinition = "bit default 0")
	private boolean other;

	@Column(name = "survey_id", nullable = false, columnDefinition = "int default 0")
	private int surveyId;

	@Column(name = "enable_quota", columnDefinition = "bit default 0")
	private boolean enableQuota;

	@Column(name = "quota", columnDefinition = "int default 0")
	private int quota;

	@Column(name = "quota_branch_id", columnDefinition = "int default null")
	private Integer quotaBranchId;

	@Column(name = "piping_text", columnDefinition = "nvarchar(255) default null")
	private String pipingText;

	@Column(name = "extraction_source_id", columnDefinition = "int default null")
	private Integer extractionSourceId;

	@Column(name = "exclusive_option", columnDefinition = "bit default null")
	private Boolean exclusiveOption;

	@Column(name = "code", columnDefinition = "nvarchar(10) default null")
	private String code;

	@Column(name = "size", columnDefinition = "int default null")
	private Integer size;

	@Column(name = "exclude_randomize", columnDefinition = "bit default 0")
	private boolean excludeRandomize;

	@Column(name = "location", columnDefinition = "smallint default 0")
	private short location;

	@Column(name = "enable_mean_calculation", columnDefinition = "bit default 1")
	private boolean enableMeanCalculation;

	@Column(name = "cost_index", columnDefinition = "float default null")
	private Float costIndex;

	@Column(name = "matrix_extraction_source", columnDefinition = "nvarchar(128) default null")
	private String matrixExtractionSource;

	@Column(name = "answer_code", columnDefinition = "nvarchar(255) default null")
	private String answerCode;

	@Column(name = "height", columnDefinition = "int default null")
	private Integer height;

	@Column(name = "scale", columnDefinition = "float default null")
	private Float scale;

	@Column(name = "chain_survey_id", columnDefinition = "int default null")
	private Integer chainSurveyId;

	@Column(name = "suffix", columnDefinition = "nvarchar(255) default null")
	private String suffix;

	@Column(name = "is_default", columnDefinition = "bit default 0")
	private boolean isDefault;

	@Column(name = "report_text", columnDefinition = "nvarchar(255) default null")
	private String reportText;

	@Column(name = "attached_custom_var", columnDefinition = "int default 0")
	private int attachedCustomVar;

	@Column(name = "standard_profile_option_id", columnDefinition = "int default null")
	private Integer standardProfileOptionId;

	@Column(name = "create_ts", nullable = false, columnDefinition = "datetime default getdate()")
	private LocalDateTime createTs;

	@Column(name = "update_ts", nullable = false, columnDefinition = "datetime default getdate()")
	private LocalDateTime updateTs;

	@Column(name = "generic_settings_json", columnDefinition = "nvarchar(max)")
	private String genericSettingsJson;

	@Column(name = "answer_group_id", columnDefinition = "int default 0")
	private int answerGroupId;

	@Column(name = "created_by_actor_id", columnDefinition = "int default null")
	private Integer createdByActorId;

	@Column(name = "updated_by_actor_id", columnDefinition = "int default null")
	private Integer updatedByActorId;

	@Column(name = "draft_id", columnDefinition = "nvarchar(100)")
	private String draftId;
}
