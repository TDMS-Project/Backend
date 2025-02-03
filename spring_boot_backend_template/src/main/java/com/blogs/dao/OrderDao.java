package com.blogs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.Order;


public interface OrderDao extends JpaRepository<Order,Integer> {

	 List<Order> findByUserUserID(int userId);
	
}
