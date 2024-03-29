package com.mresitcagan.blog.controller;

import com.mresitcagan.blog.dto.PostDto;
import com.mresitcagan.blog.mapper.Mapper;
import com.mresitcagan.blog.model.Post;
import com.mresitcagan.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final Mapper<Post, PostDto> mapper;

    public PostController(PostService postService, Mapper<Post, PostDto> mapper) {
        this.postService = postService;
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

    @PostMapping()
    public ResponseEntity<PostDto> createArticle(@RequestBody PostDto postDto){
        Post post = mapper.mapFrom(postDto);
        Post savedPostEntity = postService.save(post);
        return new ResponseEntity<>(mapper.mapTo(savedPostEntity), HttpStatus.CREATED);
    }
}
