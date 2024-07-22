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

import com.boot.entity.TextResult;
import com.boot.mapper.TextResultRowMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class TextResultBatchConfig {

	private final DataSource dataSource;

	@Bean
	ItemReader<TextResult> textResultItemReader() {
		return new JdbcCursorItemReaderBuilder<TextResult>().name("TextResultItemReader").dataSource(dataSource).sql(
				"SELECT resp_id, response_set_id, a_id, a_val, q_id, survey_id, classification_id, source_answer_id,"
						+ " t, id, sentiment_score, votes, api_sentiment_score, api_sentiment_uuid, api_sentiment_status, "
						+ "sentiment_category, api_sentiment_category, api_sentiment_category_probability "
						+ "FROM dbo.qp_text_result" + "")
				.rowMapper(new TextResultRowMapper()).build();
	}

	@Bean
	ItemWriter<TextResult> textResultItemWriter() {
		WritableResource output = new FileSystemResource(new File("TextResult/textresult.csv"));
		return new FlatFileItemWriterBuilder<TextResult>().name("TextResultItemWriter").resource(output).delimited()
				.delimiter("^")
				.names("respId", "responseSetId", "aId", "aVal", "qId", "surveyId", "classificationId",
						"sourceAnswerId", "t", "id", "sentimentScore", "votes", "apiSentimentScore", "apiSentimentUuid",
						"apiSentimentStatus", "sentimentCategory", "apiSentimentCategory",
						"apiSentimentCategoryProbability")
				.build();
	}

	@Bean
	Step textResultStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("TextResultStep", jobRepository).<TextResult, TextResult>chunk(1000, transactionManager)
				.reader(textResultItemReader()).processor(item -> {
					log.info("processing-text-result : " + item.getId());
					return item;
				}).writer(textResultItemWriter()).build();
	}

}
