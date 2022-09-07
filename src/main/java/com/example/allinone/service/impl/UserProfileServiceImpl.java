package com.example.allinone.service.impl;

import com.example.allinone.dao.UserProfileDao;
import com.example.allinone.dao.model.UserProfile;
import com.example.allinone.service.UserProfileService;
import com.example.allinone.service.request.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    @Override
    public void addUser(UserRequestDto userRequest) {

        UserProfile user = new UserProfile();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setMobileNo(userRequest.getMobileNo());
        user.setPassword(userRequest.getPassword());
        user.setDob(new Date());
        user.setCreatedAt(new Date());
        userProfileDao.save(user);
    }
}
