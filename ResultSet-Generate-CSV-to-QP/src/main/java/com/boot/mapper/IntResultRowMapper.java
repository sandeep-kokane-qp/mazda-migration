package com.boot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boot.entity.IntResult;

public class IntResultRowMapper implements RowMapper<IntResult> {

	@Override
	public IntResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		IntResult intResult = new IntResult(); // Use no-argument constructor
		intResult.setId(rs.getInt("id"));
		intResult.setRespId(rs.getLong("resp_id"));
		intResult.setResponseSetId(rs.getInt("response_set_id"));
		intResult.setAId(rs.getInt("a_id"));
		intResult.setAVal(rs.getInt("a_val")); // handles both null and int values
		intResult.setSurveyId(rs.getInt("survey_id")); // handles null values
		intResult.setQId(rs.getInt("q_id"));
		intResult.setSourceAnswerId(rs.getInt("source_answer_id")); // handles null values
		intResult.setT(rs.getTimestamp("t").toLocalDateTime());

		return intResult;
	}
}
