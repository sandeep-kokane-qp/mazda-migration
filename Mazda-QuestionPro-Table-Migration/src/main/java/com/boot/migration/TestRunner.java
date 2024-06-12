package com.boot.migration;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.boot.questionpro.entity.PanelMember;
import com.boot.questionpro.repo.PanelMemberRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestRunner implements ApplicationRunner {

	private final PanelMemberRepo panelMemberRepo;
	private final Job job;
	private final JobLauncher jobLauncher;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("test runner");

		PanelMemberStore.setPanelMembersMap(panelMemberRepo.findAll().parallelStream()
				.collect(Collectors.toMap(PanelMember::getEmailAddress, Function.identity())));

		log.info("total panel-members found : " + PanelMemberStore.panelMembersMap.size());

		JobParameters jobParameters = new JobParametersBuilder().addLong("startAt", System.currentTimeMillis())
				.toJobParameters();
		try {
			log.info("starting job");
			jobLauncher.run(job, jobParameters);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("" + e.getStackTrace());
		}

	}

}
