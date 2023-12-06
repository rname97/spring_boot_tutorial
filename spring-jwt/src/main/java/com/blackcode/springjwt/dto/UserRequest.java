package com.blackcode.springjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Builder
public class UserRequest {
    @NotEmpty(message = "Username Tidak boleh kosong")
    private String userUsername;

    @NotEmpty(message = "Password Tidak boleh kosong")
    private String userPassword;

    @NotEmpty(message = "nama Tidak boleh kosong")
    private String userNama;

    @NotEmpty(message = "alamat Tidak boleh kosong")
    private String userAlamat;

    @NotEmpty(message = "email Tidak boleh kosong")
    private String userEmail;

    @NotEmpty(message = "hp Tidak boleh kosong")
    private String userNoHp;

    @NotEmpty(message = "roles Tidak boleh kosong")
    private String userRoles;

    @NotEmpty(message = "roles Tidak boleh kosong")
    private Boolean userIsAktif;
}
