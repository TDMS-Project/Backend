package com.blogs.dao;

import com.blogs.pojos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
    // Custom queries can go here if needed
}
