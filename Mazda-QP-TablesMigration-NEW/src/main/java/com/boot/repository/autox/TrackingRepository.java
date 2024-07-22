package com.boot.repository.autox;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.autox.Tracking;

public interface TrackingRepository extends JpaRepository<Tracking, Integer> {

	List<Tracking> findByBuyerIDAndCampaignIDIn(int buyerID, List<Integer> campaignIDs);

	Optional<Tracking> findByInterviewIDAndCampaignIDIn(Integer interviewID, List<Integer> campaignIDs);

}
