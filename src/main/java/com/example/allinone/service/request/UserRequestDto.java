package com.example.allinone.service.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserRequestDto {

    private String name;
    private String email;
    private String mobileNo;
    private String password;
    private String dob;
}
