package com.mresitcagan.blog.service.impl;

import com.mresitcagan.blog.repository.UserRepository;
import com.mresitcagan.blog.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
