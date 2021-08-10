package com.example.ApiSuperTest.core;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class BaseVerifyCore {
    private Response response;
    public static List<Error> errors = new ArrayList<>();
    public static Boolean flag = true;

    public BaseVerifyCore() {
    }

    public BaseVerifyCore(Response response) {
        this.response = response;
    }

    @Step("Verify Response Code")
    public BaseVerifyCore verifyResponseCode(int expected) {
        int actual = response.getBody().jsonPath().getInt("code");
        Assert.assertEquals(actual, expected);
        return this;
    }

    @Step("Verify Response Code")
    public BaseVerifyCore verifyResponseCode200() {
        return verifyResponseCode(200);
    }

    @Step("Verify Response Code")
    public BaseVerifyCore verifyResponseCode(Response response, int expected) {
        int actual = response.getBody().jsonPath().getInt("code");
        Assert.assertEquals(actual, expected);
        return this;
    }

    /**
     * @Name: verifyResponseCode
     * @Description: check code of response
     * @Parameters: actual
     * @Parameters: expected
     * @Author: graham
     * @Create Date: 2019/7/15
     */
    @Step("Verify Response Type")
    public BaseVerifyCore verifyResponseType(String expected) {
        String actual = response.getHeaders().getValue("Content-Type");
        Assert.assertEquals(actual, expected);
        return this;
    }

    /**
     * @Name: verifyResponseCode
     * @Description: check code of response
     * @Parameters: actual
     * @Parameters: expected
     * @Author: graham
     * @Create Date: 2019/7/15
     */
    @Step("Verify Response Type")
    public BaseVerifyCore verifyResponseType(Response response, String expected) {
        String actual = response.getHeaders().getValue("Content-Type");
        Assert.assertEquals(actual, expected);
        return this;
    }

    @Step("Verify Response Key Exist")
    public BaseVerifyCore verifyResponseKeyExist(String key, boolean exist) {
        boolean actual = response.getBody().jsonPath().getString(key).length() > 0;
        Assert.assertEquals(actual, exist);
        return this;
    }

    @Step("Verify Response Value")
    public BaseVerifyCore verifyResponseValue(String key, Object expect ) {
        Object actual = response.getBody().jsonPath().get(key);
        Assert.assertEquals(actual, expect);
        return this;
    }

    @Step("Verify Response Value Contains")
    public BaseVerifyCore verifyResponseValueContains(String key) {
        boolean actual = response.getBody().print().toString().contains(key);
        Assert.assertTrue(actual);
        return this;
    }

    public Response getResponse(){
        if (response == null) {
            log.info("Response is null!");
        }
        return this.response;
    }

}
