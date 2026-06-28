package com.shoptony.nyano.service.impl;

import com.shoptony.nyano.entity.user.UserEntity;
import com.shoptony.nyano.repository.UserRepository;
import com.shoptony.nyano.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserEntity getUserByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    @Override
    public boolean deleteUserByUserEmail(String userEmail) {
         var hasDeleted = userRepository.deleteByUserEmail(userEmail);
         return hasDeleted > 0;
    }

    @Override
    public List<UserEntity> getUserByUserNameAndUserEmail(String userName, String userEmail) {
        return userRepository.findByUserNameOrUserEmail(userName, userEmail);
    }


}
