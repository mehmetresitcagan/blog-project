package com.mresitcagan.blog.controller;

import com.mresitcagan.blog.dto.ArticleDto;
import com.mresitcagan.blog.mapper.Mapper;
import com.mresitcagan.blog.model.Article;
import com.mresitcagan.blog.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final Mapper<Article, ArticleDto> mapper;

    public ArticleController(ArticleService articleService, Mapper<Article, ArticleDto> mapper) {
        this.articleService = articleService;
        this.mapper = mapper;
    }
}
