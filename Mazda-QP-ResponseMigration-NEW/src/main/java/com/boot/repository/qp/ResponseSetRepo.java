package com.boot.repository.qp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.qp.ResponseSet;

public interface ResponseSetRepo extends JpaRepository<ResponseSet, Integer> {

	List<ResponseSet> findByCustom2(String interviewId);

}
