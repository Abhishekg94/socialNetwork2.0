package com.example.allinone.service;

import com.example.allinone.dao.model.UserPost;
import com.example.allinone.service.request.PostRequestDto;

import java.util.List;

public interface PostService {
    void createPost(PostRequestDto postRequest) throws Exception;

    List<UserPost> getPostList(Integer userid);
}
