package com.boot.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boot.entity.PanelMember;

public class PanelMemberRowMapper implements RowMapper<PanelMember> {

	@Override
	public PanelMember mapRow(ResultSet rs, int rowNum) throws SQLException {
		PanelMember panelMember = new PanelMember();
		panelMember.setId(rs.getInt("id"));
		panelMember.setPanelId(rs.getInt("panel_id"));
		panelMember.setStatus(rs.getObject("status", Integer.class));
		panelMember.setEmailAddress(rs.getString("email_address"));
		panelMember.setPassword(rs.getString("password"));
		panelMember.setCreationDate(rs.getTimestamp("creation_date"));
		panelMember.setVerifyCode(rs.getString("verify_code"));
		panelMember.setCustom1(rs.getString("custom1"));
		panelMember.setCustom2(rs.getString("custom2"));
		panelMember.setCustom3(rs.getString("custom3"));
		panelMember.setCustom4(rs.getString("custom4"));
		panelMember.setSurveyCompleteCount(rs.getObject("survey_complete_count", Integer.class));
		panelMember.setSurveyTerminateCount(rs.getObject("survey_terminate_count", Integer.class));
		panelMember.setSurveyInviteCount(rs.getObject("survey_invite_count", Integer.class));
		panelMember.setPasswordVerify(rs.getString("password_verify"));
		panelMember.setCountryCodeWeight(rs.getObject("country_code_weight", Float.class));
		panelMember.setFirstname(rs.getString("firstname"));
		panelMember.setMiddlename(rs.getString("middlename"));
		panelMember.setLastname(rs.getString("lastname"));
		panelMember.setSource(rs.getObject("source", Integer.class));
		panelMember.setVerifySendDate(rs.getDate("verify_send_date"));
		panelMember.setUserId(rs.getObject("user_id", Integer.class));
		panelMember.setLastLoginTs(rs.getTimestamp("last_login_ts"));
		panelMember.setCustom5(rs.getString("custom5"));
		panelMember.setSignupIp(rs.getString("signup_ip"));
		panelMember.setLastLoginIp(rs.getString("last_login_ip"));
		panelMember.setReferId(rs.getObject("refer_id", Integer.class));
		panelMember.setWinnerDrawingId(rs.getInt("winner_drawing_id"));
		panelMember.setDomainName(rs.getString("domain_name"));
		panelMember.setUnsubscribeDate(rs.getTimestamp("unsubscribe_date"));
		panelMember.setQpointCount(rs.getInt("qpoint_count"));
		panelMember.setAddress1(rs.getString("address1"));
		panelMember.setAddress2(rs.getString("address2"));
		panelMember.setCity(rs.getString("city"));
		panelMember.setState(rs.getString("state"));
		panelMember.setZipcode(rs.getString("zipcode"));
		panelMember.setCountry(rs.getString("country"));
		panelMember.setDiscussionTopicCount(rs.getInt("discussion_topic_count"));
		panelMember.setDiscussionTopicCommentCount(rs.getInt("discussion_topic_comment_count"));
		panelMember.setModerator(rs.getInt("moderator"));
		panelMember.setNotification(rs.getObject("notification", Integer.class));
		panelMember.setExternalIdentifier(rs.getString("external_identifier"));
		panelMember.setOpenid(rs.getString("openid"));
		panelMember.setIphoneUdid(rs.getString("iphone_udid"));
		panelMember.setIphonePushToken(rs.getString("iphone_push_token"));
		panelMember.setDisplaySettings(rs.getInt("display_settings"));
		panelMember.setPanelLinkId(rs.getObject("panel_link_id", Integer.class));
		panelMember.setLastInvitationDate(rs.getTimestamp("last_invitation_date"));
		panelMember.setLoginCount(rs.getInt("login_count"));
		panelMember.setProfileCompletedDate(rs.getTimestamp("profile_completed_date"));
		panelMember.setPanelSourceId(rs.getObject("panel_source_id", Integer.class));
		panelMember.setCustomSource(rs.getString("custom_source"));
		panelMember.setBirthday(rs.getDate("birthday"));
		panelMember.setUserAgent(rs.getString("user_agent"));
		panelMember.setGlobalEmailCount(rs.getInt("global_email_count"));
		panelMember.setExternalUniqueIdentifier(rs.getString("external_unique_identifier"));
		panelMember.setCounty(rs.getString("county"));
		panelMember.setDefaultLanguage(rs.getObject("default_language", Integer.class));
		panelMember.setSelectedLanguage(rs.getInt("selected_language"));
		panelMember.setZipcode4(rs.getString("zipcode_4"));
		panelMember.setTos(rs.getObject("tos", Integer.class));
		panelMember.setLastActivityTs(rs.getTimestamp("last_activity_ts"));
		panelMember.setDeviceType(rs.getInt("device_type"));
		panelMember.setParentMemberId(rs.getObject("parent_member_id", Integer.class));
		panelMember.setTimezone(rs.getString("timezone"));
		panelMember.setBounceMessage(rs.getString("bounce_message"));
		panelMember.setProfilePicUpdated(rs.getInt("profile_pic_updated"));
		panelMember.setMobileNumber(rs.getString("mobile_number"));
		panelMember.setAdditionalInfoJson(rs.getString("additional_info_json"));
		panelMember.setBirthdayMailSentTimestamp(rs.getTimestamp("birthday_mail_sent_timestamp"));
		panelMember.setLastAppUsed(rs.getTimestamp("last_app_used"));
		panelMember.setFirstLoginTs(rs.getTimestamp("first_login_ts"));
		panelMember.setUsername(rs.getString("username"));
		panelMember.setIsPasswordHashed(rs.getInt("is_password_hashed"));
		panelMember.setBlockedReason(rs.getString("blocked_reason"));

		return panelMember;
	}
}
