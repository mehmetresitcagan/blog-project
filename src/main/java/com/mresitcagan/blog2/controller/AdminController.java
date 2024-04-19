package com.mresitcagan.blog2.controller;

import com.mresitcagan.blog2.dto.CreateUserRequest;
import com.mresitcagan.blog2.model.User;
import com.mresitcagan.blog2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/addNewUser")
    public User addUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/admin")
    public String getAdminString() {
        return "This is ADMIN!";
    }
}
