package com.lcwr.tx.dto;

import com.lcwr.tx.entities.PassengerInfo;
import com.lcwr.tx.entities.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
	
	private PassengerInfo passengerInfo;
	private PaymentInfo paymentInfo;

}
