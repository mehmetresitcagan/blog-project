package com.mresitcagan.blog2.service;

import com.mresitcagan.blog2.model.Post;
import com.mresitcagan.blog2.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        if (post.getId()==null){
            post.setCreatedAt(LocalDateTime.now());
        }
        post.setUpdatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }
}
