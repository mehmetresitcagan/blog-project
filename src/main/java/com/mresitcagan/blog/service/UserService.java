package com.mresitcagan.blog.service;

import com.mresitcagan.blog.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User save(User user);
}
