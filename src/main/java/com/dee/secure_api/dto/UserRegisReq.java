package com.dee.secure_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisReq {
    private String username;
    private String password;
    private String email;
}
