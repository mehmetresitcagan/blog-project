package com.mresitcagan.blog.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String body;
    private Date createdAt;
}
