package com.example.ApiSuperTest.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "project-config.api-test.login")
public class LoginVerifyDTO {
    private String verificationCode;
    private String deviceCode;
    private String deviceName;
    private String pin;
    private String pinCode;
}
