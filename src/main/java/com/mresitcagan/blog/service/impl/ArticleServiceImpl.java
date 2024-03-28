package com.mresitcagan.blog.service.impl;

import com.mresitcagan.blog.model.Article;
import com.mresitcagan.blog.repository.ArticleRepository;
import com.mresitcagan.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article save(Article article) {
        if (article.getId()==null){
            article.setCreatedAt(LocalDateTime.now());
        }
        return articleRepository.save(article);
    }

    @Override
    public Optional<Article> getById(Long id) {
        return articleRepository.findById(id);
    }
}
