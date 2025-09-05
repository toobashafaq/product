package com.application.product.product.controller;

import com.application.product.product.entity.User;
import com.application.product.product.service.MyUserDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MyUserDetailsServices myUserDetailsServices;
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return myUserDetailsServices.createUser(user);
    }
}
