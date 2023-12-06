package com.blackcode.springjwt.security.service;

import com.blackcode.springjwt.model.User;
import com.blackcode.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserUsername(username);
        if (user != null) {
            return UserDetailsImpl.build1(user);
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");

    }
}
