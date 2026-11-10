package com.flm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flm.dao.ItemRepository;
import com.flm.dto.AddItemDTO;
import com.flm.dto.ItemResponseDTO;
import com.flm.dto.UpdateItemDTO;
import com.flm.exception.InvalidRatingException;
import com.flm.exception.ItemNotFoundException;
import com.flm.model.Item;
import com.flm.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public ItemResponseDTO saveItem(AddItemDTO addItemDTO) {
		
		Item item = new Item();
		
		BeanUtils.copyProperties(addItemDTO, item);
		
		Item savedItem = itemRepository.save(item);
		
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
		
		BeanUtils.copyProperties(savedItem,itemResponseDTO);
		
		return itemResponseDTO;
		
	}

	@Override
	public ItemResponseDTO getItemById(long itemId) {
		
		Item item = itemRepository.findById(itemId).orElseThrow(()->new ItemNotFoundException("Item not foud With Id : "+itemId));
		
		ItemResponseDTO irdto = new ItemResponseDTO();
		
		BeanUtils.copyProperties(item,irdto);
		
		return irdto;
		
	}

	@Override
	public List<ItemResponseDTO> getAllItems() {
		
		List<Item> list = itemRepository.findAll();
		
		List<ItemResponseDTO> itemResponseList = new ArrayList<ItemResponseDTO>();
		
		for(Item item:list)
		{
			ItemResponseDTO irdto = new ItemResponseDTO();
			BeanUtils.copyProperties(item,irdto);
			itemResponseList.add(irdto);
		}
		return itemResponseList;
		
	}

	@Override
	public ItemResponseDTO updateItem(UpdateItemDTO uitem) {
		
		Item itemm = new Item();
		
		BeanUtils.copyProperties(uitem, itemm);
		
		Item item1 = itemRepository.save(itemm);
		
		ItemResponseDTO item2 = new ItemResponseDTO();
		
		BeanUtils.copyProperties(item1, item2);
		
		return item2;
		
		
		
	}

	@Override
	public String deleteItem(long id) {
		
		Item item = new Item();
		
		item.setItemId(id);
		
		itemRepository.delete(item);
		
		String str = "Deleted Sucessfully";
		
		return str;
		
	}

	@Override
	public List<ItemResponseDTO> getItemsByNameStartingWith(String name) {
		
		List<Item> list = itemRepository.findByItemNameOrItemNameStartingWith(name, name);
		
		List<ItemResponseDTO> itemslist = new ArrayList<ItemResponseDTO>();
		
		for(Item item : list)
		{
			ItemResponseDTO irdto = new ItemResponseDTO();
			
			BeanUtils.copyProperties(item, irdto);
			
			itemslist.add(irdto);

		}
		
		return itemslist;
		
	}

	@Override
	public List<ItemResponseDTO> getItemByNameContaining(String name) {
		
		List<Item> item = itemRepository.findByItemNameContaining(name);
		
		List<ItemResponseDTO> list = new ArrayList<ItemResponseDTO>();
		
		for(Item i : item)
		{
			ItemResponseDTO irdto = new ItemResponseDTO();
			
			BeanUtils.copyProperties(i, irdto);
			
			list.add(irdto);
		}
		
		return list;
		
	}

	@Override
	public List<ItemResponseDTO> getItemByRatingGreaterThan(double rating) {
		 
		List<Item> item = itemRepository.findByRatingGreaterThan(rating);
		
		List<ItemResponseDTO> list = new ArrayList<ItemResponseDTO>();
		
		for(Item i : item)
		{
			ItemResponseDTO irdto = new ItemResponseDTO();
			
			BeanUtils.copyProperties(i, irdto);
			
			list.add(irdto);
		}
		
		return list;
		
		
		
	}

	@Override
	public List<ItemResponseDTO> getItemByPriceBetween(double price1, double price2) {
		
		List<Item> item = itemRepository.findByPriceBetween(price1, price2);
		
		List<ItemResponseDTO> list = new ArrayList<ItemResponseDTO>();
		
		for(Item i : item)
		{
			ItemResponseDTO irdto = new ItemResponseDTO();
			
			BeanUtils.copyProperties(i, irdto);
			
			list.add(irdto);
		}
		
		return list;
		
		
		
	}

	@Override
	public ItemResponseDTO updateRating(long itemId, double rating) {
		
		if(rating>5||rating<0)
		{
			throw new InvalidRatingException("Inavid Rating Input : "+rating+" Rating Should be in Range of 1 to 5");
		}
		
		itemRepository.updateRating(itemId, rating);
		
		Item item = itemRepository.findById(itemId).get();
		
		ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
		
		BeanUtils.copyProperties(item, itemResponseDTO);
		
		return itemResponseDTO;
		
	}
	
	

	

}
