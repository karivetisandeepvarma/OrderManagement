package com.flm.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.flm.dto.NewOrderItemRequestDTO;
import com.flm.dto.NewOrderRequestDTO;
import com.flm.dto.OrderItemResponseDTO;
import com.flm.dto.OrderResponseDTO;
import com.flm.dto.OrderStatus;
import com.flm.model.Order;
import com.flm.model.OrderItem;

public class OrderBuilder {
	
	public static Order buildOrderFromOrderRequestDTO(NewOrderRequestDTO orderRequestDTO)
	{
		List<NewOrderItemRequestDTO> orderItemRequestDTOs = orderRequestDTO.getOrderItemRequestDTOs();
		
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		for(NewOrderItemRequestDTO orderItemRequestDTO : orderItemRequestDTOs)
		{
			OrderItem orderItem = OrderItemBuilder.buildOrderItemFromOrderRequestDTO(orderItemRequestDTO);
			
			orderItems.add(orderItem);
		}
		
		return Order.builder()
			.name(orderRequestDTO.getName())
			.noOfItems(orderRequestDTO.getNoOfItems())
			.totalPrice(orderRequestDTO.getTotalPrice())
			.dateOfOrder(LocalDate.now())
			.orderStatus(OrderStatus.PLACED.toString())
			.orderItems(orderItems)
			.build();
	}
	
	public static OrderResponseDTO buildOrderResponseDTOFromOrder(Order order)
	{
		List<OrderItem> orderItems = order.getOrderItems();
		
		List<OrderItemResponseDTO> orderItemResponseDTOList = new ArrayList<OrderItemResponseDTO>();
		
		for(OrderItem orderItem : orderItems)
		{
			OrderItemResponseDTO orderItemResponseDTOFromOrderItem = OrderItemBuilder.buildOrderItemResponseDTOFromOrderItem(orderItem);
			orderItemResponseDTOList.add(orderItemResponseDTOFromOrderItem);
		}
		
		return OrderResponseDTO.builder()
		.orderId(order.getOrderId())
		.name(order.getName())
		.dateOfOrder(order.getDateOfOrder())
		.noOfItems(order.getNoOfItems())
		.totalPrice(order.getTotalPrice())
		.orderStatus(order.getOrderStatus().toString())
		.orderItemResponseDTOs(orderItemResponseDTOList)
		.build();

		
		
	}

}
