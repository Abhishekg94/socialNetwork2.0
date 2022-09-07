package com.example.allinone.dao;

import com.example.allinone.dao.model.FriendShip;
import com.example.allinone.dao.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendShipDao extends JpaRepository<FriendShip, Integer> {

    @Query("select q from FriendShip q where q.friendRequest.id = :userId")
    List<FriendShip> findByFriendRequest(@Param("userId") Integer userId);
}
