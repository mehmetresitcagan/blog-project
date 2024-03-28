package com.mresitcagan.blog.service;

import com.mresitcagan.blog.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    List<Article> getAll();

    Article save(Article article);

    Optional<Article> getById(Long id);
}
