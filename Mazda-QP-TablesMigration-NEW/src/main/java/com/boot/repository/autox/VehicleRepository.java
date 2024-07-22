package com.boot.repository.autox;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.autox.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

	long countByProgramIDAndVehicleLineID(int programID, int VehicleLineID);

	List<Vehicle> findAllByProgramIDAndVehicleLineID(int programID, int vehicleLineID, Pageable pageable);

	Optional<Vehicle> findByVehicleIDAndVehicleLineID(int vehicleID, int vehicleLineID);
}
