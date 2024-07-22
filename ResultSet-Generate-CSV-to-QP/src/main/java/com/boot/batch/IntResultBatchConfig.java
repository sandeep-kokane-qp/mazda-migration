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

import com.boot.entity.IntResult;
import com.boot.mapper.IntResultRowMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class IntResultBatchConfig {

	private final DataSource dataSource;

	@Bean
	ItemReader<IntResult> intResultItemReader() {
		return new JdbcCursorItemReaderBuilder<IntResult>().name("IntResultItemReader").dataSource(dataSource)
				.sql("SELECT resp_id, response_set_id, a_id, a_val, survey_id, q_id, source_answer_id, t, id "
						+ "FROM dbo.qp_int_result")
				.rowMapper(new IntResultRowMapper()).build();
	}

	@Bean
	ItemWriter<IntResult> intResultItemWriter() {
		WritableResource output = new FileSystemResource(new File("IntResult/intresult.csv"));
		return new FlatFileItemWriterBuilder<IntResult>().name("IntResultItemWriter").resource(output).delimited()
				.delimiter(",")
				.names("id", "respId", "responseSetId", "aId", "aVal", "surveyId", "qId", "sourceAnswerId", "t")
				.build();
	}

	@Bean
	Step intResultStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("IntResultStep", jobRepository).<IntResult, IntResult>chunk(1000, transactionManager)
				.reader(intResultItemReader()).processor(item -> {
					log.info("processing-int-result : " + item.getId());
					return item;
				}).writer(intResultItemWriter()).build();
	}

}
