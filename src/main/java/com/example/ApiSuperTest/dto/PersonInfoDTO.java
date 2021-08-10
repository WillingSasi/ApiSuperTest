package com.example.ApiSuperTest.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonInfoDTO {
    @Value("${project-config.api-test.person.common_person}")
    private String personId;
    @Value("${project-config.api-test.person.register_customerIdent}")
    private String idCard;
    @Value("${project-config.api-test.person.register_name}")
    private String customerName;

    @Autowired
    private RegisterDTO register;
}
