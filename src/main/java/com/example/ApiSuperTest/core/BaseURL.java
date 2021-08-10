package com.example.ApiSuperTest.core;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BaseURL {
    @Value("${project-config.capp-url.url1}")
    private String url1;

    @Value("${project-config.capp-url.url2}")
    private String url2;

    @Value("${project-config.capp-url.url3}")
    private String url3;

    @Value("${project-config.capp-url.url4}")
    private String url4;
}