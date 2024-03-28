package com.mresitcagan.blog.mapper;

public interface Mapper<A,B> {

    B mapTo(A a);

    A mapFrom(B b);
}
