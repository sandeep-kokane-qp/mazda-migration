package com.boot.questionpro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "qp_new_question")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "survey_id")
	private Integer surveyId;
	@Column(name = "q_text")
	private String qText;
	private String code;
	@Column(name = "category_id")
	private Integer categoryId;
	@Column(name = "question_id")
	private Integer questionId;

//    @OneToMany(mappedBy = "q_id", fetch = FetchType.EAGER)
//    private List<Answer> answersList = new LinkedList<>();

}
