package com.boot.migration;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.boot.autox.entity.TblInterviewResult;
import com.boot.autox.entity.TblPossAnsMapping;
import com.boot.autox.entity.TblQuestionMapping;
import com.boot.autox.entity.TblUserInterviewLink;
import com.boot.autox.repo.TblQuestionMappingRepo;
import com.boot.autox.repo.TblUserInterviewLinkRepo;
import com.boot.questionpro.entity.Answer;
import com.boot.questionpro.entity.IntResult;
import com.boot.questionpro.entity.Question;
import com.boot.questionpro.entity.ResponseSet;
import com.boot.questionpro.entity.TextResult;
import com.boot.questionpro.repo.IntResultRepo;
import com.boot.questionpro.repo.QuestionRepo;
import com.boot.questionpro.repo.ResponseSetRepo;
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
	private final ResponseSetRepo responseSetRepo;
	private final TblQuestionMappingRepo questionMappingRepo;

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
		log.info("ResponsesMigration.run");
		Map<String, Question> questionMap = questionRepo.findAll().parallelStream()
				.filter(e -> e.getCategoryId() != null).collect(Collectors
						.toMap(e -> String.format("%d_%d", e.getCategoryId(), e.getQuestionId()), Function.identity()));

		Map<Integer, TblQuestionMapping> questionMappingMap = questionMappingRepo.findAllBySurvTempID(surveyTempId)
				.parallelStream()
				.collect(Collectors.toMap(TblQuestionMapping::getTempSpecificQueID, Function.identity()));

		List<TblUserInterviewLink> userInterviewLinks = userInterviewLinkRepo.findBySurvTempID(surveyTempId);
		for (TblUserInterviewLink userInterviewLink : userInterviewLinks) {
			// get interview result list from link

			Integer interviewID = userInterviewLink.getInterviewID();
			Optional<ResponseSet> responseSetsOptional = responseSetRepo.findByCustom2(String.valueOf(interviewID));
			if (responseSetsOptional.isPresent()) {
				ResponseSet rs = responseSetsOptional.get();
				for (TblInterviewResult interviewResult : userInterviewLink.getInterviewResultsList()) {

					Integer tsqID = interviewResult.getTempSpecificQueId();
					if (questionMappingMap.containsKey(tsqID)) {
						TblQuestionMapping questionMapping = questionMappingMap.get(tsqID);
						if (questionMap.containsKey(String.format("%d_%d", questionMapping.getCategoryID(),
								questionMapping.getQuestionID()))) {
							Question question = questionMap.get(String.format("%d_%d", questionMapping.getCategoryID(),
									questionMapping.getQuestionID()));
							Integer answerID = interviewResult.getAnswerId();
							List<TblPossAnsMapping> possAnsMappingsList = questionMapping.getTblPossAnsMappingsList();
							Answer answer = null;
							for (TblPossAnsMapping possAnsMapping : possAnsMappingsList) {
								if (answerID == possAnsMapping.getPossAnsID()) {
									List<Answer> answersList = question.getAnswersList();
									for (Answer ans : answersList) {
										if (ans.getAText() != null
												&& ans.getAText().equals(possAnsMapping.getSurveyDisplayText())) {
											answer = ans;
											break;
										}
									}
									break;
								}
							}
							if (answer == null) {
								continue;
							}
							Integer questionID = question.getId();
							if (interviewResult.getCommentId() == null) {
								IntResult intResult = new IntResult();
								intResult.setSurveyId(cxSurveyId);
								intResult.setResponseSetId(rs.getId());
								intResult.setQId(questionID);
								intResult.setAId(answer.getId());
								intResult.setAVal(1);
								intResult.setT(interviewResult.getCreatedDTim() != null
										? Timestamp.valueOf(interviewResult.getCreatedDTim())
										: null);

								// save int result
								intResultRepo.save(intResult);
								log.info("saved int_result data for interview result : "
										+ interviewResult.getResultId());
							} else {
								TextResult textResult = new TextResult();
								textResult.setSurveyId(cxSurveyId);
								textResult.setResponseSetId(rs.getId());
								textResult.setQId(questionID);
								textResult.setAId(answer.getId());
								textResult.setSourceAnswerId(0);
								textResult.setSentimentScore(-1);
								textResult.setApiSentimentScore(0f);
								textResult.setSentimentScore(0);

								textResult.setT(interviewResult.getCreatedDTim() != null
										? Timestamp.valueOf(interviewResult.getCreatedDTim())
										: null);

								textResult.setAVal(interviewResult.getTblComment().getComment());

//								log.info("" + textResult);

								// save text result
								textResultRepo.save(textResult);
								log.info("saved text_result data for interview result : "
										+ interviewResult.getResultId());
							}
						}

					}

				}
			}
		}

	}

}
