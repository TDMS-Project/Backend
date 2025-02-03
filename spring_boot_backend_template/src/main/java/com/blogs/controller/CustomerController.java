package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.pojos.Customer;
import com.blogs.pojos.FeedBack;
import com.blogs.pojos.MenuItems;
import com.blogs.pojos.Order;
import com.blogs.pojos.OrderItems;
import com.blogs.pojos.User;
import com.blogs.service.CustomerService;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
   
    // Add new customer
    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    // Get customer by ID
    @GetMapping("/{userId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int userId) {
        Customer customer = customerService.getCustomerById(userId);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping({"/userId"})
    public String deleteCustomer(@PathVariable int userId) {
    	
		return customerService.deleteCustomerById(userId); 
    	
    }
   
//    @GetMapping("/vendor/{vendorId}")
//    public List<MenuItems> getMenuItemsByVendor(@PathVariable int vendorId) {
//        return customerService.getMenuItemsByVendorId(vendorId); // ✅ Fetch menu items based on vendor ID
//    }
    
    @PutMapping("/update-profile/{customerId}")
    public ResponseEntity<User> updateCustomerProfile(@PathVariable Integer customerId, @RequestBody User updatedCustomer) {
        User updatedUser = customerService.updateCustomerProfile(customerId, updatedCustomer);
        return ResponseEntity.ok(updatedUser);
    }
    
    @PostMapping("/place/{userId}/{vendorId}")
    public ResponseEntity<Order> placeOrder(
            @PathVariable int userId,
            @PathVariable int vendorId,
            @RequestBody List<OrderItems> items) {
        
        Order newOrder = customerService.placeOrder(userId, vendorId, items);
        return ResponseEntity.ok(newOrder);
    }
    
    @GetMapping("/orders/{userID}")
    public List<Order> getOrdersForCustomer(@PathVariable int userID) {
        return customerService.getOrdersForCustomer(userID);
    }
    
    @PostMapping("/feedBack")
    public String addFeedBack(@RequestBody FeedBack feedback) {
    	return customerService.addFeedBack(feedback);
    }
}
