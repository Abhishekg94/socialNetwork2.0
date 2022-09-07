package com.example.allinone.controller;

import com.example.allinone.dao.model.UserPost;
import com.example.allinone.service.PostService;
import com.example.allinone.service.request.PostRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("post/create")
    ResponseEntity createPost(@RequestBody PostRequestDto postRequest) throws Exception {

        postService.createPost(postRequest);

       return ResponseEntity.ok("sucess");
    }

    @GetMapping("/post/list/{userId}")
    ResponseEntity getPostList(@PathVariable("userId") Integer userid){

        List<UserPost> res = postService.getPostList(userid);

        return ResponseEntity.ok(res);
    }


}
