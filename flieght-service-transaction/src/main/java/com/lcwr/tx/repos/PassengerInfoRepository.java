package com.lcwr.tx.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwr.tx.entities.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
	

}
