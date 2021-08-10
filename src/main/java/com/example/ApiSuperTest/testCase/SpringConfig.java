package com.example.ApiSuperTest.testCase;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = "com.example.ApiSuperTest.core")
@ComponentScan(basePackages = "com.example.ApiSuperTest.dao")
@ComponentScan(basePackages = "com.example.ApiSuperTest.dto")
@ComponentScan(basePackages = "com.example.ApiSuperTest.testCase")
public class SpringConfig {
}
