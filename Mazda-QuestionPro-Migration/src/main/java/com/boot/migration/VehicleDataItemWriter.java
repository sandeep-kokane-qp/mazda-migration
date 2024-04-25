package com.boot.migration;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class VehicleDataItemWriter implements ItemWriter<VehicleData> {

	@Override
	public void write(List<? extends VehicleData> items) throws Exception {
		// TODO Auto-generated method stub

		for (VehicleData vehicleData : items) {
			log.info("items :: " + vehicleData);

		}

	}

}
