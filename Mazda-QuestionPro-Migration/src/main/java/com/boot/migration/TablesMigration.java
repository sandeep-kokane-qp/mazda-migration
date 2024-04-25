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
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class TablesMigration {

	private final DataSource dataSource;
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final VehicleDataItemWriter vehicleDataItemWriter;

	@Bean
	public ItemReader<VehicleData> vehicleDataItemReader() {
		String sqlString = "SELECT  src.*, vh.*, buy.*, trk.*"
				+ "  FROM EnpSurveyPlatformMazdaUS.dbo.vh_srcVehicleSalesData src"
				+ "  join EnpSurveyPlatformMazdaUS.dbo.vh_Vehicle vh on src.VehicleID=vh.VehicleID"
				+ "  join EnpSurveyPlatformMazdaUS.dbo.vh_Buyer buy on vh.VehicleID=buy.VehicleID"
				+ "  join EnpSurveyPlatformMazdaUS.dbo.vh_Tracking trk on buy.BuyerID=trk.BuyerID";
		return new JdbcCursorItemReaderBuilder().name("vehicle-data-item-reader").dataSource(dataSource).sql(sqlString)
				.beanRowMapper(VehicleData.class).build();
	}

	@Bean
	public Step vehicleDataStep() {
		return stepBuilderFactory.get("vehicleDataStep").<VehicleData, VehicleData>chunk(100)
				.reader(vehicleDataItemReader()).writer(vehicleDataItemWriter).build();
	}

	@Bean
	public Job vehicleDataJob() {
		return jobBuilderFactory.get("vehicleDataJob").incrementer(new RunIdIncrementer()).start(vehicleDataStep())
				.build();
	}
}
