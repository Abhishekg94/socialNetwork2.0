package com.example.allinone.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class FriendShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "profile_request")
    private UserProfile friendRequest;

    @ManyToOne
    @JoinColumn(name = "profile_accept")
    private UserProfile friendAccept;

    private int status;
}
