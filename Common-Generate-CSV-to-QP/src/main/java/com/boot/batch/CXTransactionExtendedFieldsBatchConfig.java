package com.boot.batch;

import java.io.File;

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

import com.boot.batch.mapper.CXTransactionExtendedCustomFieldsRowMapper;
import com.boot.entity.CXTransactionExtendedCustomFields;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class CXTransactionExtendedFieldsBatchConfig {

	private final DataSource dataSource;

	@Bean
	ItemReader<CXTransactionExtendedCustomFields> cxTransactionExtendedFieldsItemReader() {
		return new JdbcCursorItemReaderBuilder<CXTransactionExtendedCustomFields>()
				.name("cxTransactionExtendedFieldsItemReader").dataSource(dataSource)
				.sql("SELECT id, user_id, cx_feedback_id, cx_transaction_id, cx_workflow_id, cx_workflow_rule_id, type, "
						+ "ts, custom51, custom52, custom53, custom54, custom55, custom56, custom57, custom58, custom59,"
						+ " custom60, custom61, custom62, custom63, custom64, custom65, custom66, custom67, custom68, custom69,"
						+ " custom70, custom71, custom72, custom73, custom74, custom75, custom76, custom77, custom78, custom79, "
						+ "custom80, custom81, custom82, custom83, custom84, custom85, custom86, custom87, custom88, custom89, "
						+ "custom90, custom91, custom92, custom93, custom94, custom95, custom96, custom97,"
						+ " custom98, custom99, custom100, additional_info_json"
						+ " FROM qp_mazda_cx_transaction_extended_custom_fields;" + "")
				.rowMapper(new CXTransactionExtendedCustomFieldsRowMapper()).build();
	}

	@Bean
	ItemWriter<CXTransactionExtendedCustomFields> cxTransactionExtendedFieldsItemWriter() {
		WritableResource output = new FileSystemResource(
				new File("CxTransactionExtendedFields/cxtransactionextendedfields.csv"));
		String[] fieldNames = getFieldNames(CXTransactionExtendedCustomFields.class);
		return new FlatFileItemWriterBuilder<CXTransactionExtendedCustomFields>()
				.name("cxTransactionExtendedFieldsItemWriter").resource(output).delimited().delimiter(",")
				.names(fieldNames)
				.headerCallback(writer -> writer.write(String.join(",", fieldNames)))
				.build();
	}

	private String[] getFieldNames(Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();
		return Arrays.stream(fields)
				.map(Field::getName)
				.toArray(String[]::new);
	}

	@Bean
	Step cxTransactionExtendedFieldsStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("cxTransactionExtendedFieldsStep", jobRepository)
				.<CXTransactionExtendedCustomFields, CXTransactionExtendedCustomFields>chunk(1000, transactionManager)
				.reader(cxTransactionExtendedFieldsItemReader()).processor(item -> {
					log.info("processing-cx-transaction-extended-fields : " + item.getId());
					return item;
				}).writer(cxTransactionExtendedFieldsItemWriter()).build();
	}

}
