package com.blogs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.User;


public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    
    Optional<User> findByUserID(Integer userID);
    
}
