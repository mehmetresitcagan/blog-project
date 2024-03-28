package com.mresitcagan.blog.service;

import com.mresitcagan.blog.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();

    Article save(Article article);
}
