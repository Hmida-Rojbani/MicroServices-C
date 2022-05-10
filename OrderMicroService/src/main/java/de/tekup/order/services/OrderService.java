package de.tekup.order.services;

import org.springframework.stereotype.Service;

import de.tekup.order.entities.Order;
import de.tekup.order.repos.OrderRepos;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {
	
	private OrderRepos orderRepos;

	public Order saveOrder(Order order) {
		return orderRepos.save(order);
	}
}
