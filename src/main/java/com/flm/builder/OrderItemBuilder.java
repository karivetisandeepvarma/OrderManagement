package com.flm.builder;


import com.flm.dto.NewOrderItemRequestDTO;
import com.flm.dto.OrderItemResponseDTO;
import com.flm.dto.OrderResponseDTO;
import com.flm.model.OrderItem;

public class OrderItemBuilder {
	
	public static OrderItem buildOrderItemFromOrderRequestDTO(NewOrderItemRequestDTO orderItemRequestDTO)
	{
		
		return OrderItem.builder()
				.orderItemPrice(orderItemRequestDTO.getOrderItemPrice())
				.orderItemQuantity(orderItemRequestDTO.getOrderItemQuantity())
				.discount(orderItemRequestDTO.getDiscount())
				.build();
		
	}
	
	public static OrderItemResponseDTO buildOrderItemResponseDTOFromOrderItem(OrderItem orderItem)
	{
		return OrderItemResponseDTO.builder()
		.orderItemId(orderItem.getOrderItemId())
		.discount(orderItem.getDiscount())
		.orderItemPrice(orderItem.getOrderItemPrice())
		.orderItemQuantity(orderItem.getOrderItemQuantity())
		.itemId(orderItem.getItem().getItemId())
		.itemName(orderItem.getItem().getItemName())
		.build();
	}

}
