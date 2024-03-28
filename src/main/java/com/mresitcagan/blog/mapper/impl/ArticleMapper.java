package com.mresitcagan.blog.mapper.impl;

import com.mresitcagan.blog.dto.ArticleDto;
import com.mresitcagan.blog.mapper.Mapper;
import com.mresitcagan.blog.model.Article;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper implements Mapper<Article, ArticleDto> {

    private ModelMapper modelMapper;

    public ArticleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ArticleDto mapTo(Article article) {
        return modelMapper.map(article, ArticleDto.class);
    }

    @Override
    public Article mapFrom(ArticleDto articleDto) {
        return modelMapper.map(articleDto, Article.class);
    }
}
