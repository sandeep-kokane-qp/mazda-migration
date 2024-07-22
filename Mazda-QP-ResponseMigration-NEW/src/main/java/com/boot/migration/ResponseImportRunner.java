package com.boot.migration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.boot.entity.autox.TblInterviewResult;
import com.boot.entity.autox.TblUserInterviewLink;
import com.boot.entity.qp.AnswersMappped;
import com.boot.entity.qp.IntResult;
import com.boot.entity.qp.ResponseSet;
import com.boot.entity.qp.TextResult;
import com.boot.repository.autox.TblUserInterviewLinkRepo;
import com.boot.repository.qp.AnswersMappedRepository;
import com.boot.repository.qp.IntResultRepo;
import com.boot.repository.qp.ResponseSetRepo;
import com.boot.repository.qp.TextResultRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(3)
@RequiredArgsConstructor
public class ResponseImportRunner implements ApplicationRunner {

	private final AnswersMappedRepository answersMappedRepo;
	private final TblUserInterviewLinkRepo tblUserInterviewLinkRepo;
	private final ResponseSetRepo responseSetRepo;
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
		log.info("ResponseImportRunner-run");

		List<AnswersMappped> answersMapppedsList = answersMappedRepo.findAll();

		Map<Integer, List<AnswersMappped>> answersMapppedMap = new HashMap<>();
		for (AnswersMappped ans : answersMapppedsList) {
			if (answersMapppedMap.containsKey(ans.getTsqId())) {
				List<AnswersMappped> list = answersMapppedMap.get(ans.getTsqId());
				list.add(ans);
				answersMapppedMap.put(ans.getTsqId(), list);
			} else {
				List<AnswersMappped> list = new ArrayList<>();
				list.add(ans);
				answersMapppedMap.put(ans.getTsqId(), list);
			}
		}

		List<TblUserInterviewLink> userInterviewLinkList = tblUserInterviewLinkRepo.findBySurvTempId(surveyTempId);
		log.info("Found interview links :: " + userInterviewLinkList.size());

		for (TblUserInterviewLink userInterviewLink : userInterviewLinkList) {
			List<ResponseSet> responseSetList = responseSetRepo
					.findByCustom2(String.valueOf(userInterviewLink.getInterviewId()));
			log.info("found response set list : " + responseSetList.size());
			for (ResponseSet rs : responseSetList) {
				for (TblInterviewResult interviewResult : userInterviewLink.getInterviewResultsList()) {
					log.info("found inteview result list : " + userInterviewLink.getInterviewResultsList().size());
					Integer tsqId = interviewResult.getTempSpecificQueId();
					if (answersMapppedMap.containsKey(tsqId)) {
						List<AnswersMappped> answerMapped = answersMapppedMap.get(tsqId);
						for (AnswersMappped answer : answerMapped) {
							log.info("creating answers");
							if (answer.getAnsId().equals(interviewResult.getAnswerId())) {
								log.info("creating answers-in if");
								createResultAnswer(interviewResult, rs, answer);
								break;
							}
						}
					}
				}
			}

		}

	}

	private void createResultAnswer(TblInterviewResult interviewResult, ResponseSet rs, AnswersMappped answer) {
		if (interviewResult.getCommentId() == null) {
			// create int result
			IntResult intResult = IntResult.builder().surveyId(cxSurveyId).responseSetId(rs.getId())
					.qId(answer.getQId()).aId(answer.getAId()).aVal(1).t(interviewResult.getCreatedDTim()).build();
			log.info("created int result");
			// save intResult
			intResultRepo.save(intResult);
		} else {
			// create text result
			TextResult textResult = TextResult.builder().surveyId(cxSurveyId).responseSetId(rs.getId())
					.qId(answer.getQId()).aId(answer.getAId()).aVal(interviewResult.getTblComment().getComment())
					.t(interviewResult.getCreatedDTim()).build();
			log.info("created text result");
			// save textResult
			textResultRepo.save(textResult);
		}

	}

}
