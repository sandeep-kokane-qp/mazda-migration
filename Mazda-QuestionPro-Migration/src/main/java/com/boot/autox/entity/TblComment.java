package com.boot.autox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblComment")
@Getter
@Setter
@NoArgsConstructor
public class TblComment {

	@Id
	@Column(name = "CommentID")
	private Integer commentId;
	@Column(name = "Comment", length = 2000)
	private String comment;
}
