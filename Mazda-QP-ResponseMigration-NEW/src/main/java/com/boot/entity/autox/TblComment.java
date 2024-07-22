package com.boot.entity.autox;

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
@Table(name = "tblComment", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TblComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CommentID", nullable = false)
	private Integer commentId;

	@Column(name = "Comment", length = 2000)
	private String comment;

}
