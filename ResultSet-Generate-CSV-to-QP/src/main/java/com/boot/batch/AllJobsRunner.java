package com.boot.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AllJobsRunner {

	private final Step responseSetStep;
	private final Step intResultStep;
	private final Step textResultStep;

	@Bean
	Job launchAllJobs(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new JobBuilder("all-job-launcher", jobRepository).incrementer(new RunIdIncrementer())
				.start(responseSetStep).next(intResultStep).next(textResultStep).build();
	}

}
