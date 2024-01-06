package com.blackcode.springbootjwtsimple.repository;

import com.blackcode.springbootjwtsimple.entity.ERole;
import com.blackcode.springbootjwtsimple.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
