package com.assessments.demoClock;

import com.assessments.demoClock.controller.ClockController;
import com.assessments.demoClock.service.ServiceBean;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class DemoClockApplicationTests {

	@Autowired
	private ClockController clockController;

	@MockBean
	private ServiceBean serviceBean;

	@Test
	public void testConvertGivenTimeMidnightPositive() {
		String givenTime = "12:30";  // Provide a valid time for testing
		when(serviceBean.convertGivenTimeToMiddayOrMidnight(givenTime)).thenReturn("It's Midnight");

		// Calling the controller method
		ResponseEntity<String> response = clockController.convertGivenTimeToWords(givenTime);

		// Asserting the response status and body
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("It's Midnight", response.getBody(),"givenTime = 12:30 -- It's Midnight");
	}

	@Test
	public void testConvertGivenTimeMiddayPositive() {
		String givenTime = "10:30";  // Provide a valid time for testing
		when(serviceBean.convertGivenTimeToMiddayOrMidnight(givenTime)).thenReturn("It's Midday");

		ResponseEntity<String> response = clockController.convertGivenTimeToWords(givenTime);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("It's Midday", response.getBody(),"givenTime = 10:30 -- It's Midday");
	}

	// Negative Scenario
	@Test
	public void testConvertGivenTimeNegative() {
		String givenTime = "28:30";  // Provide a valid time for testing
		when(serviceBean.convertGivenTimeToMiddayOrMidnight(givenTime)).thenReturn("Invalid time format. Please provide a valid time in HH:mm format.");

		ResponseEntity<String> response = clockController.convertGivenTimeToWords(givenTime);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Invalid time format. Please provide a valid time in HH:mm format.", response.getBody(),"givenTime = 28:30 -- Invalid time format.");
	}


	//@Disabled
	@Test
	public void testConvertCurrentTimeToWords() {

		String currentTime = "15:45";
		when(serviceBean.getCurrentTimeInWords()).thenReturn("It's thirteen twelve");

		ResponseEntity<String> response = clockController.convertCurrentTimeToWords();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("It's thirteen twelve", response.getBody());
	}

}
