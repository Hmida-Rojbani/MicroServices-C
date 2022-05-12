package de.tekup.payment.dto;

import lombok.Data;

@Data
public class TransacationOrderReq {
	
	private int orderId;
	private double orderValue;

}
