package com.lcwr.tx.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lcwr.tx.dto.FlightBookingAcknowledgement;
import com.lcwr.tx.dto.FlightBookingRequest;
import com.lcwr.tx.entities.PassengerInfo;
import com.lcwr.tx.entities.PaymentInfo;
import com.lcwr.tx.repos.PassengerInfoRepository;
import com.lcwr.tx.repos.PaymentInfoRepository;
import com.lcwr.utils.PaymentUtils;

@Service
public class FlightBookingService {
	
	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
	@Transactional//(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
		
		PassengerInfo passengerInfo=request.getPassengerInfo();
		
		passengerInfo=passengerInfoRepository.save(passengerInfo);
		
		PaymentInfo paymentInfo=request.getPaymentInfo();
		
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		
		paymentInfo.setPassengerId(passengerInfo.getPid());
		paymentInfo.setAmount(passengerInfo.getFare());
		
		paymentInfoRepository.save(paymentInfo);
		
		return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),
				UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}

}
