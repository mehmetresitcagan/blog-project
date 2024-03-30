package com.mresitcagan.blog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Authority implements Serializable {

    @Id
    @Column(length = 16)
    String name;

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + '\'' +
                '}';
    }
}
