package com.abhishek.bookmyshow_backendsystem.Controllers;

import com.abhishek.bookmyshow_backendsystem.Dtos.*;
import com.abhishek.bookmyshow_backendsystem.Models.User;
import com.abhishek.bookmyshow_backendsystem.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
// This controller class is capable of implementing REST APIs and hosting HTTTP requests
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // http://localhost:8080/users/signup
    @PostMapping("/signup")
    public SignUpResponseDto signUp(@RequestBody SignUpRequestDto signUpRequestDto)
    {
        User user = new User(
                signUpRequestDto.getUsername(),
                signUpRequestDto.getName(),
                signUpRequestDto.getEmail(),
                signUpRequestDto.getPassword()
        );
        User savedUser = userService.signUp(user);
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        signUpResponseDto.setName(savedUser.getName());
        signUpResponseDto.setUsername(savedUser.getUsername());
        signUpResponseDto.setEmail(savedUser.getEmail());

        return signUpResponseDto;
    }

    // http://localhost:8080/users/login
    @PostMapping("/login")
    public LogInResponseDto loginUser(@RequestBody LoginRequestDto loginRequestDto)
    {
        User user = new User();
        user.setEmail(loginRequestDto.getEmail());
        user.setPassword(loginRequestDto.getPassword());
        ResponseStatus responseStatus = userService.login(user);

        LogInResponseDto logInResponseDto = new LogInResponseDto();
        logInResponseDto.setResponseStatus(responseStatus);
        return logInResponseDto;
    }
}
