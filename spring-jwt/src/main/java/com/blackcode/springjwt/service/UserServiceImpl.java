package com.blackcode.springjwt.service;

import com.blackcode.springjwt.model.User;
import com.blackcode.springjwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Override
    public User create(User user) {
        user.setUserIsAktif(true);
        return userRepository.save(user);
    }
}
