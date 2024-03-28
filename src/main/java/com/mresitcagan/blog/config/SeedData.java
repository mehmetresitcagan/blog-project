package com.mresitcagan.blog.config;

import com.mresitcagan.blog.model.Article;
import com.mresitcagan.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private ArticleService articleService;

    @Override
    public void run(String... args) throws Exception{
        List<Article> articles = articleService.getAll();

        if (articles.isEmpty()){
            Article article1 = new Article();
            article1.setTitle("title article 1");
            article1.setBody("Content of article 1");

            Article article2 = new Article();
            article2.setTitle("title article 2");
            article2.setBody("Content of article 2");

            articleService.save(article1);
            articleService.save(article2);
        }
    }
}
