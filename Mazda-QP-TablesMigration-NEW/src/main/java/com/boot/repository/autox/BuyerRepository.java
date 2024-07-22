package com.boot.repository.autox;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.autox.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

	Optional<Buyer> findByVehicleID(int vehicleID);
}
