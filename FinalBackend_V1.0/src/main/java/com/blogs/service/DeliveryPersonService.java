package com.blogs.service;

import java.util.List;

import com.blogs.pojos.Customer;
import com.blogs.pojos.DeliveryPerson;
import com.blogs.pojos.Order;
import com.blogs.pojos.User;

public  interface DeliveryPersonService {
   
public List<Order> getOrdersForDeliveryPerson(int deliveryPersonId);
	
public Order updateOrderStatus(Integer orderId, String status);

User updateDeliveryPersonProfile(Integer vendorId, User updatedVendor);

 DeliveryPerson getDeliveryPersonById(int userId);

}
