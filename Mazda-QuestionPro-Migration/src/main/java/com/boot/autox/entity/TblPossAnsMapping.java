package com.boot.autox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblPossAnsMapping")
@Getter
@Setter
@NoArgsConstructor
public class TblPossAnsMapping {

	@Id
	@Column(name = "TempSpecificQueID")
	private Integer tempSpecificQueID;
	@Column(name = "PossAnsID")
	private Integer possAnsID;
	@Column(name = "SurveyDisplayText", length = 4000)
	private String surveyDisplayText;
	@Column(name = "SurvTempID")
	private Integer survTempID;

//	@ManyToOne
//	@JoinColumn(name = "TempSpecificQueID", insertable = false, updatable = false)
//	private TblQuestionMapping questionMapping;

}
