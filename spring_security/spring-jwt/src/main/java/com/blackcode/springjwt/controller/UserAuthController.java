package com.blackcode.springjwt.controller;

import com.blackcode.springjwt.dto.UserJwtResponse;
import com.blackcode.springjwt.dto.UserLoginRequest;
import com.blackcode.springjwt.dto.UserRefreshTokenRequest;
import com.blackcode.springjwt.dto.UserRegistrasiRequest;
import com.blackcode.springjwt.model.User;
import com.blackcode.springjwt.security.jwt.JwtUtils;
import com.blackcode.springjwt.security.service.UserDetailsImpl;
import com.blackcode.springjwt.security.service.UserDetailsServiceImpl;
import com.blackcode.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl adminDetailsService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<UserJwtResponse> authenticationUser(@RequestBody UserLoginRequest request){
        System.out.println(request);
        System.out.println("prosesss");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        System.out.println("prosesss1");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        String refreshToken = jwtUtils.generateRefreshJwtToken(authentication);
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok()
                .body(new UserJwtResponse(
                        token,
                        refreshToken,
                        principal.getId(),
                        principal.getUsername(),
                        principal.getEmail(),
                        principal.getRoles()
                ));
    }

    @PostMapping("/signup")
    public User signup(@RequestBody UserRegistrasiRequest request) {
        System.out.println(request);
        System.out.println("prosesss");
        User user = new User();
        user.setUserUsername(request.getUserUsername());
        user.setUserEmail(request.getUserEmail());
        user.setUserPassword(passwordEncoder.encode(request.getUserPassword()));
        user.setUserNama(request.getUserNama());
        user.setUserRoles("user");
        User created = userService.create(user);
        return created;
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<UserJwtResponse> refreshToken(@RequestBody UserRefreshTokenRequest request) {
        String token = request.getRefreshToken();
        boolean valid = jwtUtils.validateJwtToken(token);
        if (!valid) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        String username = jwtUtils.getUserNameFromJwtToken(token);
        UserDetailsImpl adminDetailsImpl = (UserDetailsImpl) adminDetailsService.loadUserByUsername(username);
        Authentication authentication = new UsernamePasswordAuthenticationToken(adminDetailsImpl, null,
                adminDetailsImpl.getAuthorities());
        String newToken = jwtUtils.generateJwtToken(authentication);
        String refreshToken = jwtUtils.generateRefreshJwtToken(authentication);
        return ResponseEntity.ok(new UserJwtResponse(newToken, refreshToken, adminDetailsImpl.getId(), username, adminDetailsImpl.getEmail(),
                adminDetailsImpl.getRoles()));
    }
}
