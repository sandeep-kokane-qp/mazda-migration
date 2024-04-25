package com.boot.autox.repo;

import com.boot.autox.entity.TblUserInterviewLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TblUserInterviewLinkRepo extends JpaRepository<TblUserInterviewLink, Integer> {

    List<TblUserInterviewLink> findBySurvTempID(Integer survTempID);

}
