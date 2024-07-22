package com.boot.repository.qp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.qp.IntResult;

public interface IntResultRepo extends JpaRepository<IntResult, Integer> {

}
