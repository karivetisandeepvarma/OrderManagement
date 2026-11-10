package com.flm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flm.dto.AddItemDTO;
import com.flm.dto.ItemResponseDTO;
import com.flm.dto.UpdateItemDTO;
import com.flm.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping("/add")
	public ResponseEntity<ItemResponseDTO> saveItem(@RequestBody AddItemDTO addItemDTO)
	{
		ItemResponseDTO item = itemService.saveItem(addItemDTO);
		
		return new ResponseEntity<>(item,HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{itemId}")
	public ResponseEntity<ItemResponseDTO> getItemById(@PathVariable long itemId)
	{
		 ItemResponseDTO itemById = itemService.getItemById(itemId);
		 
		 return new ResponseEntity<ItemResponseDTO>(itemById,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ItemResponseDTO>> getAllItems()
	{
		List<ItemResponseDTO> allItems = itemService.getAllItems();
		return new ResponseEntity<List<ItemResponseDTO>>(allItems,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ItemResponseDTO> update(@RequestBody UpdateItemDTO item)
	{
		ItemResponseDTO updateItem = itemService.updateItem(item);
		
		return new ResponseEntity<ItemResponseDTO>(updateItem,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable long id)
	{
		String string = itemService.deleteItem(id);
		
		return new ResponseEntity<String>(string,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/findbynamestartswith/{name}")
	public ResponseEntity<List<ItemResponseDTO>> getItemsByNameStartingWith(@PathVariable String name)
	{
		List<ItemResponseDTO> itemsByNameStartingWith = itemService.getItemsByNameStartingWith(name);
		
		return new ResponseEntity<List<ItemResponseDTO>>(itemsByNameStartingWith,HttpStatus.OK);
	}
	
	@GetMapping("/findbynamecontaining/{name}")
	public ResponseEntity<List<ItemResponseDTO>> getItemByNameContaining(@PathVariable String name)
	{
		List<ItemResponseDTO> itemByNameContaining = itemService.getItemByNameContaining(name);
		
		return new ResponseEntity<List<ItemResponseDTO>>(itemByNameContaining,HttpStatus.OK);
	}
	
	@GetMapping("/findbyratinggreaterthan/{rating}")
	public ResponseEntity<List<ItemResponseDTO>> getItemByRatingGreaterThan(@PathVariable double rating)
	{
		List<ItemResponseDTO> itemByRatingGreaterThan = itemService.getItemByRatingGreaterThan(rating);
		
		return new ResponseEntity<List<ItemResponseDTO>>(itemByRatingGreaterThan,HttpStatus.OK);
	}
	
	@GetMapping("/findbypricebetween/{price1}/{price2}")
	public ResponseEntity<List<ItemResponseDTO>> getItemByPriceBetween(@PathVariable double price1,@PathVariable double price2)
	{
		
		List<ItemResponseDTO> itemByPriceBetween = itemService.getItemByPriceBetween(price1,price2);
		
		return new ResponseEntity<List<ItemResponseDTO>>(itemByPriceBetween,HttpStatus.OK);
		
	}
	
	@PutMapping("/updaterating")
	public ResponseEntity<ItemResponseDTO> updateRating(@RequestParam(name="itemId") long itemId, @RequestParam(name="rating") double rating)
	{
		ItemResponseDTO itemResponseDTO = itemService.updateRating(itemId,rating);
		
		return new ResponseEntity<ItemResponseDTO>(itemResponseDTO,HttpStatus.OK);
	}

}
