package com.example.ApiSuperTest.testCase.page;

import com.example.ApiSuperTest.core.BaseApiCore;
import com.example.ApiSuperTest.core.BaseURL;
import com.example.ApiSuperTest.core.BaseVerifyCore;
import com.example.ApiSuperTest.constant.Constant;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrokeragePage extends BaseApiCore {
    @Autowired
    private BaseURL baseURL;

    @Step("Update Url, Route: /updateUrl")
    public BaseVerifyCore updateUrl(List<String> downloadList) {
        // Declare necessary variables
        Map<String, Object> header = new HashMap<>();
        StringBuilder requestUrl = new StringBuilder();

        // Set Request Header
        header.put("Content-Type", ContentType.JSON);

        //set request param
        Map<String, Object> requestJson = new HashMap<>();
        requestJson.put("url", downloadList);

        // Set Request URL
        requestUrl.append(baseURL.getUrl1()).append(Constant.UPDATE_URL);

        // Get response after request sent and compare with except result
        return new BaseVerifyCore(jsonPost(requestUrl.toString(), header, new Gson().toJson(requestJson)));
    }

    @Step("Get Info, Route: /getInfo")
    public BaseVerifyCore getInfo (){
        //Declare necessary variables
        StringBuffer requestUrl = new StringBuffer();

        //Request Header
        Map<String, Object> header=new HashMap<String, Object>();

        //Set Request URL
        requestUrl.append(baseURL.getUrl1()).append(Constant.GET_INFO);

        return new BaseVerifyCore(get(requestUrl.toString(),header));
    }
}
