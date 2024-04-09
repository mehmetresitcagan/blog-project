package com.mresitcagan.blog2.config;

import com.mresitcagan.blog2.dto.CreateUserRequest;
import com.mresitcagan.blog2.model.Post;
import com.mresitcagan.blog2.model.Role;
import com.mresitcagan.blog2.model.User;
import com.mresitcagan.blog2.service.PostService;
import com.mresitcagan.blog2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SeedData(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Set<Role> authorities = new HashSet<>();
        authorities.add(Role.ROLE_ADMIN);

        CreateUserRequest request = new CreateUserRequest("mehmet", "mresitcagan", "1234", authorities);

        User user = User.builder()
                .name(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .build();

        userService.createUser(request);
    }
}
