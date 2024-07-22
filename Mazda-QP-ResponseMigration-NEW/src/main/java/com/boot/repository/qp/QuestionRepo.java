package com.boot.repository.qp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.qp.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

}
