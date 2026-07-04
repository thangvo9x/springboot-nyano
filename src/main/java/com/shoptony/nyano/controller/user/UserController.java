package com.shoptony.nyano.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    /*
    * get all users
    * */

    @GetMapping("/get-all")
    public Page<UserEntity> getAllUsers(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.findAllUsers(pageable);
    }

    @GetMapping("/search-page")
    public Page<UserEntity> searchPageUserName(
            @RequestParam String userName,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.findByUserName(userName, pageable);
    }

    @DeleteMapping
    public boolean deleteUser(@RequestParam String userEmail) {
        return userService.deleteUserByUserEmail(userEmail);
    }
}
