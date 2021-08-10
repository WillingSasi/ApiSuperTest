package com.example.ApiSuperTest.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class RegisterDTO {
//    @Value("${project-config.api-test.person.register_phoneNumber}")
    @Value("${register_phoneNumber}")
    private String phoneNumber;
    private String phoneNumberStatus;
    private String pin;
    private String per_id;
    private String idCard;
    @Value("${project-config.api-test.login.deviceCode}")
    private String deviceId;
}
