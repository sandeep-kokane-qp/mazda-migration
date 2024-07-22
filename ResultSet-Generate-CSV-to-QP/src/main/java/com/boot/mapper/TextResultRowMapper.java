package com.boot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boot.entity.TextResult;

public class TextResultRowMapper implements RowMapper<TextResult> {

	@Override
	public TextResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		TextResult textResult = new TextResult();
		textResult.setRespId(rs.getLong("resp_id"));
		textResult.setResponseSetId(rs.getInt("response_set_id"));
		textResult.setAId(rs.getInt("a_id"));
		textResult.setAVal(rs.getString("a_val"));
		textResult.setQId(rs.getInt("q_id"));
		textResult.setSurveyId(rs.getInt("survey_id")); // handles null values
		textResult.setClassificationId(rs.getInt("classification_id")); // handles null values
		textResult.setSourceAnswerId(rs.getInt("source_answer_id")); // handles null values
		textResult.setT(rs.getTimestamp("t").toLocalDateTime());
		textResult.setId(rs.getInt("id")); // Assuming it's not for persistence
		textResult.setSentimentScore(rs.getInt("sentiment_score"));
		textResult.setVotes(rs.getInt("votes")); // handles null values
		textResult.setApiSentimentScore(rs.getFloat("api_sentiment_score")); // handles null values
		textResult.setApiSentimentUuid(rs.getLong("api_sentiment_uuid"));
		textResult.setApiSentimentStatus(rs.getByte("api_sentiment_status"));
		textResult.setSentimentCategory(rs.getInt("sentiment_category"));
		textResult.setApiSentimentCategory(rs.getInt("api_sentiment_category"));
		textResult.setApiSentimentCategoryProbability(rs.getFloat("api_sentiment_category_probability"));

		return textResult;
	}
}
