package com.mresitcagan.blog.controller;

import com.mresitcagan.blog.dto.ArticleDto;
import com.mresitcagan.blog.dto.UserDto;
import com.mresitcagan.blog.mapper.Mapper;
import com.mresitcagan.blog.model.Article;
import com.mresitcagan.blog.model.User;
import com.mresitcagan.blog.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final Mapper<User, UserDto> mapper;

    public UserController(UserService userService, Mapper<User, UserDto> mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

}
