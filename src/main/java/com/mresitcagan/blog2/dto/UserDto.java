package com.mresitcagan.blog2.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String username;
    private List<PostDto> articles;
}
