package com.blackcode.springjwt.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegistrasiRequest implements Serializable {
    private String userUsername;
    private String userPassword;
    private String userEmail;
    private String userNama;
}
