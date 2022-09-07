package com.example.allinone.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private UserPost post;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserProfile user;

    private String comment;
}
