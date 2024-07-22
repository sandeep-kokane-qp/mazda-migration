package com.boot.entity.qp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "qp_question_mapped", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionMappped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer qId;
	private Integer tsqId;
	private Integer surveyTemplateId;

}
