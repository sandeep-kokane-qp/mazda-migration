package com.boot.batch;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.boot.batch.mapper.PanelMemberRowMapper;
import com.boot.entity.PanelMember;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class PanelMemberBatchConfig {

	private final DataSource dataSource;

	@Bean
	ItemReader<PanelMember> panelMemberItemReader() {
		return new JdbcCursorItemReaderBuilder<PanelMember>().name("panelMemberItemReader").dataSource(dataSource)
				.sql("SELECT id, panel_id, status, email_address, password, creation_date, "
						+ "verify_code, custom1, custom2, custom3, custom4, survey_complete_count,"
						+ " survey_terminate_count, survey_invite_count, password_verify, country_code_weight, "
						+ "firstname, middlename, lastname, source, verify_send_date, user_id, last_login_ts,"
						+ " custom5, signup_ip, last_login_ip, refer_id, winner_drawing_id, domain_name,"
						+ " unsubscribe_date, qpoint_count, address1, address2, city, state, zipcode, country, "
						+ "discussion_topic_count, discussion_topic_comment_count, moderator, notification, "
						+ "external_identifier, openid, iphone_udid, iphone_push_token, display_settings,"
						+ " panel_link_id, last_invitation_date, login_count, profile_completed_date, panel_source_id, "
						+ "custom_source, birthday, user_agent, global_email_count, external_unique_identifier, county,"
						+ " default_language, selected_language, zipcode_4, tos, last_activity_ts, device_type,"
						+ " parent_member_id, timezone, bounce_message, profile_pic_updated, mobile_number,"
						+ " additional_info_json, birthday_mail_sent_timestamp, last_app_used, first_login_ts,"
						+ " username, is_password_hashed, blocked_reason FROM dbo.qp_mazda_panel_member;" + "")
				.rowMapper(new PanelMemberRowMapper()).build();
	}

	@Bean
	ItemWriter<PanelMember> panelMemberItemWriter() {
		WritableResource output = new FileSystemResource(new File("output/panelmember.csv"));
		String[] fieldNames = getFieldNames(PanelMember.class);
		return new FlatFileItemWriterBuilder<PanelMember>().name("panelMemberItemWriter").resource(output).delimited()
				.delimiter(",").names(fieldNames).headerCallback(writer -> writer.write(String.join(",", fieldNames)))
				.build();
	}

	private String[] getFieldNames(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		return Arrays.stream(fields).map(Field::getName).toArray(String[]::new);
	}

	@Bean
	Step panelMemberStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("panelMemberStep", jobRepository)
				.<PanelMember, PanelMember>chunk(1000, transactionManager).reader(panelMemberItemReader())
				.processor(item -> {
					log.info("processing-panel-member : " + item.getId());
					return item;
				}).writer(panelMemberItemWriter()).build();
	}

}
