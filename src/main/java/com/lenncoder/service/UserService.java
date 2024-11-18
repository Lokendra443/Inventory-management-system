package com.lenncoder.service;

import com.lenncoder.payload.UserDto;
import com.lenncoder.payload.UserSignInDto;

public interface UserService {
    UserDto createUser(UserDto user);
    boolean signIn(UserSignInDto userSignInDto);
}
