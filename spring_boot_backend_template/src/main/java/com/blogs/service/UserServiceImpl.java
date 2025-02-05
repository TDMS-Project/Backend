package com.blogs.service;

import com.blogs.dao.RoleDao;
import com.blogs.dao.UserDao;
import com.blogs.dtos.AuthDto;
import com.blogs.pojos.User;
import com.blogs.pojos.Role;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private RoleDao roleRepository;

    // Method to save a user, ensuring a "Customer" role is added if not already set
    public User saveUser(User user) {
        if (user.getRole() == null) {
            // Assign default role or retrieve it from the database
            Role defaultRole = roleRepository.findByRoleName("Customer");
            user.setRole(defaultRole); // Assign a role to the user
        }
        return userRepository.save(user);
    }


   
    @Override
    public User authenticateUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        User user = userOptional.get();

        // Check password (plain text comparison)
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password!");
        }

        return user;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
