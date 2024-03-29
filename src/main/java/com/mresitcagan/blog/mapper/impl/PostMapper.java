package com.mresitcagan.blog.mapper.impl;

import com.mresitcagan.blog.dto.PostDto;
import com.mresitcagan.blog.mapper.Mapper;
import com.mresitcagan.blog.model.Post;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PostMapper implements Mapper<Post, PostDto> {

    private ModelMapper modelMapper;

    public PostMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto mapTo(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public Post mapFrom(PostDto postDto) {
        return modelMapper.map(postDto, Post.class);
    }
}
