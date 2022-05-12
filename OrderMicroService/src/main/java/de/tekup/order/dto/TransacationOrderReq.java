package de.tekup.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransacationOrderReq {
	
	private int orderId;
	private double orderValue;

}
