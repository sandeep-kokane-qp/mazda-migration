package com.boot.autox.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.autox.entity.TblQuestionMapping;

public interface TblQuestionMappingRepo extends JpaRepository<TblQuestionMapping, Integer> {

	List<TblQuestionMapping> findAllBySurvTempID(Integer survTempID);

}
