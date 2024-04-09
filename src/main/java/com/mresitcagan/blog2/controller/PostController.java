package com.mresitcagan.blog2.controller;

import com.mresitcagan.blog2.dto.CreateUserRequest;
import com.mresitcagan.blog2.dto.PostDto;
import com.mresitcagan.blog2.mapper.Mapper;
import com.mresitcagan.blog2.model.Post;
import com.mresitcagan.blog2.model.User;
import com.mresitcagan.blog2.service.PostService;
import com.mresitcagan.blog2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
@Slf4j
public class PostController {

    private final PostService postService;

    private final UserService userService;


    private final Mapper<Post, PostDto> mapper;


    public PostController(PostService postService, UserService userService, Mapper<Post, PostDto> mapper) {
        this.postService = postService;
        this.userService = userService;
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
    public String getPost(@PathVariable Long id){
        Optional<Post> optional = postService.getById(id);
        if (optional.isPresent()){
            Post post = optional.get();
            return post.toString();
        }
        return "Post bulunamadı";
    }

    @PostMapping()
    public String saveNewPost(@RequestBody Post post) {
        Post saved = postService.save(post);
        return saved.toString();
    }





//
//    @GetMapping("/{id}/edit")
//    @PreAuthorize("isAuthenticated()")
//    public String getPostForEdit(@PathVariable Long id, Model model) {
//
//        // find post by id
//        Optional<Post> optionalPost = postService.getById(id);
//        // if post exist put it in model
//        if (optionalPost.isPresent()) {
//            Post post = optionalPost.get();
//            model.addAttribute("post", post);
//            return "post_edit";
//        } else {
//            return "404";
//        }
//    }
//
//    @PostMapping("/{id}")
//    @PreAuthorize("isAuthenticated()")
//    public String updatePost(@PathVariable Long id, Post post, BindingResult result, Model model) {
//
//        Optional<Post> optionalPost = postService.getById(id);
//        if (optionalPost.isPresent()) {
//            Post existingPost = optionalPost.get();
//
//            existingPost.setTitle(post.getTitle());
//            existingPost.setBody(post.getBody());
//
//            postService.save(existingPost);
//        }
//
//        return "redirect:/posts/" + post.getId();
//    }
//
//    @GetMapping("/{id}/delete")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String deletePost(@PathVariable Long id) {
//
//        Optional<Post> optionalPost = postService.getById(id);
//        if (optionalPost.isPresent()) {
//            Post post = optionalPost.get();
//
//            postService.delete(post);
//            return "redirect:/";
//        } else {
//            return "404";
//        }
//    }

}
