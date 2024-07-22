package com.boot.entity.qp;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
@Table(name = "qp_int_result", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class IntResult {

	@Column(name = "resp_id")
	private Long respId;

	@Column(name = "response_set_id", nullable = false, columnDefinition = "int default 0")
	private int responseSetId;

	@Column(name = "a_id", nullable = false, columnDefinition = "int default 0")
	private int aId;

	@Column(name = "a_val", columnDefinition = "int default null")
	private Integer aVal;

	@Column(name = "survey_id", columnDefinition = "int default null")
	private Integer surveyId;

	@Column(name = "q_id", nullable = false, columnDefinition = "int default 0")
	private int qId;

	@Column(name = "source_answer_id", columnDefinition = "int default null")
	private Integer sourceAnswerId;

	@Column(name = "t", nullable = false, columnDefinition = "datetime default getdate()")
	private LocalDateTime t;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
}
