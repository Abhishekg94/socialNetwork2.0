package com.example.allinone.service.impl;

import com.example.allinone.dao.PostLikeDao;
import com.example.allinone.dao.UserPostsDao;
import com.example.allinone.dao.UserProfileDao;
import com.example.allinone.dao.model.PostLike;
import com.example.allinone.dao.model.UserPost;
import com.example.allinone.dao.model.UserProfile;
import com.example.allinone.service.LikeService;
import com.example.allinone.service.request.LikeRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    private UserPostsDao userPostsDao;

    @Autowired
    private PostLikeDao postLikeDao;

    @Override
    public void addLike(LikeRequestDto likeRequest) throws Exception {

        PostLike postLike = new PostLike();
        UserProfile user = userProfileDao.findById(likeRequest.getUserId()).orElseThrow(null);
        UserPost userPost = userPostsDao.findById(likeRequest.getPostId()).orElseThrow(null);
        if(user == null || userPost == null){
            throw new Exception("user not found");
        }
        postLike.setUser(user);
        postLike.setPost(userPost);
        postLikeDao.save(postLike);
    }
}
