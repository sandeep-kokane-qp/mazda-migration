package com.boot.migration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

//@Configuration
@RequiredArgsConstructor
public class TablesMigration {

	private final DataSource dataSource;
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final VehicleDataItemWriter vehicleDataItemWriter;
	private final VehicleDataRowMapper rowMapper;

	@Bean
	public ItemReader<VehicleData> vehicleDataItemReader() {
		String sqlString = "SELECT  src.*, vh.*, buy.*, buy.CreateDate as BuyerCreateDate, trk.*, trk.CreateDate as trackCreateDate, trk.ModifyDate as trackModifyDate"
				+ "  FROM VehicleSales.mazdaus.srcVehicleSalesData src"
				+ "  JOIN VehicleSales.ods.Vehicle vh on src.VehicleID=vh.VehicleID"
				+ "  JOIN VehicleSales.ods.Buyer buy on vh.VehicleID=buy.VehicleID"
				+ "  JOIN VehicleSales.tracking.Tracking trk on buy.BuyerID=trk.BuyerID"
				+ "  WHERE src.srcVehicleSalesDataID > 36871328" + "  ORDER BY src.srcVehicleSalesDataID ASC";
		return new JdbcCursorItemReaderBuilder<VehicleData>().name("vehicle-data-item-reader").dataSource(dataSource)
				.sql(sqlString).rowMapper(rowMapper).build();
	}

	@Bean
	public Step vehicleDataStep() {
		return stepBuilderFactory.get("vehicleDataStep").<VehicleData, VehicleData>chunk(500)
				.reader(vehicleDataItemReader()).writer(vehicleDataItemWriter).build();
	}

	@Bean
	public Job vehicleDataJob() {
		return jobBuilderFactory.get("vehicleDataJob").incrementer(new RunIdIncrementer()).start(vehicleDataStep())
				.build();
	}
}
