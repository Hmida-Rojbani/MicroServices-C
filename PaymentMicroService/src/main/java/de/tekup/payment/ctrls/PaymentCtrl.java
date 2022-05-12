package de.tekup.payment.ctrls;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.payment.dto.TransacationOrderReq;
import de.tekup.payment.dto.TransactionPaymentRes;
import de.tekup.payment.entites.Payment;
import de.tekup.payment.services.PaymentService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentCtrl {
	
	private PaymentService paymentService;
	
	@GetMapping("/works")
	public String works() {
		return "Payment-SV Works !!!";
	}
	
	@GetMapping("/all")
	public List<Payment> getAllPayment(){
		return paymentService.getPayments();
	}
	
	@PostMapping("/process")
	public TransactionPaymentRes processPay(@RequestBody TransacationOrderReq orderReq) {
		return paymentService.savePaymentForOrder(orderReq);
	}
	

}
