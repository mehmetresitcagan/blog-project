package com.mresitcagan.blog.controller;

import com.mresitcagan.blog.dto.PostDto;
import com.mresitcagan.blog.mapper.Mapper;
import com.mresitcagan.blog.model.Account;
import com.mresitcagan.blog.model.Post;
import com.mresitcagan.blog.service.AccountService;
import com.mresitcagan.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    private final AccountService accountService;

    private final Mapper<Post, PostDto> mapper;

    public PostController(PostService postService, AccountService accountService, Mapper<Post, PostDto> mapper) {
        this.postService = postService;
        this.accountService = accountService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        List<Post> posts = postService.getAll();
        return posts.stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Optional<Post> optional = postService.getById(id);
        if (optional.isPresent()){
            Post post = optional.get();
            model.addAttribute("post", post);
            return "post";
        }
        return "404";
    }


    @GetMapping("/new")
    public String createNewPost(Model model){
        Optional<Account> optionalAccount = accountService.findByEmail("mresitcagan@gmail.com");
        if (optionalAccount.isPresent()){
            Post post = new Post();
            post.setAccount(optionalAccount.get());
            model.addAttribute("post", post);
            return "post_new";
        } else {
            return "404";
        }
    }

    @PostMapping("/new")
    public String saveNewPost(@ModelAttribute Post post){
        postService.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/{id}/edit")
    @PreAuthorize("isAuthenticated()")
    public String getPostForEdit(@PathVariable Long id, Model model) {

        // find post by id
        Optional<Post> optionalPost = postService.getById(id);
        // if post exist put it in model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post_edit";
        } else {
            return "404";
        }
    }

    @PostMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public String updatePost(@PathVariable Long id, Post post, BindingResult result, Model model) {

        Optional<Post> optionalPost = postService.getById(id);
        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();

            existingPost.setTitle(post.getTitle());
            existingPost.setBody(post.getBody());

            postService.save(existingPost);
        }

        return "redirect:/posts/" + post.getId();
    }

}
