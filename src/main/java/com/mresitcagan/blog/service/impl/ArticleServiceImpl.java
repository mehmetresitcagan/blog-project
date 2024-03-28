package com.mresitcagan.blog.service.impl;

import com.mresitcagan.blog.repository.ArticleRepository;
import com.mresitcagan.blog.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
}
