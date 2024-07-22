package com.boot.repository.autox;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.autox.TblQuestionMapping;

public interface TblQuestionMappingRepo extends JpaRepository<TblQuestionMapping, Integer> {

	List<TblQuestionMapping> findAllBySurvTempId(Integer survTempID);

}
