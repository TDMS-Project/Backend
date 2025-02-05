package com.blogs.controller;

import com.blogs.pojos.Customer;
import com.blogs.pojos.DeliveryPerson;
import com.blogs.pojos.FeedBack;
import com.blogs.pojos.Order;
import com.blogs.pojos.User;
import com.blogs.pojos.Vendor;
import com.blogs.service.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

   
   
    @PostMapping("/add-vendor")
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return adminService.addVendor(vendor);
    }
   
    
    @PostMapping("/add-delivery-person")
    public DeliveryPerson addDeliveryPerson(@RequestBody DeliveryPerson deliveryPerson) {
        return adminService.addDeliveryPerson(deliveryPerson);
    }
    
    @GetMapping("/delivery/{userId}")
    public ResponseEntity<DeliveryPerson> getDeliveryPerson(@PathVariable int userId) {
        DeliveryPerson dp = adminService.getDeliveryPersonById(userId);
        if (dp != null) {
            return new ResponseEntity<>(dp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/vendor/{userId}")
    public ResponseEntity<Vendor> getVendor(@PathVariable int userId) {
        Vendor v = adminService.getVendorById(userId);
        if (v != null) {
            return new ResponseEntity<>(v, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/vendor/{userId}")
    public String deleteVendor(@PathVariable int userId) {
		return adminService.deleteVendorById(userId);
    	
    }
    @DeleteMapping("/delivery/{userId}")
    public String deleteDeliveryPerson(@PathVariable int userId) {
		return adminService.deleteDeliveryPersonById(userId);
    }
    
    @GetMapping("/vendorList/{roleId}")
    public List<Vendor> getVendorList(@PathVariable int roleId){
		return adminService.getAllVendors(roleId);
    	
    }
    
    @GetMapping("/deliveryPersonList/{roleId}")
    public List<DeliveryPerson> getDeliveryPersonList(@PathVariable int roleId){
		return adminService.getAllDeliveryPersons(roleId);
    	
    }
    
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateAdmin(@PathVariable Integer id, @RequestBody User admin) {
//        User updatedAdmin = adminService.updateUser(id, admin);
//        return ResponseEntity.ok(updatedAdmin);
//    }
    
    @PutMapping("/update-profile")
    public ResponseEntity<User> updateUser(@RequestBody User updatedAdmin) {
        Integer adminId = 2; // The admin userID
        User updatedUser = adminService.updateUser(adminId, updatedAdmin);
        return ResponseEntity.ok(updatedUser);
    }
    
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return adminService.getAllOrders();
    }
    
    @GetMapping("/feedBack")
    public List<FeedBack> getAllFeedBack(){
		return adminService.getFeedBacks();
    	
    }
    
    @GetMapping
    public User getProfile() {
		return adminService.getAdminById(2);
    	
    }
    
    
}
