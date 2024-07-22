package com.boot.entity.qp;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "qp_mazda_panel_member")
@Getter
@Setter
@NoArgsConstructor
public class PanelMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0", name = "panel_id")
	private int panelId;

	@Column(columnDefinition = "INT DEFAULT NULL")
	private Integer status;

	@Column(name = "email_address", length = 320, columnDefinition = "VARCHAR(320) DEFAULT NULL")
	private String emailAddress;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String password;

	@Column(columnDefinition = "DATETIME DEFAULT NULL", name = "creation_date")
	private Date creationDate;

	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL", name = "verify_code")
	private String verifyCode;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String custom1;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String custom2;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String custom3;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String custom4;

	@Column(columnDefinition = "INT DEFAULT NULL", name = "survey_complete_count")
	private Integer surveyCompleteCount;

	@Column(columnDefinition = "INT DEFAULT NULL", name = "survey_terminate_count")
	private Integer surveyTerminateCount;

	@Column(columnDefinition = "INT DEFAULT NULL", name = "survey_invite_count")
	private Integer surveyInviteCount;

	@Column(length = 32, columnDefinition = "VARCHAR(32) DEFAULT NULL", name = "password_verify")
	private String passwordVerify;

	@Column(columnDefinition = "FLOAT DEFAULT NULL", name = "country_code_weight")
	private Float countryCodeWeight;

	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL")
	private String firstname;

	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL")
	private String middlename;

	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL")
	private String lastname;

	@Column(columnDefinition = "INT DEFAULT NULL")
	private Integer source;

	@Column(columnDefinition = "DATE DEFAULT NULL", name = "verify_send_date")
	private Date verifySendDate;

	@Column(columnDefinition = "INT DEFAULT NULL", name = "user_id")
	private Integer userId;

	@Column(columnDefinition = "DATETIME DEFAULT NULL", name = "last_login_ts")
	private Date lastLoginTs;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String custom5;

	@Column(length = 46, columnDefinition = "VARCHAR(46) DEFAULT NULL", name = "signup_ip")
	private String signupIp;

	@Column(length = 46, columnDefinition = "VARCHAR(46) DEFAULT NULL", name = "last_login_ip")
	private String lastLoginIp;

	@Column(columnDefinition = "INT DEFAULT NULL", name = "refer_id")
	private Integer referId;

	@Column(columnDefinition = "INT DEFAULT 0", name = "winner_drawing_id")
	private int winnerDrawingId;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL", name = "domain_name")
	private String domainName;

	@Column(columnDefinition = "DATETIME DEFAULT NULL", name = "unsubscribe_date")
	private Date unsubscribeDate;

	@Column(columnDefinition = "INT DEFAULT 0", name = "qpoint_count")
	private int qpointCount;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String address1;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL")
	private String address2;

	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL")
	private String city;

	@Column(length = 32, columnDefinition = "VARCHAR(32) DEFAULT NULL")
	private String state;

	@Column(length = 16, columnDefinition = "VARCHAR(16) DEFAULT NULL")
	private String zipcode;

	@Column(length = 32, columnDefinition = "VARCHAR(32) DEFAULT NULL")
	private String country;

	@Column(columnDefinition = "INT DEFAULT 0", name = "discussion_topic_count")
	private int discussionTopicCount;

	@Column(columnDefinition = "INT DEFAULT 0", name = "discussion_topic_comment_count")
	private int discussionTopicCommentCount;

	@Column(columnDefinition = "INT DEFAULT 0")
	private int moderator;

	@Column(columnDefinition = "INT DEFAULT NULL")
	private Integer notification;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL", name = "external_identifier")
	private String externalIdentifier;

	@Column(length = 255, columnDefinition = "VARCHAR(255) DEFAULT NULL")
	private String openid;

	@Column(length = 36, columnDefinition = "VARCHAR(36) DEFAULT NULL", name = "iphone_udid")
	private String iphoneUdid;

	@Column(length = 256, columnDefinition = "VARCHAR(256) DEFAULT NULL", name = "iphone_push_token")
	private String iphonePushToken;

	@Column(columnDefinition = "INT DEFAULT 0", name = "display_settings")
	private int displaySettings;

	@Column(columnDefinition = "INT DEFAULT NULL", name = "panel_link_id")
	private Integer panelLinkId;

	@Column(columnDefinition = "DATETIME DEFAULT NULL", name = "last_invitation_date")
	private Date lastInvitationDate;

	@Column(columnDefinition = "INT DEFAULT 0", name = "login_count")
	private int loginCount;

	@Column(columnDefinition = "DATETIME DEFAULT NULL", name = "profile_completed_date")
	private Date profileCompletedDate;

	@Column(columnDefinition = "INT DEFAULT NULL", name = "panel_source_id")
	private Integer panelSourceId;

	@Column(length = 128, columnDefinition = "VARCHAR(128) DEFAULT NULL", name = "custom_source")
	private String customSource;

	@Column(columnDefinition = "DATE DEFAULT NULL")
	private Date birthday;

	@Column(length = 512, columnDefinition = "VARCHAR(512) DEFAULT NULL", name = "user_agent")
	private String userAgent;

	@Column(columnDefinition = "INT DEFAULT 0", name = "global_email_count")
	private int globalEmailCount;

	@Column(length = 32, columnDefinition = "CHAR(32) DEFAULT NULL", name = "external_unique_identifier")
	private String externalUniqueIdentifier;

	@Column(length = 255, columnDefinition = "VARCHAR(255) DEFAULT NULL")
	private String county;

	@Column(columnDefinition = "INT DEFAULT NULL", name = "default_language")
	private Integer defaultLanguage;

	@Column(columnDefinition = "INT DEFAULT -1", name = "selected_language")
	private int selectedLanguage;

	@Column(length = 10, columnDefinition = "CHAR(10) DEFAULT NULL", name = "zipcode_4")
	private String zipcode4;

	@Column(columnDefinition = "INT DEFAULT NULL")
	private Integer tos;

	@Column(columnDefinition = "DATETIME DEFAULT NULL", name = "last_activity_ts")
	private Date lastActivityTs;

	@Column(columnDefinition = "INT DEFAULT 0", name = "device_type")
	private int deviceType;

	@Column(columnDefinition = "INT DEFAULT NULL", name = "parent_member_id")
	private Integer parentMemberId;

	@Column(length = 64, columnDefinition = "VARCHAR(64) DEFAULT NULL")
	private String timezone;

	@Lob
	@Column(columnDefinition = "TEXT", name = "bounce_message")
	private String bounceMessage;

	@Column(nullable = false, columnDefinition = "INT DEFAULT 0", name = "profile_pic_updated")
	private int profilePicUpdated;

	@Column(length = 30, columnDefinition = "VARCHAR(30) DEFAULT NULL", name = "mobile_number")
	private String mobileNumber;

	@Lob
	@Column(columnDefinition = "TEXT", name = "additional_info_json")
	private String additionalInfoJson;

	@Column(columnDefinition = "DATETIME DEFAULT NULL", name = "birthday_mail_sent_timestamp")
	private Date birthdayMailSentTimestamp;

	@Column(nullable = true, columnDefinition = "DATETIME DEFAULT GETDATE()", name = "last_app_used")
	private Date lastAppUsed;

	@Column(columnDefinition = "DATETIME DEFAULT NULL", name = "first_login_ts")
	private Date firstLoginTs;

	@Column(length = 50, columnDefinition = "VARCHAR(50) DEFAULT NULL")
	private String username;

	@Column(columnDefinition = "INT DEFAULT 0", name = "is_password_hashed")
	private int isPasswordHashed;

	@Column(length = 100, columnDefinition = "VARCHAR(100) DEFAULT NULL", name = "blocked_reason")
	private String blockedReason;

}
