package com.example.allinone.service;

import com.example.allinone.dao.model.UserProfile;
import com.example.allinone.service.request.FriendRequestDto;

import java.util.List;

public interface FriendShipService {
    void addFriend(FriendRequestDto friendRequest) throws Exception;

    List<UserProfile> getFriendList(Integer userId) throws Exception;
}
