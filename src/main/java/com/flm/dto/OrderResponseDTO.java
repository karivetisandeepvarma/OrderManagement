package com.flm.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDTO {
	
	private long orderId;
	
	private String name;
	
	private LocalDate dateOfOrder;
	
	private double totalPrice;
	
	private int noOfItems;
	
	private String orderStatus;
	
	private List<OrderItemResponseDTO> orderItemResponseDTOs;
	
	

}
