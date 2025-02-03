package com.blogs.service;

import java.util.List;

import com.blogs.pojos.Customer;
import com.blogs.pojos.FeedBack;
import com.blogs.pojos.MenuItems;
import com.blogs.pojos.Order;
import com.blogs.pojos.OrderItems;
import com.blogs.pojos.User;

public interface CustomerService {
    // Add new customer
    Customer addCustomer(Customer customer);

    // Get customer by id
    Customer getCustomerById(int userId);

	String deleteCustomerById(int userId);
	
	List<MenuItems> getMenuItemsByVendorID(int vendorID);

	List<MenuItems> getMenuItemsByVendorId(int vendorId);

	User updateCustomerProfile(Integer customerId, User updatedCustomer);

	Order placeOrder(int userId, int vendorId, List<OrderItems> items);
	
	List<Order> getOrdersForCustomer(int userID);
	
	String addFeedBack(FeedBack feedback);
	
	
}
