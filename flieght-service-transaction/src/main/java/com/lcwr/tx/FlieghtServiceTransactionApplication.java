package com.lcwr.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lcwr.tx.dto.FlightBookingAcknowledgement;
import com.lcwr.tx.dto.FlightBookingRequest;
import com.lcwr.tx.services.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlieghtServiceTransactionApplication {
	
	@Autowired
	private FlightBookingService bookingService;
	
	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		
		return bookingService.bookFlightTicket(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(FlieghtServiceTransactionApplication.class, args);
		System.out.println("FlightServiceTransaction project Started...!!!");
	}

}
