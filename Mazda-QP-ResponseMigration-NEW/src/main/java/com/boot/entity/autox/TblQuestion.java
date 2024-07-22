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
@Table(name = "tblQuestion", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TblQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QuestionID", nullable = false)
	private Integer questionId;

	@Column(name = "QuestionText", length = 2000)
	private String questionText;

	@Column(name = "ToolTip", length = 2000)
	private String toolTip;

	@Column(name = "TypeID", nullable = false)
	private Byte typeId;

	@Column(name = "RatingID")
	private Byte ratingId;

	@Column(name = "Active", nullable = false, columnDefinition = "bit default 1")
	private Boolean active;

	@Column(name = "AnalysisCode", nullable = false, columnDefinition = "int default 0")
	private Integer analysisCode;

	@Column(name = "LastModifiedDTim", nullable = false)
	private LocalDateTime lastModifiedDTim;

	@Column(name = "CreatedDTim", nullable = false)
	private LocalDateTime createdDTim;

	@Column(name = "PlatformID")
	private Long platformId;

}
