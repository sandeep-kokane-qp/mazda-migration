package com.boot.migration;

import com.boot.autox.entity.TblUserInterviewLink;
import com.boot.autox.entity.Tracking;
import com.boot.autox.repo.TblUserInterviewLinkRepo;
import com.boot.autox.repo.TrackingRepo;
import com.boot.questionpro.entity.Question;
import com.boot.questionpro.repo.QuestionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Component
@Slf4j
@RequiredArgsConstructor
public class ResponsesMigration implements ApplicationRunner {

    private final QuestionRepo questionRepo;
    private final TblUserInterviewLinkRepo userInterviewLinkRepo;
    private final TrackingRepo trackingRepo;

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

        List<TblUserInterviewLink> userInterviewLinks = userInterviewLinkRepo.findBySurvTempID(surveyTempId);
        for (TblUserInterviewLink userInterviewLink : userInterviewLinks) {

            Integer interviewID = userInterviewLink.getInterviewID();

            Optional<Tracking> optionalTracking = trackingRepo.findById(interviewID);
            if (optionalTracking.isPresent()) {
                Tracking tracking = optionalTracking.get();
            }

        }

        // get userinterlinks
        // create panel_member, cx_transaction, responset_set, custom fields
        //


        List<Question> questionList = questionRepo.findAll();
        for (Question question : questionList) {
            System.out.println(question);
        }
    }


}
