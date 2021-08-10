package com.example.ApiSuperTest;

import com.example.ApiSuperTest.listener.TestngISuiteListener;
import com.example.ApiSuperTest.testCase.page.BrokeragePage;
import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@Features({@Feature("Page Test")})
@Severity(SeverityLevel.NORMAL)
@ActiveProfiles("sit")
@Log4j2
//@Listeners({TestngISuiteListener.class})
@SpringBootTest(classes = {ApiSuperTestApplication.class})
public class ApiSuperTestApplicationTests extends AbstractTestNGSpringContextTests {
	@Autowired
	private BrokeragePage brokeragePage;

	@Story("Brokerage Page")
	@Issue("BUG号：123")
	@Link(value = "https://xxxx", url = "https://xxxx")
	@Test(enabled = true)
	public void brokerage() {
		brokeragePage.getInfo().verifyResponseCode200();
	}

	@Step("API Test Init")
	@BeforeTest(enabled = true)
	public void setUp(){
		log.info("-------------------------Start Test Case " + this.getClass().getSimpleName() + "-------------------------");
	}

	@Step("API Test Recycle")
	@AfterTest(enabled = true)
	public void tearDown(){
		log.info("-------------------------End Test Case " + this.getClass().getSimpleName() + "-------------------------");
	}

}
