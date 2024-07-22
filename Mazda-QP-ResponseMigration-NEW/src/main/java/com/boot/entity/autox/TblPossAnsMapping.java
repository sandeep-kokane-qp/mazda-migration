package com.boot.entity.autox;

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
@Table(name = "tblPossAnsMapping", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TblPossAnsMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PossAnsMappingID", nullable = false)
	private Long possAnsMappingId;

	@Column(name = "TempSpecificQueID", nullable = false)
	private Integer tempSpecificQueId;

	@Column(name = "PossAnsID", nullable = false)
	private Integer possAnsId;

	@Column(name = "SurveyDisplayText", length = 4000)
	private String surveyDisplayText;

	@Column(name = "ReportingDisplayText", length = 4000)
	private String reportingDisplayText;

	@Column(name = "PossAnsDispOrd")
	private Integer possAnsDispOrd;

	@Column(name = "SurvTempID", nullable = false, columnDefinition = "int default 0")
	private Integer survTempId;

	@Column(name = "ToolTip", length = 500)
	private String toolTip;

	@Column(name = "IsActive", nullable = false, columnDefinition = "bit default 1")
	private Boolean isActive;

	@Column(name = "ModifiedDTim")
	private LocalDateTime modifiedDtim;

	@Column(name = "SurveyDisplayTextEmployee", length = 4000)
	private String surveyDisplayTextEmployee;

	@Column(name = "IsEmployeeActive")
	private Boolean isEmployeeActive;

	@Column(name = "PlatformID")
	private Long platformId;

}
