package com.example.ApiSuperTest.core;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
public class BasicAuth {
    @Value("${project-config.api-test.auth.username}")
    private String username;

    @Value("${project-config.api-test.auth.password}")
    private String password;

    public String getBasicAuth(){
        return basicAuth(username, password);
    }
    /**
     * @Name: basicAuth
     * @Description: Convert appKey and secretKey to basic authorization
     * @param appKey, app key
     * @param secretKey, secret key
     */
    public String basicAuth(String appKey, String secretKey) {
        String auth = appKey + ":" + secretKey;
        String encodedAuth = Base64.encodeBase64String(auth.getBytes(Charset.forName("US-ASCII")));
        String base64Auth = "Basic " + new String(encodedAuth);
        return base64Auth;
    }
}
