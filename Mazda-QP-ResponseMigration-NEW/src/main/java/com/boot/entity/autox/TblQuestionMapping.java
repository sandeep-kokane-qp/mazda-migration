package com.boot.entity.autox;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblQuestionMapping", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TblQuestionMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TempSpecificQueID", nullable = false)
	private Integer tempSpecificQueId;

	@Column(name = "QuestionID", nullable = false)
	private Integer questionId;

	@Column(name = "SurveyDisplayText", length = 4000)
	private String surveyDisplayText;

	@Column(name = "ReportingDisplayText", length = 4000)
	private String reportingDisplayText;

	@Column(name = "SurvTempID", nullable = false)
	private Integer survTempId;

	@Column(name = "CategoryID", nullable = false)
	private Integer categoryId;

	@Column(name = "QuestionDispOrd", nullable = false)
	private Integer questionDispOrd;

	@Column(name = "IsRequired", nullable = false, columnDefinition = "bit default 0")
	private Boolean isRequired;

	@Column(name = "IsActive", nullable = false, columnDefinition = "bit default 1")
	private Boolean isActive;

	@Column(name = "ModifiedDTim")
	private LocalDateTime modifiedDtim;

	@Column(name = "SurveyDisplayTextEmployee", length = 4000)
	private String surveyDisplayTextEmployee;

	@Column(name = "IsEmployeeActive")
	private Boolean isEmployeeActive;

	@Column(name = "PlatformID")
	private Long platformId;

	@ManyToOne
	@JoinColumn(name = "QuestionID", insertable = false, updatable = false)
	private TblQuestion tblQuestion;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "TempSpecificQueID")
	private List<TblPossAnsMapping> answersList = new LinkedList<>();

}
