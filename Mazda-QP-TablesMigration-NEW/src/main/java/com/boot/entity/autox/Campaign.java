package com.boot.entity.autox;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Campaign", schema = "tracking")
public class Campaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CampaignID", nullable = false)
	private Integer campaignId;

	@Column(name = "CampaignName", nullable = false, length = 255)
	private String campaignName;

	@Column(name = "ProgramID", nullable = false)
	private Integer programId;

	@Column(name = "Market", length = 50)
	private String market;

	@Column(name = "CampaignTrigger", nullable = false, length = 50)
	private String campaignTrigger;

	@Column(name = "MIS")
	private Short mis;

	@Column(name = "SendInvite", nullable = false)
	private Boolean sendInvite;

	@Column(name = "SendReminder", nullable = false)
	private Boolean sendReminder;

	@Column(name = "SendThankYou", nullable = false)
	private Boolean sendThankYou;

	@Column(name = "EffectiveStartDate", nullable = false)
	private LocalDate effectiveStartDate;

	@Column(name = "EffectiveEndDate", nullable = false)
	private LocalDate effectiveEndDate;

	@Column(name = "IsEmployeeCampaign", nullable = false)
	private Boolean isEmployeeCampaign;

	@Column(name = "AbandonedDayCount", nullable = false)
	private Short abandonedDayCount;

	@Column(name = "AutoCloseDayCount", nullable = false)
	private Short autoCloseDayCount;

	@Column(name = "ReminderDayCount", nullable = false)
	private Short reminderDayCount;

	@Column(name = "MessagePriority", nullable = false, length = 50)
	private String messagePriority;

	@Column(name = "SendInviteMinDayCount", nullable = false)
	private Short sendInviteMinDayCount;

	@Column(name = "SendInviteMaxDayCount", nullable = false)
	private Short sendInviteMaxDayCount;

	@Column(name = "IsActive", nullable = false)
	private Boolean isActive;

	@Column(name = "ClosedReason", length = 255)
	private String closedReason;

	@Column(name = "CompletedOwnershipMonths", nullable = false)
	private Boolean completedOwnershipMonths;

	@Column(name = "migrationID")
	private Integer migrationId;

	@Column(name = "SendSecondReminder", nullable = false)
	private Boolean sendSecondReminder;

	@Column(name = "SecondReminderDayCount", nullable = false)
	private Short secondReminderDayCount;

}
