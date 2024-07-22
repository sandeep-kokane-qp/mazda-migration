package com.boot.repository.autox;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.autox.TblUserInterviewLink;

public interface TblUserInterviewLinkRepo extends JpaRepository<TblUserInterviewLink, Integer> {

	List<TblUserInterviewLink> findBySurvTempId(Integer survTempID);

}
