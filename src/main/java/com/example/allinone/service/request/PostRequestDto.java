package com.example.allinone.service.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {

    private int userId;
    private String writeText;
    private String mediaPath;
}
