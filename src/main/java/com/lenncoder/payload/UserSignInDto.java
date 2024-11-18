package com.lenncoder.payload;

import lombok.Data;

@Data
public class UserSignInDto {
    private String email;
    private String password;
}
