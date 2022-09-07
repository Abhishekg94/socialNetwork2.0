package com.example.allinone.service;

import com.example.allinone.service.request.LikeRequestDto;

public interface LikeService {
    void addLike(LikeRequestDto likeRequest) throws Exception;
}
