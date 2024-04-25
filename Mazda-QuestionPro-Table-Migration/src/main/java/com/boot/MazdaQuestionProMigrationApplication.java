package com.boot;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class MazdaQuestionProMigrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MazdaQuestionProMigrationApplication.class, args);
	}

}
