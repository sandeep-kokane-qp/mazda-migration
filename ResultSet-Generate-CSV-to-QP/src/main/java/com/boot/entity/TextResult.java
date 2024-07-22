package com.boot.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextResult {

	private Long respId;
	private int responseSetId;
	private int aId;
	private String aVal;
	private int qId;
	private Integer surveyId;
	private Integer classificationId;
	private Integer sourceAnswerId;
	private LocalDateTime t;
	private Integer id; // Assuming it's not used for persistence logic
	private int sentimentScore;
	private Integer votes;
	private Float apiSentimentScore;
	private Long apiSentimentUuid;
	private byte apiSentimentStatus;
	private int sentimentCategory;
	private int apiSentimentCategory;
	private float apiSentimentCategoryProbability;

}
