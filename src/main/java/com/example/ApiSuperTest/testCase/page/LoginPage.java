package com.example.ApiSuperTest.testCase.page;

import com.example.ApiSuperTest.core.BaseApiCore;
import com.example.ApiSuperTest.core.BaseURL;
import com.example.ApiSuperTest.core.BaseVerifyCore;
import com.example.ApiSuperTest.dto.TemporaryGlobalParam;
import com.example.ApiSuperTest.dto.Token;
import com.example.ApiSuperTest.constant.Constant;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginPage extends BaseApiCore {
    @Autowired
    private BaseURL baseURL;

    @Step("Login, Route: /login")
    public BaseVerifyCore login(String phoneNumber, String deviceId, String pinCodeNew) {
        // Declare necessary variables
        Map<String, Object> requestParm = new HashMap<>();
        Map<String, Object> requestHeader = new HashMap<>();
        StringBuilder requestUrl = new StringBuilder();

        // Set Request Header
        requestHeader.put("Content-Type", ContentType.URLENC);

        // Set Request URL
        requestUrl.append(baseURL.getUrl1()).append(Constant.DO_LOGIN);

        // Set Request Parameters
        requestParm.put("phoneNumber", phoneNumber);
        requestParm.put("pin", pinCodeNew);
        requestParm.put("deviceId", deviceId);

        // Get response after request sent and compare with except result
        BaseVerifyCore baseVerifyCore = new BaseVerifyCore(formPost(requestUrl.toString(), requestHeader, requestParm));

        // Save token
        Token.setToken(baseVerifyCore.getResponse().getHeaders().getValue("token"));

        // save fakeid and cuid
        TemporaryGlobalParam.setFakeId(baseVerifyCore.getResponse().getBody().jsonPath().getString("value.fakeId"));
        TemporaryGlobalParam.setCuId(baseVerifyCore.getResponse().getBody().jsonPath().getString("value.cuId"));

        return baseVerifyCore;
    }
}
