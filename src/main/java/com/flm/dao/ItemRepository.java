package com.flm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flm.dto.ItemResponseDTO;
import com.flm.model.Item;

import jakarta.transaction.Transactional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	
	public List<Item> findByItemNameOrItemNameStartingWith(String exactName, String startingName);

	public List<Item> findByItemNameContaining(String containsName);
	
	public List<Item> findByRatingGreaterThan(double rating);
	
	public List<Item> findByPriceBetween(double price1,double price2);
	
	@Query("update Item set rating= :rating where itemId= :itemId")
	@Modifying
	@Transactional
	public void updateRating(long itemId,double rating);
}
