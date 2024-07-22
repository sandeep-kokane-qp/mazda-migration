package com.boot.migration.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;

import com.boot.entity.autox.TblQuestionMapping;
import com.boot.entity.qp.Question;
import com.boot.repository.autox.TblQuestionMappingRepo;
import com.boot.repository.qp.AnswersMappedRepository;
import com.boot.repository.qp.QuestionMappedRepository;
import com.boot.repository.qp.QuestionRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
@Order(1)
@RequiredArgsConstructor
public class QuestionCategoryMapper implements ApplicationRunner {

	private final QuestionRepo questionRepo;
	private final TblQuestionMappingRepo tblQuestionMappingRepo;
	private final QuestionMappedRepository questionMappedRepository;
	private final AnswersMappedRepository answerMappedRepository;

	@Value("${autox.survey.template.id}")
	private Integer surveyTemplateId;

	@Value("${autox.survey.template.master.id}")
	private Integer masterSurveyTemplateId;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("QuestionCategoryMapper-run");
		List<Question> questionList = questionRepo.findAll().parallelStream()
				.filter(item -> !"Q".equals(item.getType())).filter(item -> item.getCode() != null)
				.filter(item -> !item.getCode().contains("-")).filter(item -> !item.getCode().startsWith("C"))
				.filter(item -> !item.getCode().startsWith("Q")).toList();
		// fix for this question id 76976-1 , 76977-1, 76978-1
		// 76976
		// write seperate code for this types of questions

		List<TblQuestionMapping> tblQuestionMappingsList = tblQuestionMappingRepo
				.findAllBySurvTempId(masterSurveyTemplateId);

		Map<Integer, TblQuestionMapping> questionMappingMap = new HashMap<>();
		for (TblQuestionMapping questionMapping : tblQuestionMappingsList) {
			if (!questionMappingMap.containsKey(questionMapping.getTempSpecificQueId())) {
				questionMappingMap.put(questionMapping.getTempSpecificQueId(), questionMapping);
			}
		}

		/// update the answer mapped table values so that it should be able to handle
		/// the template specific tsqids and answers id

		for (Question question : questionList) {
			if (question.getCode() != null && questionMappingMap.containsKey(Integer.valueOf(question.getCode()))) {
				log.info("Question Code : " + question.getCode());
				TblQuestionMapping tblQuestion = questionMappingMap.get(Integer.valueOf(question.getCode()));
				log.info("Question :: " + tblQuestion.getTempSpecificQueId());
				log.info("Answers :: "
						+ tblQuestion.getAnswersList().stream().map(item -> item.getPossAnsMappingId()).toList());
				question.setCategoryId(tblQuestion.getCategoryId());
				question.setQuestionId(tblQuestion.getQuestionId());
				questionRepo.save(question);
				log.info("Update ID for:  " + question.getId());
			}
		}
	}
}
