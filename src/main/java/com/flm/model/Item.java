package com.flm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemId;
	
	private String itemName;
	
	private String category;
	
	private double price;
	
	private int quantity;
	
	private int discount;
	
	private double rating;
	
	private String brand;

	public Item(String itemName, String category, double price, int quantity, int discount, double rating,
			String brand) {
		super();
		this.itemName = itemName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
		this.rating = rating;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + ", discount=" + discount + ", rating=" + rating + ", brand=" + brand + "]";
	}
	
	

}
