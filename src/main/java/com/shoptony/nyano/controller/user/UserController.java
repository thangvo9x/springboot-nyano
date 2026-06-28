package com.shoptony.nyano.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping
    public boolean deleteUser(@RequestParam String userEmail) {
        return userService.deleteUserByUserEmail(userEmail);
    }
}
