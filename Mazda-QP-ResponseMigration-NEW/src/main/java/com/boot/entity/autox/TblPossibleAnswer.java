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
@Table(name = "tblPossibleAnswer", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TblPossibleAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PossAnsID", nullable = false)
	private Integer possAnsID;

	@Column(name = "PossAnsText", nullable = false, length = 2000)
	private String possAnsText;

	@Column(name = "ToolTip", length = 2000)
	private String toolTip;

	@Column(name = "TypeID", nullable = false)
	private Byte typeID;

	@Column(name = "Active", nullable = false)
	private Boolean active;

	@Column(name = "LastModifiedDTim", nullable = false)
	private LocalDateTime lastModifiedDTim;

	@Column(name = "CreatedDTim", nullable = false)
	private LocalDateTime createdDTim;

	@Column(name = "PossAnsValue", nullable = false, length = 2000)
	private String possAnsValue;

	@Column(name = "PlatformID")
	private Long platformID;

}
