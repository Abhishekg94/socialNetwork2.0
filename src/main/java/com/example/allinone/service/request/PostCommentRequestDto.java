package com.example.allinone.service.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCommentRequestDto {

    private int postId;
    private int userid;
    private String comment;
}
