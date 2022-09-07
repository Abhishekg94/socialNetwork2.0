package com.example.allinone.service.impl;

import com.example.allinone.dao.PostCommentDao;
import com.example.allinone.dao.UserPostsDao;
import com.example.allinone.dao.UserProfileDao;
import com.example.allinone.dao.model.PostComment;
import com.example.allinone.dao.model.UserPost;
import com.example.allinone.dao.model.UserProfile;
import com.example.allinone.service.CommentService;
import com.example.allinone.service.request.PostCommentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private PostCommentDao postCommentDao;

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    private UserPostsDao userPostsDao;

    @Override
    public void addComment(PostCommentRequestDto request) throws Exception {

        PostComment postComment = new PostComment();
        UserProfile user = userProfileDao.findById(request.getUserid()).orElseThrow(null);
        UserPost post = userPostsDao.findById(request.getPostId()).orElseThrow(null);
        if(user == null || post == null){
            throw new Exception("Invalid request.....");
        }
        postComment.setUser(user);
        postComment.setPost(post);
        postComment.setComment(request.getComment());
        postCommentDao.save(postComment);
    }

    @Override
    public List<PostComment> getCommentList(Integer pId) {

        List<PostComment> res = postCommentDao.findByPostId(pId);
        return res;
    }
}
