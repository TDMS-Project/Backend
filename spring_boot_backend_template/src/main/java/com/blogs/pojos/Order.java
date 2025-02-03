package com.blogs.pojos;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    private LocalDateTime orderDate; // Changed from String to LocalDateTime
    private String orderStatus; // Example: "PENDING", "CONFIRMED", "DELIVERED"

    @ManyToOne
    @JoinColumn(name = "vendor_ID", nullable = false)
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "user_ID", nullable = false)
    private User user; // Customer placing the order

    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItems> orderItems;
}
