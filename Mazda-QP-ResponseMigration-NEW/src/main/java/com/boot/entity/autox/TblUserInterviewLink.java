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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblUserInterviewLink", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TblUserInterviewLink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InterviewID", nullable = false)
	private Integer interviewId;

	@Column(name = "UserID", nullable = false)
	private Integer userId;

	@Column(name = "SurvTempID", nullable = false)
	private Integer survTempId;

	@Column(name = "SurveyTemplateDetailID", nullable = false, columnDefinition = "int default 0")
	private Integer surveyTemplateDetailId;

	@Column(name = "SentDTim", nullable = false, columnDefinition = "datetime default getdate()")
	private LocalDateTime sentDtim;

	@Column(name = "FirstResponseDTim")
	private LocalDateTime firstResponseDtim;

	@Column(name = "LastResponseDTim", columnDefinition = "datetime default null")
	private LocalDateTime lastResponseDtim;

	@Column(name = "SubmitDTim")
	private LocalDateTime submitDtim;

	@Column(name = "StatusID", nullable = false)
	private Byte statusId;

	@Column(name = "RankName", nullable = false, length = 50, columnDefinition = "varchar(50) default 'System Default'")
	private String rankName;

	@Column(name = "CreationDT", nullable = false, columnDefinition = "datetime default getdate()")
	private LocalDateTime creationDt;

	@Column(name = "IsTestInterview", nullable = false, columnDefinition = "bit default 0")
	private Boolean isTestInterview;

	@Column(name = "ModifyDate", nullable = false, columnDefinition = "datetime default getdate()")
	private LocalDateTime modifyDate;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "InterviewID")
	private List<TblInterviewResult> interviewResultsList = new LinkedList<>();

}
