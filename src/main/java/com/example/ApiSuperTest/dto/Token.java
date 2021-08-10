package com.example.ApiSuperTest.dto;

import lombok.Data;

public class Token {
    private Token(){};
    private volatile static String token;
    public static String idCardToken;
    public static String sessionToken;
    public static String formToken;

    public static String getSessionToken() {
        return sessionToken;
    }

    public static void setSessionToken(String sessionToken) {
        Token.sessionToken = sessionToken;
    }

    public  static  String getIdCardToken() {
        return idCardToken;
    }

    public synchronized static String getToken() {
        return token;
    }

    public static void setIdCardToken(String idCardToken) {
        Token.idCardToken = idCardToken;
    }

    public static void setToken(String token) {
        synchronized (token) {
            Token.token = token;
        }
    }

    public static String getFormToken() {
        return formToken;
    }

    public static void setFormToken(String formToken) {
        Token.formToken = formToken;
    }
}