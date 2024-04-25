package com.boot.questionpro.repo;

import com.boot.questionpro.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

}
