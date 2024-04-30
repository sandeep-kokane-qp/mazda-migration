package com.boot.questionpro.entity;

import java.util.LinkedList;
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
import lombok.ToString;

@Entity
@Table(name = "qp_question")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Question {

	@Id
	private Integer id;
	@Column(name = "survey_id")
	private Integer surveyId;
	@Column(name = "q_text", length = 5000)
	private String qText;
	private String code;
	@Column(name = "category_id")
	private Integer categoryId;
	@Column(name = "question_id")
	private Integer questionId;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "q_id")
	private List<Answer> answersList = new LinkedList<>();

}
