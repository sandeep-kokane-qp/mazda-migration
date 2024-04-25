package com.boot.questionpro.repo;

import com.boot.questionpro.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer, Integer> {

}
