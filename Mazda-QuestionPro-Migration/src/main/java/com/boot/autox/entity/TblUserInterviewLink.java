package com.boot.autox.entity;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblUserInterviewLink")
@Getter
@Setter
@NoArgsConstructor
public class TblUserInterviewLink {

	@Id
	@Column(name = "InterviewID")
	private Integer interviewID;
	@Column(name = "SurvTempID")
	private Integer survTempID;
	@Column(name = "SurveyTemplateDetailID")
	private Integer surveyTemplateDetailsID;
	@Column(name = "SentDTim")
	private LocalDateTime sentDTim;
	@Column(name = "FirstResponseDTim")
	private LocalDateTime firstResponseDTim;
	@Column(name = "SubmitDTim")
	private LocalDateTime submitDTim;
	@Column(name = "StatusID")
	private Integer statusId;
	@Column(name = "RankName")
	private String rankName;
	@Column(name = "CreationDT")
	private LocalDateTime creationDT;
	@Column(name = "IsTestInterview")
	private Integer isTestInterview;
	@Column(name = "ModifyDate")
	private LocalDateTime modifyDate;

	private List<TblInterviewResult> interviewResultsList = new LinkedList<>();

}
