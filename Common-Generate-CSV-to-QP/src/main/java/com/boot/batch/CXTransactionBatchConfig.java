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

import com.boot.batch.mapper.CXTransactionRowMapper;
import com.boot.entity.CXTransaction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class CXTransactionBatchConfig {

	private final DataSource dataSource;

	@Bean
	ItemReader<CXTransaction> cxTransactionItemReader() {
		return new JdbcCursorItemReaderBuilder<CXTransaction>().name("cxTransactionItemReader").dataSource(dataSource)
				.sql("SELECT id, cx_customer_id, cx_feedback_id, cx_store_id, cx_user_id, type_id,"
						+ " ts, cx_date, cx_panel_member_id, resting_time, tansaction_batch_id, touch_point_id, status,"
						+ " custom1, custom2, custom3, custom4, custom5, custom6, custom7, custom8, custom9, custom10, custom11, custom12, custom13, custom14, custom15, custom16, custom17, custom18, custom19, custom20, product_id, response_set_id, wave_id, member_status, cx_distribution_batch_id, survey_id, language_id, custom21, custom22, custom23, custom24, custom25, custom26, custom27, custom28, custom29, custom30, custom31, custom32, custom33, custom34, custom35, custom36, custom37, custom38, custom39, custom40, custom41, custom42, custom43, custom44, custom45, custom46, custom47, custom48, custom49, custom50, org_id, transaction_owner_emails, send_survey_ts, email_template_id, sms_template_id, send_option, applied_rules, product_group_id, invitation_sent_ts, reminder_count, next_reminder_ts, max_reminder_count, import_type, workflow_process_id, panel_log_id, response_status FROM qp_mazda_cx_transaction;\r\n"
						+ "")
				.rowMapper(new CXTransactionRowMapper()).build();
	}

	@Bean
	ItemWriter<CXTransaction> cxTransactionItemWriter() {
		WritableResource output = new FileSystemResource(new File("output/cxtransaction.csv"));
		String[] fieldNames = getFieldNames(CXTransaction.class);
		return new FlatFileItemWriterBuilder<CXTransaction>().name("cxTransactionItemWriter").resource(output)
				.delimited().delimiter(",").names(fieldNames)
				.headerCallback(writer -> writer.write(String.join(",", fieldNames))).build();
	}

	private String[] getFieldNames(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		return Arrays.stream(fields).map(Field::getName).toArray(String[]::new);
	}

	@Bean
	Step cxTransactionStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("cxTransactionStep", jobRepository)
				.<CXTransaction, CXTransaction>chunk(1000, transactionManager).reader(cxTransactionItemReader())
				.processor(item -> {
					log.info("processing-cx-transaction : " + item.getId());
					return item;
				}).writer(cxTransactionItemWriter()).build();
	}

}
