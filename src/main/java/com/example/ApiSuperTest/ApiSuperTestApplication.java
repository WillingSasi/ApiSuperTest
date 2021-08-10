package com.example.ApiSuperTest;

import com.example.ApiSuperTest.testCase.page.BrokeragePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan({"com.example.ApiSuperTest.dao"})
public class ApiSuperTestApplication implements ApplicationRunner {
	@Autowired
	private BrokeragePage brokeragePage;

	public static void main(String[] args) {
		try {
			SpringApplication.run(ApiSuperTestApplication.class, args);
//			new SpringApplicationBuilder(ApiSuperTestApplication.class).run(args);
		}catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		brokeragePage.getVendorExtraInfo().verifyResponseCode200();
	}
}
