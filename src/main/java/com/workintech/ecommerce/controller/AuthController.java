package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.RegisterUserResponse;
import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
@AllArgsConstructor
public class AuthController {

    private AuthenticationService authenticationService;

    @PostMapping
    public UserResponse register(@RequestBody RegisterUserResponse registerUserResponse){
        return authenticationService.register(registerUserResponse.name(), registerUserResponse.email(), registerUserResponse.password(), registerUserResponse.roleId());
    }



}
