package com.boot.migration.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;

import com.boot.entity.autox.TblPossAnsMapping;
import com.boot.entity.autox.TblQuestionMapping;
import com.boot.entity.qp.Answer;
import com.boot.entity.qp.AnswersMappped;
import com.boot.entity.qp.Question;
import com.boot.entity.qp.QuestionMappped;
import com.boot.repository.autox.TblQuestionMappingRepo;
import com.boot.repository.qp.AnswersMappedRepository;
import com.boot.repository.qp.QuestionMappedRepository;
import com.boot.repository.qp.QuestionRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
@Order(2)
@RequiredArgsConstructor
public class QuestionCurrentCategoryMapper implements ApplicationRunner {

	private final QuestionRepo questionRepo;
	private final TblQuestionMappingRepo tblQuestionMappingRepo;
	private final QuestionMappedRepository questionMappedRepository;
	private final AnswersMappedRepository answerMappedRepository;

	@Value("${autox.survey.template.id}")
	private Integer surveyTemplateId;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("QuestionCurrentCategoryMapper-run");
		List<Question> questionList = questionRepo.findAll().parallelStream()
				.filter(item -> !"Q".equals(item.getType())).filter(item -> item.getCode() != null)
				.filter(item -> !item.getCode().contains("-")).filter(item -> !item.getCode().startsWith("C"))
				.filter(item -> !item.getCode().startsWith("Q")).toList();

		List<TblQuestionMapping> tblQuestionMappingsList = tblQuestionMappingRepo.findAllBySurvTempId(surveyTemplateId);

		Map<String, TblQuestionMapping> questionMappingMap = new HashMap<>();
		for (TblQuestionMapping questionMapping : tblQuestionMappingsList) {
			if (!questionMappingMap.containsKey(
					String.format("%d_%d", questionMapping.getCategoryId(), questionMapping.getQuestionId()))) {
				questionMappingMap.put(
						String.format("%d_%d", questionMapping.getCategoryId(), questionMapping.getQuestionId()),
						questionMapping);
			}
		}

		for (Question question : questionList) {
			if (questionMappingMap
					.containsKey(String.format("%d_%d", question.getCategoryId(), question.getQuestionId()))) {
				TblQuestionMapping tblQuestion = questionMappingMap
						.get(String.format("%d_%d", question.getCategoryId(), question.getQuestionId()));
				QuestionMappped questionMappped = QuestionMappped.builder().qId(question.getId())
						.tsqId(tblQuestion.getTempSpecificQueId()).surveyTemplateId(tblQuestion.getSurvTempId())
						.build();
				questionMappedRepository.save(questionMappped);
				for (TblPossAnsMapping tblPossAnsMapping : tblQuestion.getAnswersList()) {
					for (Answer answer : question.getAnswersList()) {
						if (answer.getAText().equalsIgnoreCase(tblPossAnsMapping.getSurveyDisplayText())) {
							AnswersMappped answersMappped = AnswersMappped.builder().qId(question.getId())
									.tsqId(tblQuestion.getTempSpecificQueId()).aId(answer.getId())
									.ansId(tblPossAnsMapping.getPossAnsId())
									.surveyTemplateId(tblPossAnsMapping.getSurvTempId()).build();
							answerMappedRepository.save(answersMappped);
							break;
						}
					}
				}
				log.info("QuestionMapped for id : " + question.getId());
			}
		}
	}
}
