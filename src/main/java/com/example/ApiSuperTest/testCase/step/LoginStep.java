package com.example.ApiSuperTest.testCase.step;

import com.example.ApiSuperTest.dao.RegisterDao;
import com.example.ApiSuperTest.dto.LoginInfoDTO;
import com.example.ApiSuperTest.dto.PersonInfoDTO;
import com.example.ApiSuperTest.dto.RegisterDTO;
import com.example.ApiSuperTest.dto.Token;
import com.example.ApiSuperTest.testCase.page.LoginPage;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LoginStep {
    @Autowired
    RegisterDao registerDao;

    @Autowired
    RegisterDTO registerDTO;

    @Autowired
    LoginPage loginPage;

    @Step("Login Step")
    public Response loginApp(PersonInfoDTO personInfo) {
        //首先查询该personid对应注册信息
        String personId =  personInfo.getPersonId();
        String phoneNumber = personInfo.getRegister().getPhoneNumber().isEmpty() ?
                registerDTO.getPhoneNumber():
                personInfo.getRegister().getPhoneNumber();

        LoginInfoDTO loginInfo = registerDao.selectByPersonIdAndPhoneNumber(personId, phoneNumber);

        if (loginInfo == null) {
            loginInfo = registerDao.selectByPersonId(personId);
        }

        //并发情况只login一次
        if (Token.getToken() != null) {
            return null;
        }

        return loginPage.login(phoneNumber,
                personInfo.getRegister().getDeviceId(),
                loginInfo.getPin()).getResponse();
    }
}
