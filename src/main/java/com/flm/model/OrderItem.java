package com.flm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orderitem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderItemId;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	private double orderItemPrice;
	
	private double orderItemQuantity;
	
	private int discount;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	public OrderItem(Item item, double orderItemPrice, double orderItemQuantity, int discount, Order order) {
		super();
		this.item = item;
		this.orderItemPrice = orderItemPrice;
		this.orderItemQuantity = orderItemQuantity;
		this.discount = discount;
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", item=" + item + ", orderItemPrice=" + orderItemPrice
				+ ", orderItemQuantity=" + orderItemQuantity + ", discount=" + discount + ", order=" + order + "]";
	}
	
	

}
