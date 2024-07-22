package com.boot.entity.autox;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblInterviewResult", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TblInterviewResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ResultID", nullable = false)
	private Integer resultId;

	@Column(name = "InterviewID", nullable = false)
	private Integer interviewId;

	@Column(name = "TempSpecificQueID", nullable = false)
	private Integer tempSpecificQueId;

	@Column(name = "AnswerID")
	private Integer answerId;

	@Column(name = "CommentID")
	private Integer commentId;

	@Column(name = "CreatedDTim", nullable = false)
	private LocalDateTime createdDTim;

	@ManyToOne
	@JoinColumn(name = "CommentID", insertable = false, updatable = false)
	private TblComment tblComment;

	@ManyToOne
	@JoinColumn(name = "AnswerID", insertable = false, updatable = false)
	private TblPossibleAnswer tblPossibleAnswer;

	@ManyToOne
	@JoinColumn(name = "TempSpecificQueID", insertable = false, updatable = false)
	private TblQuestionMapping tblQuestionMapping;

	@ManyToOne
	@JoinColumn(name = "InterviewID", insertable = false, updatable = false)
	private TblUserInterviewLink tblUserInterviewLink;

}
