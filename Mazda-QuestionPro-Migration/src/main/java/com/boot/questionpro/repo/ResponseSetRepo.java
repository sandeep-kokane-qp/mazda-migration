package com.boot.questionpro.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.questionpro.entity.ResponseSet;

public interface ResponseSetRepo extends JpaRepository<ResponseSet, Integer> {

	Optional<ResponseSet> findByCustom2(String interviewId);
}
