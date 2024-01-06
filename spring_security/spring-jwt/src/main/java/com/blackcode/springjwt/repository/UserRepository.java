package com.blackcode.springjwt.repository;

import com.blackcode.springjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserUsername(String username);
}
