package com.mresitcagan.blog.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountDto {
    private Long id;
    private String username;
    private String email;
    private List<PostDto> articles;
}
