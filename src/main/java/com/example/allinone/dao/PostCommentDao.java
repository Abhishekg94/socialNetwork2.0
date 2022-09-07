package com.example.allinone.dao;

import com.example.allinone.dao.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostCommentDao extends JpaRepository<PostComment, Integer> {

    @Query("select q from PostComment q where q.post.id =:pId")
    List<PostComment> findByPostId(@Param("pId") Integer pId);
}
