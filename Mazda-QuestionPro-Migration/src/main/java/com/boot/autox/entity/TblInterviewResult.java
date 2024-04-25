package com.boot.autox.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblInterviewResult")
@Getter
@Setter
@NoArgsConstructor
public class TblInterviewResult {

	@Id
	@Column(name = "ResultID")
	private Integer resultId;
	@Column(name = "InterviewID")
	private Integer interviewId;
	@Column(name = "TempSpecificQueID")
	private Integer tempSpecificQueId;
	@Column(name = "AnswerID")
	private Integer answerId;
	@Column(name = "CommentID")
	private Integer commentId;
	@Column(name = "CreatedDTim")
	private LocalDateTime createdDTim;

}
