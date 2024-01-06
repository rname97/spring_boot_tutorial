package com.blackcode.springjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long userId;
    private String userUsername;
    private String userPassword;
    private String userNama;
    private String userAlamat;
    private String userEmail;
    private String userNoHp;
    private String userRoles;
    private Boolean userIsAktif;
}
