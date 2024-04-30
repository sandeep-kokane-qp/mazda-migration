package com.boot.autox.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblQuestionMapping")
@Getter
@Setter
@NoArgsConstructor
public class TblQuestionMapping {

	@Id
	@Column(name = "TempSpecificQueID")
	private Integer tempSpecificQueID;
	@Column(name = "QuestionID")
	private Integer questionID;
	@Column(name = "SurveyDisplayText", length = 4000)
	private String surveyDisplayText;
	@Column(name = "SurvTempID")
	private Integer survTempID;
	@Column(name = "CategoryID")
	private Integer categoryID;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "TempSpecificQueID", insertable = false, updatable = false)
	private List<TblPossAnsMapping> tblPossAnsMappingsList = new ArrayList<TblPossAnsMapping>();

}
