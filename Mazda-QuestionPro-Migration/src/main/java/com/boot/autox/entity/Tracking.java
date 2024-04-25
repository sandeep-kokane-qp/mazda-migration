package com.boot.autox.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vh_Tracking")
@Getter
@Setter
@NoArgsConstructor
public class Tracking {

	@Id
	@Column(name = "TrackingID")
	private Integer trackingID;
	@Column(name = "BuyerID")
	private Integer buyerID;
	@Column(name = "SurveyStatusID")
	private Integer surveyStatusID;
	@Column(name = "InterviewID")
	private Integer interviewID;
	@Column(name = "InterviewStartDate")
	private LocalDateTime interviewStartDate;
	@Column(name = "InterviewFinishDate")
	private LocalDateTime interviewFinishDate;
	@Column(name = "InviteSent")
	private Integer inviteSent;
	@Column(name = "ReminderSent")
	private Integer reminderSent;
	@Column(name = "ThankYouSent")
	private Integer thankYouSent;
	@Column(name = "CampaignID")
	private Integer campaignID;
	@Column(name = "CreateDate")
	private LocalDateTime createDate;
	@Column(name = "ModifyDate")
	private LocalDateTime modifyDate;

	// one tracking is linked to one user-interview-link

}
