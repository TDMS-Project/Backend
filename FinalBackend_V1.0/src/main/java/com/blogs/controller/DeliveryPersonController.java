package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.pojos.Customer;
import com.blogs.pojos.DeliveryPerson;
import com.blogs.pojos.Order;
import com.blogs.pojos.User;
import com.blogs.service.DeliveryPersonService;

@RestController
@RequestMapping("/Delivery")
public class DeliveryPersonController {
     
	@Autowired
	 private DeliveryPersonService service;
	
	@GetMapping("/deliveryPerson/{deliveryPersonId}")
    public List<Order> getOrdersForDeliveryPerson(@PathVariable int deliveryPersonId) {
        return service.getOrdersForDeliveryPerson(deliveryPersonId);
       }
	
	    @PutMapping("/updateStatus/{orderId}")
	    public ResponseEntity<Order> updateOrderStatus(
	            @PathVariable Integer orderId, 
	            @RequestParam String status) {
	        
	    Order updatedOrder = service.updateOrderStatus(orderId, status);
	    return ResponseEntity.ok(updatedOrder);
	    }
	    @PutMapping("/update-profile/{vendorId}")
	    public ResponseEntity<User> updateCustomerProfile(@PathVariable Integer vendorId, @RequestBody User updatedDeliveryPerson) {
	        User updatedUser = service.updateDeliveryPersonProfile(vendorId, updatedDeliveryPerson);
	        return ResponseEntity.ok(updatedUser);
	    }
	    
	    @GetMapping("/{userId}")
	    public ResponseEntity<DeliveryPerson> getDeliveryPerson(@PathVariable int userId) {
	       DeliveryPerson customer = service.getDeliveryPersonById(userId);
	        if (customer != null) {
	            return new ResponseEntity<>(customer, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	
	
}
