package com.boot.migration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.boot.autox.entity.TblInterviewResult;
import com.boot.autox.entity.TblUserInterviewLink;
import com.boot.autox.repo.TblUserInterviewLinkRepo;
import com.boot.questionpro.entity.IntResult;
import com.boot.questionpro.entity.Question;
import com.boot.questionpro.entity.TextResult;
import com.boot.questionpro.repo.IntResultRepo;
import com.boot.questionpro.repo.QuestionRepo;
import com.boot.questionpro.repo.TextResultRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class ResponsesMigration implements ApplicationRunner {

	private final QuestionRepo questionRepo;
	private final TblUserInterviewLinkRepo userInterviewLinkRepo;
	private final IntResultRepo intResultRepo;
	private final TextResultRepo textResultRepo;

	@Value("${autox.survey.template.id}")
	private Integer surveyTempId;
	@Value("${qp.cx.feedback.id}")
	private Integer cxFeedbackId;
	@Value("${qp.cx.feedback.survey.id}")
	private Integer cxSurveyId;
	@Value("${qp.cx.feedback.cxuser.id}")
	private Integer cxUserId;
	@Value("${qp.cx.feedback.segment.id}")
	private Integer cxSegmentId;
	@Value("${qp.cx.feedback.panel.id}")
	private Integer panelId;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("test");

		List<Question> questionList = questionRepo.findAll();

		for (Question question : questionList) {
			log.info("question :: " + question);
		}

		List<TblUserInterviewLink> userInterviewLinks = userInterviewLinkRepo.findBySurvTempID(surveyTempId);
		for (TblUserInterviewLink userInterviewLink : userInterviewLinks) {
			// get interview result list from link

			List<TblInterviewResult> interviewResultsList = userInterviewLink.getInterviewResultsList();
			for (TblInterviewResult interviewResult : interviewResultsList) {
				if (interviewResult.getCommentId() == null) {
					// set data for int result
					IntResult intResult = new IntResult();
					// get response set as per the interview id from response set repo
					intResult.setSurveyId(cxSurveyId);

					intResultRepo.save(intResult);
					log.info("saved int_result for interview id : " + interviewResult.getInterviewId());
				} else {
					TextResult textResult = new TextResult();

					textResultRepo.save(textResult);
					log.info("saved text_result for interview id : " + interviewResult.getInterviewId());
				}
			}
			// for loop
			// check whether it has comment id or not
//			and then if comment id then put it in 
		}

	}

}
