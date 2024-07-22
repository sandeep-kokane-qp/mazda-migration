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

import com.boot.entity.ResponseSet;
import com.boot.mapper.ResponseSetRowMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class ResponseSetBatchConfig {

	private final DataSource dataSource;

	@Bean
	ItemReader<ResponseSet> responseSetItemReader() {
		return new JdbcCursorItemReaderBuilder<ResponseSet>().name("responseSetItemReader").dataSource(dataSource)
				.sql("SELECT id, survey_id, respondent_id, ext_ref, email_addr, ip, t,"
						+ " time_taken, category_id, external_id, duplicate, email_group, external_email_id,"
						+ " geo_code_country, geo_code_country_code, terminated_survey, geo_code_region, geo_code_city,"
						+ " geo_code_area_code, geo_code_dma_code, inset_list, custom1, custom2, custom3, custom4,"
						+ " panel_member_id, weight, custom5, guid, quota_overlimit, panel_id, referer_domain, user_agent,"
						+ " longitude, latitude, radius, cx_business_unit_id, survey_link_id, data_quality_flag,"
						+ " data_quality_score, updated_ts, channel, alternate_flip_order, survey_type FROM dbo.qp_response_set;"
						+ "")
				.rowMapper(new ResponseSetRowMapper()).build();
	}

	@Bean
	ItemWriter<ResponseSet> responseSetItemWriter() {
		WritableResource output = new FileSystemResource(new File("output/responseset.csv"));
		String[] fieldNames = getFieldNames(ResponseSet.class);
		return new FlatFileItemWriterBuilder<ResponseSet>().name("cxTransactionItemWriter").resource(output).delimited()
				.delimiter(",").names(fieldNames).headerCallback(writer -> writer.write(String.join(",", fieldNames)))
				.build();
	}

	private String[] getFieldNames(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		return Arrays.stream(fields).map(Field::getName).toArray(String[]::new);
	}

	@Bean
	Step responseSetStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("ResponseSetStep", jobRepository)
				.<ResponseSet, ResponseSet>chunk(1000, transactionManager).reader(responseSetItemReader())
				.processor(item -> {
					log.info("processing-response : " + item.getId());
					return item;
				}).writer(responseSetItemWriter()).build();
	}

}
