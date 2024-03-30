package com.mresitcagan.blog.service;

import com.mresitcagan.blog.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getAll();

    Post save(Post post);

    Optional<Post> getById(Long id);

    void delete(Post post);
}
