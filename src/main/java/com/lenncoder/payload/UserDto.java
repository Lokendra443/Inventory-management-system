package com.lenncoder.payload;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
}
