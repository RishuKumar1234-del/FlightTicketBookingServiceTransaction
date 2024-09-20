package com.lcwr.tx.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwr.tx.entities.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {

}
