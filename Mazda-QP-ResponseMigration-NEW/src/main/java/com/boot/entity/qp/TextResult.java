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
@Table(name = "qp_text_result", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TextResult {

	@Column(name = "resp_id")
	private Long respId;

	@Column(name = "response_set_id", nullable = false, columnDefinition = "int default 0")
	private int responseSetId;

	@Column(name = "a_id", nullable = false, columnDefinition = "int default 0")
	private int aId;

	@Column(name = "a_val", columnDefinition = "nvarchar(max)")
	private String aVal;

	@Column(name = "q_id", nullable = false, columnDefinition = "int default 0")
	private int qId;

	@Column(name = "survey_id", columnDefinition = "int default null")
	private Integer surveyId;

	@Column(name = "classification_id", columnDefinition = "int default null")
	private Integer classificationId;

	@Column(name = "source_answer_id", columnDefinition = "int default null")
	private Integer sourceAnswerId;

	@Column(name = "t", nullable = false, columnDefinition = "datetime default getdate()")
	private LocalDateTime t;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "sentiment_score", columnDefinition = "int default -1")
	private int sentimentScore;

	@Column(name = "votes", columnDefinition = "int default null")
	private Integer votes;

	@Column(name = "api_sentiment_score", columnDefinition = "float default null")
	private Float apiSentimentScore;

	@Column(name = "api_sentiment_uuid", columnDefinition = "bigint default 0")
	private Long apiSentimentUuid;

	@Column(name = "api_sentiment_status", columnDefinition = "tinyint default 0")
	private byte apiSentimentStatus;

	@Column(name = "sentiment_category", columnDefinition = "int default 0")
	private int sentimentCategory;

	@Column(name = "api_sentiment_category", columnDefinition = "int default 0")
	private int apiSentimentCategory;

	@Column(name = "api_sentiment_category_probability", columnDefinition = "float default 0")
	private float apiSentimentCategoryProbability;

}
