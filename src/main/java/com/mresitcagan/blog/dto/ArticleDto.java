package com.mresitcagan.blog.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private Long userId;
}
