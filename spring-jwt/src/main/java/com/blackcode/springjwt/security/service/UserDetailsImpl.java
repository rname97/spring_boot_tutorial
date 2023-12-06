package com.blackcode.springjwt.security.service;

import com.blackcode.springjwt.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String username;
    private String email;
    private String nama;
    private String password;
    private String roles;

    public UserDetailsImpl(Long id, String username, String email, String nama, String password, String roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nama = nama;
        this.password = password;
        this.roles = roles;
    }

    public static UserDetailsImpl build1(User user) {
        return new UserDetailsImpl(
                user.getUserId(),
                user.getUserUsername(),
                user.getUserEmail(),
                user.getUserNama(),
                user.getUserPassword(),
                user.getUserRoles()
        );

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(StringUtils.hasText(roles)){
            String[] splits = roles.replaceAll(" ", "").split(",");
            for (String string : splits){
                authorities.add(new SimpleGrantedAuthority(string));
            }
        }
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
