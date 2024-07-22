package com.boot.entity.autox;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Tracking", schema = "tracking")
public class Tracking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TrackingID", nullable = false)
	private int trackingID;

	@Column(name = "BuyerID", nullable = false)
	private int buyerID;

	@Column(name = "SurveyStatusID", nullable = false)
	private int surveyStatusID;

	@Column(name = "InterviewID")
	private Integer interviewID;

	@Column(name = "InterviewStartDate")
	private Date interviewStartDate;

	@Column(name = "InterviewFinishDate")
	private Date interviewFinishDate;

	@Column(name = "InviteSent", nullable = false)
	private boolean inviteSent;

	@Column(name = "ReminderSent", nullable = false)
	private boolean reminderSent;

	@Column(name = "ThankYouSent", nullable = false)
	private boolean thankYouSent;

	@Column(name = "CampaignID", nullable = false)
	private int campaignID;

	@Column(name = "CreateDate", nullable = false)
	private Date createDate;

	@Column(name = "ModifyDate", nullable = false)
	private Date modifyDate;

	@Column(name = "migrationID")
	private Integer migrationID;

	@Column(name = "URLShort", length = 25)
	private String urlShort;

	@Column(name = "URLLong", length = 2000)
	private String urlLong;

	@Column(name = "URLHash", length = 10)
	private String urlHash;

	@Column(name = "LandingPageCode", length = 50)
	private String landingPageCode;

	@Column(name = "SurveySystemClosedDate")
	private Date surveySystemClosedDate;

	@Column(name = "SecondReminderSent", nullable = false)
	private boolean secondReminderSent;

}
