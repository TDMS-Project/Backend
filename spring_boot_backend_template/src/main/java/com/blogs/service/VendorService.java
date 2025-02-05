package com.blogs.service;

import com.blogs.dtos.MenuItemsWithMenuType;
import com.blogs.pojos.MenuItems;
import com.blogs.pojos.Vendor;

import java.util.List;

public interface VendorService {

    // Method to add a menu item with its menu type
    MenuItems addMenuItem(MenuItemsWithMenuType menuItemDto, int vendorId);

    // Method to get all menu items for a specific vendor
    List<MenuItems> getMenuItemsByVendorId(int vendorId);

	List<Vendor> getAllVendors(int roleId);
}
