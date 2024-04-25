package com.boot.autox.repo;

import com.boot.autox.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepo extends JpaRepository<Buyer, Integer> {
}
