package com.assessments.demoClock;

import com.assessments.demoClock.controller.ClockController;
import com.assessments.demoClock.service.ServiceBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoClockApplicationTests {

	@Autowired
	private ClockController clockController;

	@Autowired
	private ServiceBean serviceBean;

	@Test
	void contextLoads() {
		assertNotNull(clockController);
		assertNotNull(serviceBean);
	}

}
