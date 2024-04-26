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
@Table(name = "qp_int_result")
@Getter
@Setter
@NoArgsConstructor
public class IntResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "resp_id")
	private Integer respId;
	@Column(name = "response_set_id")
	private Integer responseSetId;
	@Column(name = "a_id")
	private Integer aId;
	@Column(name = "a_val")
	private Integer aVal;
	@Column(name = "survey_id")
	private Integer surveyId;
	@Column(name = "q_id")
	private Integer qId;
	@Column(name = "source_answer_id")
	private Integer sourceAnswerId;
	private Timestamp t;

}
