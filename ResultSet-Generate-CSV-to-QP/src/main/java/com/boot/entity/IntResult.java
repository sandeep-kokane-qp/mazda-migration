package com.boot.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IntResult {

	private int id;
	private Long respId;
	private int responseSetId;
	private int aId;
	private Integer aVal;
	private Integer surveyId;
	private int qId;
	private Integer sourceAnswerId;
	private LocalDateTime t;

}
