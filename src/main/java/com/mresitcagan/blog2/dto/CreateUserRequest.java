package com.mresitcagan.blog2.dto;

import com.mresitcagan.blog2.model.Role;
import lombok.Builder;

import java.util.Set;


@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
){
}
