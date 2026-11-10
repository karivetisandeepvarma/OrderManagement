package com.flm.service;

import java.util.List;

import com.flm.dto.NewOrderRequestDTO;
import com.flm.dto.OrderResponseDTO;

public interface OrderService {

	OrderResponseDTO placeOrder(NewOrderRequestDTO orderRequestDTO);

	OrderResponseDTO getOrderById(long orderId);

	List<OrderResponseDTO> getAllOrders();

	void cancelOrder(long orderId);

}
