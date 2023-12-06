package com.blackcode.springjwt.dto;

import lombok.Data;

@Data
public class UserJwtResponse {
    private String token;
    private String refreshToken;
    private String type = "Bearer";
    private Long userId;
    private String userUsername;
    private String userEmail;
    private String userRoles;

    public UserJwtResponse(
            String accessToken,
            String refreshToken,
            Long userId,
            String userUsername,
            String userEmail,
            String userRoles) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userEmail = userEmail;
        this.userRoles = userRoles;
        this.token = accessToken;
        this.refreshToken = refreshToken;

    }
}
