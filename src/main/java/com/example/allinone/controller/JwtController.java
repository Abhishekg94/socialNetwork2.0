package com.example.allinone.controller;

import com.example.allinone.service.request.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest request){

       return ResponseEntity.ok("success");
    }
}
