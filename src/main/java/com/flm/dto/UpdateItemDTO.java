package com.flm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateItemDTO {
	
	private long itemId;
	
    private String itemName;
	
	private String category;
	
	private double price;
	
	private int quantity;
	
	private int discount;
	
	private double rating;
	
	private String brand;

}
