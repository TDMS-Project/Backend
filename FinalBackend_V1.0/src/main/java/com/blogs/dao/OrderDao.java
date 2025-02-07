package com.blogs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blogs.dtos.OrdersResponseDtos;
import com.blogs.pojos.Order;


public interface OrderDao extends JpaRepository<Order,Integer> {

	 List<Order> findByUserUserID(int userId);
	
	 List<Order> findByVendorUserID(int vendorID);
     
	 List<Order> findByDeliveryPersonUserID(int deliveryPersonId);
     
}
