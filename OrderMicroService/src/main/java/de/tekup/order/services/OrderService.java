package de.tekup.order.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.tekup.order.dto.TransacationOrderReq;
import de.tekup.order.dto.TransactionPaymentRes;
import de.tekup.order.entities.Order;
import de.tekup.order.repos.OrderRepos;
import lombok.AllArgsConstructor;

@Service
public class OrderService {
	
	private OrderRepos orderRepos;
	private RestTemplate template;
	@Value("${gateway.ip}")
	private String GW_URL;
	public OrderService(OrderRepos orderRepos, RestTemplate template) {
		super();
		this.orderRepos = orderRepos;
		this.template = template;
	}



	public Order saveOrder(Order order) {
		//process Payment
		TransacationOrderReq orderReq = new TransacationOrderReq(order.getId(),
				order.getQty()*order.getPrice());
		//calling payment service
		TransactionPaymentRes pay =
				template.postForObject(GW_URL+"/payment/process", orderReq, TransactionPaymentRes.class);
		if(pay.getPaymentStatus().equals("success"))
			order.setTransactionId(pay.getTransactionId());
		//else 
		// exception of payment failed
		return orderRepos.save(order);
	}
}
