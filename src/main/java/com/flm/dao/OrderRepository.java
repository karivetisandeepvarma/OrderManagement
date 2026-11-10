package com.flm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flm.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	

}
