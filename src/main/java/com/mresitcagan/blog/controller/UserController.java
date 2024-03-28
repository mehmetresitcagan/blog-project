package com.mresitcagan.blog.controller;

import com.mresitcagan.blog.dto.ArticleDto;
import com.mresitcagan.blog.dto.UserDto;
import com.mresitcagan.blog.mapper.Mapper;
import com.mresitcagan.blog.model.Article;
import com.mresitcagan.blog.model.User;
import com.mresitcagan.blog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final Mapper<User, UserDto> mapper;

    public UserController(UserService userService, Mapper<User, UserDto> mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<UserDto> createArticle(@RequestBody UserDto userDto){
        User user = mapper.mapFrom(userDto);
        User savedUserEntity = userService.save(user);
        return new ResponseEntity<>(mapper.mapTo(savedUserEntity), HttpStatus.CREATED);
    }
}
