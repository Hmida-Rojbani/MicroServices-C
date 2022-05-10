package de.tekup.payment.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {
	
	//3rd party application of payment (like Paypal)
	private String processPayment() {
		return new Random().nextBoolean()?"succes":"failed";
	}

}
