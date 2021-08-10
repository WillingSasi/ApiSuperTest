package com.example.ApiSuperTest;

import com.example.ApiSuperTest.dto.PersonInfoDTO;
import com.example.ApiSuperTest.testCase.page.LoginPage;
import com.example.ApiSuperTest.testCase.step.LoginStep;
import io.qameta.allure.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Features({@Feature("Page Test")})
@Severity(SeverityLevel.NORMAL)
@ActiveProfiles("sit")
@SpringBootTest(classes = {ApiSuperTestApplication.class})
public class LoginTest extends AbstractTestNGSpringContextTests {
    @Autowired
    com.example.ApiSuperTest.testCase.page.LoginPage loginPage;

    @Autowired
    LoginStep loginStep;

    @Autowired
    PersonInfoDTO personInfo;

    @Story("Login Page")
    @Issue("BUG号：123")
    @Link(value = "https://xxxx", url = "https://xxxx")
    @Test(enabled = true)
    public void brokerage() {
        loginStep.loginApp(personInfo);
    }
}
