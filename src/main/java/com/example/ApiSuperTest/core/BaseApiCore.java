package com.example.ApiSuperTest.core;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Log4j2
public class BaseApiCore {
    @Autowired
    private BasicAuth basicAuth;

    public BaseApiCore(){
        //加载log4j，日志输出到rest assured请求log中
//        RestAssured.config = RestAssured.config().logConfig(new io.restassured.config.LogConfig(new ToLoggerPrintStream().getPrintStream(), true));

        //静态定义请求https
        RestAssured.useRelaxedHTTPSValidation();

        StringBuffer deviceIdRandom = new StringBuffer();
        deviceIdRandom.append("86778123").append((int) ((Math.random() * 9 + 1) * 1000000));
    }

    public Response get(String url, Map<String, Object> header) {
        this.addBasicAuth(header);
        Response response =
                given().relaxedHTTPSValidation().log().all().
                        headers(header).
                        when().
                        get(url).
                        then().
                        extract().response();

        return response;
    }

    public Response get(String url, Map<String, Object> header, Map<String, Object> requestParamsMap) {
        this.addBasicAuth(header);
        Response response =
                given().
                        log().uri().
                        log().params().
                        log().headers().
                        log().body().
                        headers(header).
                        queryParams(requestParamsMap).
                        when().
                        get(url).
                        then().log().body().
                        extract().response();

        return response;
    }

    public Response post(String url, Map<String, Object> header) {
        this.addBasicAuth(header);
        Response response =
                given().
                        log().uri().
                        log().params().
                        log().headers().
                        log().body().
                        headers(header).
                        when().
                        post(url).
                        then().
                        log().body().
                        extract().response();

        return response;
    }

    public Response queryPost(String url, Map<String, Object> header, Map<String, Object> requestParamsMap) {
        this.addBasicAuth(header);
        Response response =
                given().relaxedHTTPSValidation().log().all().
                        headers(header).
                        queryParams(requestParamsMap).
                        when().
                        post(url).
                        then().
                        extract().response();

        return response;
    }

    public Response jsonPost(String url, Map<String, Object> header, String json) {
        this.addBasicAuth(header);
        Response response =
                given().log().all().
                        headers(header).
                        body(json).
                        when().
                        post(url).
                        then().
                        extract().response();

        return response;
    }

    public Response queryJsonPost(String url, Map<String, Object> header, Map<String, Object> requestParamsMap, String json) {
        this.addBasicAuth(header);
        Response response =
                given().log().all().
                        headers(header).
                        queryParams(requestParamsMap).
                        body(json).
                        when().
                        post(url).
                        then().
                        extract().response();

        return response;
    }

    public Response formPostFile(String url, Map<String, Object> header, String filePath, Map<String, Object> propertiesMap) {
        this.addBasicAuth(header);
        Response response =
                given().relaxedHTTPSValidation().log().all().
                        headers(header).multiPart(new File(filePath)).
                        formParams(propertiesMap).
                        when().
                        post(url).
                        then().
                        extract().response();

        return response;
    }

    public Response formPost(String url, Map<String, Object> header, Map<String, Object> requestParamsMap) {
        this.addBasicAuth(header);
        Response response =
                given().relaxedHTTPSValidation().log().all().
                        headers(header).
                        formParams(requestParamsMap).
                        when().
                        post(url).
                        then().
                        extract().response();

        return response;
    }

    public Response formPostFile(String url, Map<String, Object> header, String controlName, String filePath, Map<String, Object> propertiesMap) {
        this.addBasicAuth(header);
        Response response =
                given().relaxedHTTPSValidation().log().all().
                        headers(header).multiPart(controlName, new File(filePath)).
                        formParams(propertiesMap).
                        when().
                        post(url).
                        then().
                        extract().response();

        return response;
    }

    private void addBasicAuth(Map<String, Object> header) {
        header.put("Authorization", basicAuth.getBasicAuth());
    }
}
