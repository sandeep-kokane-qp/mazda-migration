package com.boot.migration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.boot.entity.autox.Buyer;
import com.boot.entity.autox.Vehicle;
import com.boot.entity.qp.PanelMember;
import com.boot.repository.autox.BuyerRepository;
import com.boot.repository.autox.VehicleRepository;
import com.boot.repository.qp.PanelMemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
@RequiredArgsConstructor
public class CreateOrUpdatePanelMembers implements ApplicationRunner {

	private final VehicleRepository vehicleRepository;
	private final BuyerRepository buyerRepository;
	private final PanelMemberRepository panelMemberRepository;

	@Value("${autox.program.id}")
	private Integer programID;
	@Value("${autox.program.vehicle.line.id}")
	private Integer vehicleLineID;
	@Value("${qp.user.id}")
	private Integer userID;
	@Value("${qp.cx.feedback.id}")
	private Integer cxFeedbackID;
	@Value("${qp.cx.feedback.panel.id}")
	private Integer panelID;
	@Value("${qp.cx.feedback.segment.id}")
	private Integer segmentID;
	@Value("${qp.cx.feedback.cxuser.id}")
	private Integer cxUserID;
	@Value("${qp.cx.feedback.applied.rules}")
	private String appliedRule;
	@Value("${qp.cx.feedback.workflow.process.id}")
	private Integer workflowProcessID;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("PanelMemberRunner.run()");
		long vehicleCount = vehicleRepository.countByProgramIDAndVehicleLineID(programID, vehicleLineID);
		log.info("Total vehicles :: " + vehicleCount);

		int totalPages = (int) (vehicleCount / 100);

		for (int i = 0; i <= totalPages; i++) {
			log.info("Processing i : " + i);
			Pageable pageable = PageRequest.of(i, 100, Sort.by("VehicleID").ascending());
			List<Vehicle> vehiclesList = vehicleRepository.findAllByProgramIDAndVehicleLineID(programID, vehicleLineID,
					pageable);
			for (Vehicle vehicle : vehiclesList) {
				Optional<Buyer> optionalBuyer = buyerRepository.findByVehicleID(vehicle.getVehicleID());
				if (optionalBuyer.isPresent()) {
					Buyer buyer = optionalBuyer.get();
					log.info("Processing buyer :: " + buyer.getBuyerID());
					Optional<PanelMember> optionalPanelMember = panelMemberRepository
							.findByEmailAddress(buyer.getBuyerEmailAddress());
					PanelMember panelMember = new PanelMember();
					panelMember.setPanelId(panelID);// set panel id
					panelMember.setUserId(userID);// set user id
					panelMember.setEmailAddress(buyer.getBuyerEmailAddress());
					if (optionalPanelMember.isPresent()) {
						// update panel member
						panelMember = optionalPanelMember.get();
						panelMember = getPanelMember(buyer, panelMember);
						panelMemberRepository.save(panelMember);
					} else {
						// create panel member
						panelMember = getPanelMember(buyer, panelMember);
						panelMemberRepository.save(panelMember);
					}
				}
			}
		}

		log.info("Inserted all panel-members");
	}

	private PanelMember getPanelMember(Buyer buyer, PanelMember pm) {
		pm.setCreationDate(buyer.getCreateDate());
		pm.setFirstname(buyer.getBuyerFirstName());
		pm.setLastname(buyer.getBuyerLastName());
		pm.setMiddlename(buyer.getBuyerMiddleName());
		pm.setDomainName(buyer.getBuyerEmailAddressDomain());
		pm.setAddress1(buyer.getBuyerAddress());
		pm.setCity(buyer.getBuyerCity());
		pm.setState(buyer.getBuyerStateProvince());
		pm.setCountry(buyer.getBuyerCountry());
		pm.setMobileNumber(buyer.getBuyerHomeNumber());
		pm.setLastActivityTs(buyer.getModifyDate());
		pm.setLastAppUsed(buyer.getCreateDate());
		pm.setBirthday(buyer.getBuyerBirthday());

		return pm;
	}
}
