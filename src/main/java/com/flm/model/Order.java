package com.flm.model;

import java.time.LocalDate;
import java.util.List;

import com.flm.dto.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	private String name;
	
	private LocalDate dateOfOrder;
	
	private double totalPrice;
	
	private int noOfItems;
	
	private String orderStatus;
	
	@OneToMany(mappedBy = "order", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderItem> orderItems;

	public Order(String name, LocalDate dateOfOrder, double totalPrice, int noOfItems, String orderStatus,
			List<OrderItem> orderItems) {
		super();
		this.name = name;
		this.dateOfOrder = dateOfOrder;
		this.totalPrice = totalPrice;
		this.noOfItems = noOfItems;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", name=" + name + ", dateOfOrder=" + dateOfOrder + ", totalPrice="
				+ totalPrice + ", noOfItems=" + noOfItems + ", orderStatus=" + orderStatus + ", orderItems="
				+ orderItems + "]";
	}
	
	
}
