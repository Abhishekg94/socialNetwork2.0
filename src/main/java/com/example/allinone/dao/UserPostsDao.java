package com.example.allinone.dao;

import com.example.allinone.dao.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserPostsDao extends JpaRepository<UserPost, Integer> {

    @Query("select q from UserPost q where q.user.id =:userId")
    List<UserPost> findByUserId(@Param("userId") Integer userId);
}
