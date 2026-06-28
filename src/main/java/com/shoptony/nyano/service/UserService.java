package com.shoptony.nyano.service;

import com.shoptony.nyano.entity.user.UserEntity;
import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);

    List<UserEntity> getAllUsers();

    UserEntity getUserByUserName(String userName);

    UserEntity getUserByUserEmail(String userEmail);

    boolean deleteUserByUserEmail(String userEmail);

    List<UserEntity> getUserByUserNameAndUserEmail(String userName, String userEmail);
}
