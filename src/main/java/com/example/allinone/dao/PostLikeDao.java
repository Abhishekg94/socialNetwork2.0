package com.example.allinone.dao;

import com.example.allinone.dao.model.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeDao extends JpaRepository<PostLike, Integer> {
}
