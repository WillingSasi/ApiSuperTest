package com.example.ApiSuperTest.dto;

import lombok.Data;

@Data
public class LoginInfoDTO {
    private String pin;
    private String phoneNumber;
    private String deviceCode;
}
