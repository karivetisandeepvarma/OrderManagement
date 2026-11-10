package com.flm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flm.dto.NewOrderRequestDTO;
import com.flm.dto.OrderResponseDTO;
import com.flm.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/new")
	public ResponseEntity<OrderResponseDTO> placeOrder(@RequestBody NewOrderRequestDTO orderRequestDTO)
	{
		
		OrderResponseDTO order = orderService.placeOrder(orderRequestDTO);
		
		return new ResponseEntity<>(order,HttpStatus.CREATED);
	}
	
	@GetMapping("/findorderbyid/{orderId}")
	public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable long orderId)
	{
		OrderResponseDTO orderResponseDTO = orderService.getOrderById(orderId);
		
		return new ResponseEntity<OrderResponseDTO>(orderResponseDTO,HttpStatus.OK);
	}
	
	@GetMapping("/allorders")
	public ResponseEntity<List<OrderResponseDTO>> getAllOrders()
	{
		List<OrderResponseDTO> allOrders = orderService.getAllOrders();
		
		return new ResponseEntity<List<OrderResponseDTO>>(allOrders,HttpStatus.OK);
	}
	
	@DeleteMapping("/cancelorder/{orderId}")
	public ResponseEntity<Void> cancelOrder(@PathVariable long orderId)
	{
		orderService.cancelOrder(orderId);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

}
