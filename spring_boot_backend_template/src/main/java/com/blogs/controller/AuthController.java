package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dtos.AuthDto;
import com.blogs.pojos.Customer;
import com.blogs.pojos.User;
import com.blogs.service.CustomerService;
import com.blogs.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;  // Use userService for authentication
    @Autowired
    CustomerService customerService;

    // Allow cross-origin requests from your React frontend (adjust URL as needed)
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
        try {
            // Authenticate the user by email and password
            User authenticatedUser = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

            if (authenticatedUser != null) {
                // Return the authenticated user with role and other details
                return ResponseEntity.ok(authenticatedUser);
            } else {
                // If no user is found or invalid credentials
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        } catch (Exception e) {
            // Handle any unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")  // Allow cross-origin for Register endpoint as well
    @PostMapping("/Register")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        try {
            // Register a new customer
            Customer createdCustomer = customerService.addCustomer(customer);

            if (createdCustomer != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating customer");
            }
        } catch (Exception e) {
            // Handle any errors during registration
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
