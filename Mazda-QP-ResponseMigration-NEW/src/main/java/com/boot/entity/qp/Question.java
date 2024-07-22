package com.boot.entity.qp;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "qp_question", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "survey_id", nullable = false, columnDefinition = "int default 0")
	private int surveyId;

	@Column(name = "ord_num", nullable = false, columnDefinition = "int default 0")
	private int ordNum;

	@Column(name = "q_text", columnDefinition = "nvarchar(max)")
	private String qText;

	@Column(name = "orientation", columnDefinition = "int default 1")
	private int orientation;

	@Column(name = "max_answers", columnDefinition = "decimal(15, 3) default 1.000")
	private double maxAnswers;

	@Column(name = "min_answers", columnDefinition = "decimal(15, 3) default 1.000")
	private double minAnswers;

	@Column(name = "random", columnDefinition = "bit default 0")
	private boolean random;

	@Column(name = "ties_allowed", columnDefinition = "bit default 0")
	private boolean tiesAllowed;

	@Column(name = "force_all", columnDefinition = "bit default 0")
	private boolean forceAll;

	@Column(name = "section_id", columnDefinition = "int default 1")
	private int sectionId;

	@Column(name = "branch", columnDefinition = "bit default 0")
	private boolean branch;

	@Column(name = "q_desc", columnDefinition = "nvarchar(max)")
	private String qDesc;

	@Column(name = "other", columnDefinition = "bit default 0")
	private boolean other;

	@Column(name = "required", columnDefinition = "bit default 0")
	private boolean required;

	@Column(name = "branch_out", columnDefinition = "int default null")
	private Integer branchOut;

	@Column(name = "public_result", columnDefinition = "bit default null")
	private Boolean publicResult;

	@Column(name = "random_section", columnDefinition = "bit default 0")
	private boolean randomSection;

	@Column(name = "type", columnDefinition = "char(1) default 'U'")
	private String type;

	@Column(name = "subtype", columnDefinition = "char(1) default 'A'")
	private char subtype;

	@Column(name = "show_tip", columnDefinition = "int default null")
	private Integer showTip;

	@Column(name = "tip_link_text", columnDefinition = "nvarchar(512)")
	private String tipLinkText;

	@Column(name = "question_tip_id", columnDefinition = "int default 0")
	private int questionTipId;

	@Column(name = "exact_min_answers", columnDefinition = "bit default 0")
	private boolean exactMinAnswers;

	@Column(name = "answer_width", columnDefinition = "nvarchar(32) default 'Default'")
	private String answerWidth;

	@Column(name = "width", columnDefinition = "nvarchar(32) default 'Default'")
	private String width;

	@Column(name = "font_info", columnDefinition = "nvarchar(32) default 'A10'")
	private String fontInfo;

	@Column(name = "answer_font_info", columnDefinition = "nvarchar(32) default 'A10'")
	private String answerFontInfo;

	@Column(name = "enable_multiple_branch", columnDefinition = "bit default 0")
	private boolean enableMultipleBranch;

	@Column(name = "desc_font_info", columnDefinition = "nvarchar(32) default 'A10'")
	private String descFontInfo;

	@Column(name = "desc_width", columnDefinition = "nvarchar(32) default 'Default'")
	private String descWidth;

	@Column(name = "extraction_source_id", columnDefinition = "int default null")
	private Integer extractionSourceId;

	@Column(name = "extraction", columnDefinition = "bit default 0")
	private boolean extraction;

	@Column(name = "code", columnDefinition = "nvarchar(64)")
	private String code;

	@Column(name = "tip_header", columnDefinition = "nvarchar(max)")
	private String tipHeader;

	@Column(name = "display_options", columnDefinition = "int default 0")
	private int displayOptions;

	@Column(name = "copy_source_id", columnDefinition = "int default null")
	private Integer copySourceId;

	@Column(name = "page_break", columnDefinition = "bit default 0")
	private boolean pageBreak;

	@Column(name = "skip_numbering", columnDefinition = "bit default null")
	private Boolean skipNumbering;

	@Column(name = "subsection_numbering", columnDefinition = "bit default 0")
	private boolean subsectionNumbering;

	@Column(name = "constant_multiplier", columnDefinition = "float default 1")
	private float constantMultiplier;

	@Column(name = "numbering_location", columnDefinition = "smallint default 0")
	private short numberingLocation;

	@Column(name = "num_tasks", columnDefinition = "int default null")
	private Integer numTasks;

	@Column(name = "additional_info_id", columnDefinition = "int default null")
	private Integer additionalInfoId;

	@Column(name = "matrix_extraction_list", columnDefinition = "nvarchar(128)")
	private String matrixExtractionList;

	@Column(name = "matrix_extraction_source", columnDefinition = "nvarchar(128)")
	private String matrixExtractionSource;

	@Column(name = "weight", columnDefinition = "float default null")
	private Float weight;

	@Column(name = "enable_custom_scale", columnDefinition = "bit default 0")
	private boolean enableCustomScale;

	@Column(name = "data_prepopulation_mode", columnDefinition = "int default null")
	private Integer dataPrepopulationMode;

	@Column(name = "custom_validator_class", columnDefinition = "nvarchar(128)")
	private String customValidatorClass;

	@Column(name = "custom_validator_argument", columnDefinition = "nvarchar(128)")
	private String customValidatorArgument;

	@Column(name = "enable_ad_hoc", columnDefinition = "bit default 1")
	private boolean enableAdHoc;

	@Column(name = "question_separator", columnDefinition = "bit default null")
	private Boolean questionSeparator;

	@Column(name = "enable_dynamic_replacement", columnDefinition = "bit default 0")
	private boolean enableDynamicReplacement;

	@Column(name = "calculation_mode", columnDefinition = "int default 0")
	private int calculationMode;

	@Column(name = "chart_type", columnDefinition = "int default 0")
	private int chartType;

	@Column(name = "standard_profile_id", columnDefinition = "int default 0")
	private int standardProfileId;

	@Column(name = "question_group", columnDefinition = "nvarchar(128)")
	private String questionGroup;

	@Column(name = "survey_part_id", columnDefinition = "int default 0")
	private int surveyPartId;

	@Column(name = "canvas_app_id", columnDefinition = "int default 0")
	private int canvasAppId;

	@Column(name = "create_ts", nullable = false, columnDefinition = "datetime default getdate()")
	private LocalDateTime createTs;

	@Column(name = "update_ts", nullable = false, columnDefinition = "datetime default getdate()")
	private LocalDateTime updateTs;

	@Column(name = "cultural_marker_id", columnDefinition = "int default 0")
	private int culturalMarkerId;

	@Column(name = "metadata_scale_type", columnDefinition = "tinyint default null")
	private Byte metadataScaleType;

	@Column(name = "report_label", columnDefinition = "nvarchar(max)")
	private String reportLabel;

	@Column(name = "building_block_id", columnDefinition = "int default -1")
	private int buildingBlockId;

	@Column(name = "measure_id", columnDefinition = "int default 0")
	private int measureId;

	@Column(name = "created_by_actor_id", columnDefinition = "int default null")
	private Integer createdByActorId;

	@Column(name = "updated_by_actor_id", columnDefinition = "int default null")
	private Integer updatedByActorId;

	@Column(name = "draft_id", columnDefinition = "nvarchar(100)")
	private String draftId;

	@Column(name = "group_id", columnDefinition = "nvarchar(36)")
	private String groupId;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "question_id")
	private int questionId;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "q_id")
	private List<Answer> answersList = new LinkedList<Answer>();
}
