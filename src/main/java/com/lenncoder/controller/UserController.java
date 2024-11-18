package com.lenncoder.controller;

import com.lenncoder.payload.UserDto;
import com.lenncoder.payload.UserSignInDto;
import com.lenncoder.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody UserSignInDto userSignInDto){
        boolean isSignedIn = userService.signIn(userSignInDto);
        if(isSignedIn){
            return ResponseEntity.ok("Sign in successful");
        }
        else {
            return ResponseEntity.ok("Invalid email or password");
        }
    }
}
