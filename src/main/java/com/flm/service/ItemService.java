package com.flm.service;

import java.util.List;

import com.flm.dto.AddItemDTO;
import com.flm.dto.ItemResponseDTO;
import com.flm.dto.UpdateItemDTO;



public interface ItemService {
	
	public ItemResponseDTO saveItem(AddItemDTO addItemDTO);

	public ItemResponseDTO getItemById(long itemId);

	public List<ItemResponseDTO> getAllItems();

	public ItemResponseDTO updateItem(UpdateItemDTO item);

	public String deleteItem(long id);

	public List<ItemResponseDTO> getItemsByNameStartingWith(String name);

	public List<ItemResponseDTO> getItemByNameContaining(String name);

	public List<ItemResponseDTO> getItemByRatingGreaterThan(double rating);

	public List<ItemResponseDTO> getItemByPriceBetween(double price1, double price2);

	public ItemResponseDTO updateRating(long itemId, double rating);

	
}
