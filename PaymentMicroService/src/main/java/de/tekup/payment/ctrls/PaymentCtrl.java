package de.tekup.payment.ctrls;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentCtrl {
	
	@GetMapping("/works")
	public String works() {
		return "Payment-SV Works !!!";
	}

}
