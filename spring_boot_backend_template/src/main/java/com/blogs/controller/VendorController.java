package com.blogs.controller;

import com.blogs.dtos.MenuItemsWithMenuType;
import com.blogs.dtos.OrdersResponseDtos;
import com.blogs.pojos.Customer;
import com.blogs.pojos.MenuItems;
import com.blogs.pojos.Order;
import com.blogs.pojos.User;
import com.blogs.pojos.Vendor;
import com.blogs.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    // ✅ Add a new menu item for a vendor
    @PostMapping("/{vendorId}/menu-items")
    public ResponseEntity<MenuItems> addMenuItem(
            @PathVariable int vendorId,
            @RequestBody MenuItemsWithMenuType menuItemDto) {
        MenuItems menuItem = vendorService.addMenuItem(menuItemDto, vendorId);
        return ResponseEntity.ok(menuItem);
      }

    // ✅ Get all menu items by vendor ID
    @GetMapping("/{vendorId}/menu-items")
    public ResponseEntity<List<MenuItems>> getMenuItemsByVendorId(@PathVariable int vendorId) {
        List<MenuItems> menuItems = vendorService.getMenuItemsByVendorId(vendorId);
        return ResponseEntity.ok(menuItems);
    }
    
    @GetMapping("/vendor/{vendorID}")
    public List<Order> getOrdersForVendor(@PathVariable int vendorID) {
        return vendorService.getAllOrders(vendorID);
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<Vendor> getCustomer(@PathVariable int userId) {
        Vendor vendor = vendorService.getVendorById(userId);
        if (vendor != null) {
            return new ResponseEntity<>(vendor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/update-profile/{vendorId}")
    public ResponseEntity<User> updateCustomerProfile(@PathVariable Integer customerId, @RequestBody User updatedCustomer) {
        User updatedUser = vendorService.updateVendorProfile(customerId, updatedCustomer);
        return ResponseEntity.ok(updatedUser);
    }
    
}
