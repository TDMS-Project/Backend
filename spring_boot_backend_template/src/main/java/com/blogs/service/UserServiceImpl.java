package com.blogs.service;

import com.blogs.dao.RoleDao;
import com.blogs.dao.UserDao;
import com.blogs.pojos.User;
import com.blogs.pojos.Role;
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


   
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
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
