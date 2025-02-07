package com.blogs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.MenuItems;
import com.blogs.pojos.Vendor;

public interface MenuItemsDao extends JpaRepository<MenuItems,Integer> {
   List<MenuItems>findByMenuType_Vendor_userID(int vendorID);
   
   List<MenuItems> findByVendorUserID(int vendorId); // ✅ Query by vendor ID

   List<MenuItems> findByVendor(Vendor vendor);
   
}
