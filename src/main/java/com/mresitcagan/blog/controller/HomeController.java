package com.mresitcagan.blog.controller;

import com.mresitcagan.blog.model.Article;
import com.mresitcagan.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String home(Model model) {
        List<Article> posts = articleService.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }
}
