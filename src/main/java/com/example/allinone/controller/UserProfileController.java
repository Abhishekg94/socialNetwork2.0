package com.example.allinone.controller;

import com.example.allinone.service.UserProfileService;
import com.example.allinone.service.request.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;


    @PostMapping("/user/add")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto userRequest){

        userProfileService.addUser(userRequest);

        return ResponseEntity.ok("success");
    }
}

