package com.mresitcagan.blog2.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String body;
    private Date createdAt;
}
