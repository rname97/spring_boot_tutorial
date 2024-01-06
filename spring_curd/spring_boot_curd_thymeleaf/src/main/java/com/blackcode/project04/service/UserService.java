package com.blackcode.project04.service;

import com.blackcode.project04.entity.User;

import java.util.List;

public interface UserService {

    User getById(Long id);
    User saveUser(User user);
    List<User> fetchUserList();
    User updateUser(User user, Long userId);
    void deleteUserById(Long userId);

}
