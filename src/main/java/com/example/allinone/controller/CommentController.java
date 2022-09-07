package com.example.allinone.controller;

import com.example.allinone.dao.model.PostComment;
import com.example.allinone.service.CommentService;
import com.example.allinone.service.request.PostCommentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/add")
    ResponseEntity<String> addComment(@RequestBody PostCommentRequestDto request) throws Exception {

        commentService.addComment(request);

        return ResponseEntity.ok("success");
    }

    @GetMapping("/comment/list/{pId}")
    ResponseEntity getCommentList(@PathVariable("pId") Integer pId){

        List<PostComment> res = commentService.getCommentList(pId);

        return ResponseEntity.ok(res);
    }
}
