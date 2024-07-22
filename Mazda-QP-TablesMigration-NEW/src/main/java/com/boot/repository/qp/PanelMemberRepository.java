package com.boot.repository.qp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.qp.PanelMember;

public interface PanelMemberRepository extends JpaRepository<PanelMember, Integer> {

	Optional<PanelMember> findByEmailAddress(String emailAddress);

}
