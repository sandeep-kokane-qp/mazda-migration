package com.boot.repository.autox;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.autox.SrcVehicleSalesData;

public interface SrcVehicleSalesDataRepository extends JpaRepository<SrcVehicleSalesData, Integer> {

	List<SrcVehicleSalesData> findByProcessStatusNotLike(String processStatus);

	List<SrcVehicleSalesData> findByVehicleID(Integer vehicleID);
}
