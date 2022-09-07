package com.example.allinone.service.impl;

import com.example.allinone.dao.FriendShipDao;
import com.example.allinone.dao.UserProfileDao;
import com.example.allinone.dao.model.FriendShip;
import com.example.allinone.dao.model.UserProfile;
import com.example.allinone.service.FriendShipService;
import com.example.allinone.service.request.FriendRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendShipServiceImpl implements FriendShipService {

    @Autowired
    private FriendShipDao friendShipDao;

    @Autowired
    private UserProfileDao userProfileDao;
    @Override
    public void addFriend(FriendRequestDto friendRequest) throws Exception {

        FriendShip friendShip = new FriendShip();
       UserProfile requestUser = userProfileDao.findById(friendRequest.getFriendRequest()).orElseThrow(null);
       UserProfile acceptUser = userProfileDao.findById(friendRequest.getFriendAccept()).orElseThrow(null);
       if(requestUser == null || acceptUser == null){
           throw new Exception("user not found");
       }
       friendShip.setFriendRequest(requestUser);
       friendShip.setFriendAccept(acceptUser);
       friendShipDao.save(friendShip);
    }

    @Override
    public List<UserProfile> getFriendList(Integer userId) throws Exception {
        if(userId == null || userId <=0){
            throw new Exception("Invalid user");
        }
        List<FriendShip> res = friendShipDao.findByFriendRequest(userId);
        if(res == null || res.size() == 0){
            throw new Exception("no friends found");
        }
        List<UserProfile> result = new ArrayList<>();
        for(FriendShip friendShip : res){
            result.add(friendShip.getFriendAccept());
        }
        return result;
    }
}
