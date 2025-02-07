package com.blogs.service;

import com.blogs.dtos.AuthDto;
import com.blogs.pojos.User;

public interface UserService {
    User saveUser(User user);
    User authenticateUser(String email, String password);
    User updateUser(User user);
    void deleteUser(Integer id);
}
