package com.mresitcagan.blog.controller;

import com.mresitcagan.blog.dto.ArticleDto;
import com.mresitcagan.blog.dto.UserDto;
import com.mresitcagan.blog.mapper.Mapper;
import com.mresitcagan.blog.model.Article;
import com.mresitcagan.blog.model.User;
import com.mresitcagan.blog.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final Mapper<Article, ArticleDto> mapper;

    public ArticleController(ArticleService articleService, Mapper<Article, ArticleDto> mapper) {
        this.articleService = articleService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return articles.stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto articleDto){
        Article article = mapper.mapFrom(articleDto);
        Article savedArticleEntity = articleService.save(article);
        return new ResponseEntity<>(mapper.mapTo(savedArticleEntity), HttpStatus.CREATED);
    }
}
