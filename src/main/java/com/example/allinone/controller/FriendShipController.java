package com.example.allinone.controller;

import com.example.allinone.dao.model.UserProfile;
import com.example.allinone.service.FriendShipService;
import com.example.allinone.service.request.FriendRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;
import java.util.List;

@Controller
public class FriendShipController {

    @Autowired
    private FriendShipService friendShipService;

    @PostMapping("/friend/add")
    ResponseEntity<String> addFriend(@RequestBody FriendRequestDto friendRequest) throws Exception {

        friendShipService.addFriend(friendRequest);

       return ResponseEntity.ok("success");
    }

    @GetMapping("/friend/list/{id}")
    ResponseEntity getFriendList(@PathVariable("id") Integer userId) throws Exception {

        List<UserProfile> res = friendShipService.getFriendList(userId);
        return ResponseEntity.ok(res);
    }
}
