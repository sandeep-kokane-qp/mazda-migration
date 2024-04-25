package com.boot.autox.repo;

import com.boot.autox.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingRepo extends JpaRepository<Tracking, Integer> {
}
