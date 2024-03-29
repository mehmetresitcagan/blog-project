package com.mresitcagan.blog.service.impl;

import com.mresitcagan.blog.model.Post;
import com.mresitcagan.blog.repository.PostRepository;
import com.mresitcagan.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        if (post.getId()==null){
            post.setCreatedAt(LocalDateTime.now());
        }
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }
}
