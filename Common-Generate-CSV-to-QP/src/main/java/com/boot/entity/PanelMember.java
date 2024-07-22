package com.boot.entity;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PanelMember {

	private int id;
	private int panelId;
	private Integer status;
	private String emailAddress;
	private String password;
	private Date creationDate;
	private String verifyCode;
	private String custom1;
	private String custom2;
	private String custom3;
	private String custom4;
	private Integer surveyCompleteCount;
	private Integer surveyTerminateCount;
	private Integer surveyInviteCount;
	private String passwordVerify;
	private Float countryCodeWeight;
	private String firstname;
	private String middlename;
	private String lastname;
	private Integer source;
	private Date verifySendDate;
	private Integer userId;
	private Date lastLoginTs;
	private String custom5;
	private String signupIp;
	private String lastLoginIp;
	private Integer referId;
	private int winnerDrawingId;
	private String domainName;
	private Date unsubscribeDate;
	private int qpointCount;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private int discussionTopicCount;
	private int discussionTopicCommentCount;
	private int moderator;
	private Integer notification;
	private String externalIdentifier;
	private String openid;
	private String iphoneUdid;
	private String iphonePushToken;
	private int displaySettings;
	private Integer panelLinkId;
	private Date lastInvitationDate;
	private int loginCount;
	private Date profileCompletedDate;
	private Integer panelSourceId;
	private String customSource;
	private Date birthday;
	private String userAgent;
	private int globalEmailCount;
	private String externalUniqueIdentifier;
	private String county;
	private Integer defaultLanguage;
	private int selectedLanguage;
	private String zipcode4;
	private Integer tos;
	private Date lastActivityTs;
	private int deviceType;
	private Integer parentMemberId;
	private String timezone;
	private String bounceMessage;
	private int profilePicUpdated;
	private String mobileNumber;
	private String additionalInfoJson;
	private Date birthdayMailSentTimestamp;
	private Date lastAppUsed;
	private Date firstLoginTs;
	private String username;
	private int isPasswordHashed;
	private String blockedReason;

}
