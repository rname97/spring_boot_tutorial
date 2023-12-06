package com.blackcode.project04.service;

import com.blackcode.project04.entity.User;
import com.blackcode.project04.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }else{
            throw new RuntimeException("Data User Id Not Found : "+id);
        }
        return user;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        User userDB = userRepository.findById(userId).get();
        if(Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())){
            userDB.setUserName(user.getUserName());
        }
        if(Objects.nonNull(user.getUserAddress()) && !"".equalsIgnoreCase(user.getUserAddress())){
            userDB.setUserAddress(user.getUserAddress());
        }
        return userRepository.save(userDB);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
