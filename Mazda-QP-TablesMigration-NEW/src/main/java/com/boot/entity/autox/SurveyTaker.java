package com.boot.entity.autox;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "qp_survey_taker")
@Data
@NoArgsConstructor
public class SurveyTaker {

	@Column(name = "VIN")
	private String vin;
	@Id
	@Column(name = "SurveyInvitationID")
	private Integer surveyInvitationID;

}
