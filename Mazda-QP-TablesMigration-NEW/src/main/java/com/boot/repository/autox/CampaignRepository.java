package com.boot.repository.autox;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.autox.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

	List<Campaign> findAllByProgramId(Integer programId);
}
