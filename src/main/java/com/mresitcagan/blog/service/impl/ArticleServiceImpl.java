package com.mresitcagan.blog.service.impl;

import com.mresitcagan.blog.model.Article;
import com.mresitcagan.blog.repository.ArticleRepository;
import com.mresitcagan.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }
}
