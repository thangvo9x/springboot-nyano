package com.shoptony.nyano.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoptony.nyano.entity.user.UserEntity;
import com.shoptony.nyano.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }
    
    @GetMapping("/search")
    public List<UserEntity> searchUsers(@RequestParam String userName, @RequestParam String userEmail) {
        return userService.getUserByUserNameAndUserEmail(userName, userEmail);
    }
}
