package com.example.allinone.service.impl;

import com.example.allinone.dao.UserPostsDao;
import com.example.allinone.dao.UserProfileDao;
import com.example.allinone.dao.model.UserPost;
import com.example.allinone.dao.model.UserProfile;
import com.example.allinone.service.PostService;
import com.example.allinone.service.request.PostRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    private UserPostsDao userPostsDao;

    @Override
    public void createPost(PostRequestDto postRequest) throws Exception {

        UserPost userPost = new UserPost();
        UserProfile user = userProfileDao.findById(postRequest.getUserId()).orElseThrow(null);
        if(user == null){
            throw new Exception("user not found");
        }
        userPost.setUser(user);
        userPost.setWriteText(postRequest.getWriteText());
        userPost.setMediaPath(postRequest.getMediaPath());
        userPost.setCreatedAt(new Date());
        userPostsDao.save(userPost);
    }

    @Override
    public List<UserPost> getPostList(Integer userid) {

        List<UserPost> res = userPostsDao.findByUserId(userid);
        return res;
    }
}
