package com.flm.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.builder.OrderBuilder;
import com.flm.dao.ItemRepository;
import com.flm.dao.OrderRepository;
import com.flm.dto.NewOrderItemRequestDTO;
import com.flm.dto.NewOrderRequestDTO;
import com.flm.dto.OrderResponseDTO;
import com.flm.dto.OrderStatus;
import com.flm.exception.InsufficientQuantityException;
import com.flm.exception.ItemNotFoundException;
import com.flm.exception.OrderNotFoundException;
import com.flm.model.Item;
import com.flm.model.Order;
import com.flm.model.OrderItem;
import com.flm.service.OrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public OrderResponseDTO placeOrder(NewOrderRequestDTO orderRequestDTO) {
		
		Order order = OrderBuilder.buildOrderFromOrderRequestDTO(orderRequestDTO);
		
		List<NewOrderItemRequestDTO> orderItemRequestDTOs = orderRequestDTO.getOrderItemRequestDTOs();
		
		List<OrderItem> orderItems = order.getOrderItems();
		
		double orderItemQuantity=0;
		int itemQuantity=0;
		
		for(int i=0; i<orderItemRequestDTOs.size(); i++)
		{
			long itemId = orderItemRequestDTOs.get(i).getItemId();
			
			Item item = itemRepository.findById(itemId).orElseThrow(()->new ItemNotFoundException("Item Not Found With Id : "+itemId));
			
			itemQuantity=item.getQuantity();
			
			OrderItem orderItem = orderItems.get(i);
			
			orderItemQuantity=orderItem.getOrderItemQuantity();
			
			if(orderItemQuantity>itemQuantity)
			{
				throw new InsufficientQuantityException("Out Of Stock and Available Quantity is : "+itemQuantity);
			}
			
			int quant=itemQuantity-(int)orderItemQuantity;
			
			item.setQuantity(quant);
			
			orderItem.setItem(item);
			
			orderItem.setOrder(order);
			
		}
		
		Order savedOrder = orderRepository.save(order);
		
		OrderResponseDTO orderResponseDTOFromOrder = OrderBuilder.buildOrderResponseDTOFromOrder(savedOrder);
		
		return orderResponseDTOFromOrder;
	}

	@Override
	public OrderResponseDTO getOrderById(long orderId) {
		
		Order order = orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order Not Found with Id : "+orderId));
		
		OrderResponseDTO orderResponseDTOFromOrder = OrderBuilder.buildOrderResponseDTOFromOrder(order);
		
		return orderResponseDTOFromOrder;
		
	}

	@Override
	public List<OrderResponseDTO> getAllOrders() {
		
		List<Order> list = orderRepository.findAll();
		
		if(list.isEmpty())
		{
			throw new OrderNotFoundException("No Orders Placed Yet !!.. ");
		}
		
		List<OrderResponseDTO> list2 = new ArrayList<OrderResponseDTO>();
		
		for(Order o:list)
		{
			OrderResponseDTO orderResponseDTO = OrderBuilder.buildOrderResponseDTOFromOrder(o);
			list2.add(orderResponseDTO);
		}
		return list2;
		
	}

	@Override
	@Transactional
	public void cancelOrder(long orderId) {
		
		Order order = orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order Not Found with Id : "+orderId));
		
		order.setOrderStatus(OrderStatus.CANCELLED.toString());
		
		orderRepository.save(order);
		
	}
	
	

}

