package com.mresitcagan.blog2.mapper;

public interface Mapper<A,B> {

    B mapTo(A a);

    A mapFrom(B b);
}
