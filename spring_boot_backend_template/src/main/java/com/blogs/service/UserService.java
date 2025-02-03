package com.blogs.service;

import com.blogs.pojos.User;

public interface UserService {
    User saveUser(User user);
    User getUserByEmail(String email);
    User updateUser(User user);
    void deleteUser(Integer id);
}
