package com.mresitcagan.blog2.mapper.impl;

import com.mresitcagan.blog2.dto.PostDto;
import com.mresitcagan.blog2.mapper.Mapper;
import com.mresitcagan.blog2.model.Post;
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
