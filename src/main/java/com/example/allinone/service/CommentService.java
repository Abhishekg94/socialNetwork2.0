package com.example.allinone.service;

import com.example.allinone.dao.model.PostComment;
import com.example.allinone.service.request.PostCommentRequestDto;

import java.util.List;

public interface CommentService {
    void addComment(PostCommentRequestDto request) throws Exception;

    List<PostComment> getCommentList(Integer cId);
}
