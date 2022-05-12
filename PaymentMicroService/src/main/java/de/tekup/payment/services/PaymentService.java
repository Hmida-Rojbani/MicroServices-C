package de.tekup.payment.services;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import de.tekup.payment.dto.TransacationOrderReq;
import de.tekup.payment.dto.TransactionPaymentRes;
import de.tekup.payment.entites.Payment;
import de.tekup.payment.repos.PaymentRepos;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {
	
	private PaymentRepos paymentRepos;
	
	public TransactionPaymentRes savePaymentForOrder(TransacationOrderReq orderReq) {
		
		Payment pay = new Payment();
		pay.setOrderId(orderReq.getOrderId());
		pay.setValue(orderReq.getOrderValue());
		pay.setPaymentStatus(processPayment());
		if(pay.getPaymentStatus().equals("success"))
			pay.setTransactionId(UUID.randomUUID().toString());
		paymentRepos.save(pay);
		return new TransactionPaymentRes(pay.getPaymentStatus(),
				pay.getTransactionId());
		
	}
	
	public List<Payment> getPayments(){
		return paymentRepos.findAll();
	}
	//3rd party application of payment (like Paypal)
	private String processPayment() {
		return new Random().nextBoolean()?"success":"failed";
	}

}
