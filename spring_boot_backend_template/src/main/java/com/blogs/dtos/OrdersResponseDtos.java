package com.blogs.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdersResponseDtos {
    private int orderId;
    private String orderStatus;
    private LocalDateTime orderDate;
    private String customerFirstName;
    private String customerLastName;
}

