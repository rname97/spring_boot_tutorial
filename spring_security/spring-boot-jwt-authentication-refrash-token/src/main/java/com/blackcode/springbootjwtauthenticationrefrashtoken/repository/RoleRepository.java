package com.blackcode.springbootjwtauthenticationrefrashtoken.repository;

import com.blackcode.springbootjwtauthenticationrefrashtoken.models.ERole;
import com.blackcode.springbootjwtauthenticationrefrashtoken.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
