package com.lenncoder.service.impl;

import com.lenncoder.entity.User;
import com.lenncoder.exceptions.EmailAlreadyExistsException;
import com.lenncoder.payload.UserDto;
import com.lenncoder.payload.UserSignInDto;
import com.lenncoder.repository.UserRepository;
import com.lenncoder.service.UserService;
import com.lenncoder.util.AESUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        // Checking if a user with the provided email already exists or not
        if (this.userRepository.findByEmail(userDto.getEmail()).isPresent())
            throw new EmailAlreadyExistsException("Email already exists " + userDto.getEmail() + " use another email id");

        // Encrypting the password before saving
        try {
            userDto.setPassword(AESUtil.encrypt(userDto.getPassword()));

        } catch (Exception e){
            e.printStackTrace();

        }
        // Converting  DTO to User entity
        User user = this.dtoToUser(userDto);

        // Saving  the new user to the database
        User savedUser = this.userRepository.save(user);

        // Converting the saved user entity back to DTO and return it
        return this.userToDto(savedUser);

    }

    @Override
    public boolean signIn(UserSignInDto userSignInDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userSignInDto.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            try {
                // Decrypting the stored password
//                String decryptedPassword = AESUtil.decrypt(user.getPassword());
                String encryptedPass = AESUtil.encrypt(userSignInDto.getPassword());
                // Checking if the decrypted password matches the sign-in password
                if(encryptedPass.equals(user.getPassword())){
                    return true;
                }

            } catch (Exception e){
                e.printStackTrace();

            }
        }
        return false;
    }

    private User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        return user;
    }

// nvpigorinvjfgnrkvpifngrivnjk fgprnjgkv
    public UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        return userDto;
    }


}
