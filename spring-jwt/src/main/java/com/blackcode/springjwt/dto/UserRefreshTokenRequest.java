package com.blackcode.springjwt.dto;

import lombok.Data;

@Data
public class UserRefreshTokenRequest {
    private String refreshToken;
}
