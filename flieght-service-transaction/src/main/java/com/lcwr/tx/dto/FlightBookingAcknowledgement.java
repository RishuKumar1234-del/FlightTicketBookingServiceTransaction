package com.lcwr.tx.dto;

import com.lcwr.tx.entities.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {
	
	private String status;
	private double totalFare;
	private String pnrNo;
	private PassengerInfo passengerInfo;

}
