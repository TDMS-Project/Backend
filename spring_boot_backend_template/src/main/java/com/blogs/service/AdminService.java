package com.blogs.service;


import java.util.List;

import com.blogs.pojos.Customer;
import com.blogs.pojos.DeliveryPerson;
import com.blogs.pojos.FeedBack;
import com.blogs.pojos.Order;
import com.blogs.pojos.User;
import com.blogs.pojos.Vendor;

public interface AdminService {

    // Method to add a vendor
    Vendor addVendor(Vendor vendor);

    // Method to add a delivery person
    DeliveryPerson addDeliveryPerson(DeliveryPerson dp);

	DeliveryPerson getDeliveryPersonById(int userId);

	Vendor getVendorById(int userId);

	String deleteVendorById(int userId);

	String deleteDeliveryPersonById(int userId);

	List<Vendor> getAllVendors(int userId);

	List<DeliveryPerson> getAllDeliveryPersons(int userId);

	User updateUser(Integer id, User admin);

	List<Order> getAllOrders();

	List<FeedBack> getFeedBacks();

	
     User getAdminById(Integer adminId);
	
	
}
