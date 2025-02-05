package com.blogs.service;

import com.blogs.dtos.MenuItemsWithMenuType;
import com.blogs.dtos.OrdersResponseDtos;
import com.blogs.pojos.MenuItems;
import com.blogs.pojos.Order;
import com.blogs.pojos.User;
import com.blogs.pojos.Vendor;

import java.util.List;

public interface VendorService {

    // Method to add a menu item with its menu type
    MenuItems addMenuItem(MenuItemsWithMenuType menuItemDto, int vendorId);
    
    // Method to get all menu items for a specific vendor
    List<MenuItems> getMenuItemsByVendorId(int vendorId);

	List<Vendor> getAllVendors(int roleId);
	
	List<Order>getAllOrders(int vendorId);
	
	Vendor getVendorById(int vendorId);

	User updateVendorProfile(Integer vendorId, User updatedVendor);
	
}
