package com.assessments.demoClock.service;

import com.assessments.demoClock.service.ServiceBean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceBeanTests {

    private final ServiceBean serviceBean = new ServiceBean();

    @Test
    void testConvertTimeInWords() {
        // Test a valid time conversion
        String result = serviceBean.convertTimeInWords("12:30");
        assertEquals("It's twelve thirty minutes", result);

        // Add more test cases for different times
    }

    @Test
    void testGetCurrentTimeInWords() {

        String result = serviceBean.getCurrentTimeInWords();

        assertEquals("It's [current time in words]", result);
    }

    @Test
    void testConvertGivenTimeToMiddayOrMidnight() {
        // Test converting given time to midday or midnight
        String resultMidday = serviceBean.convertGivenTimeToMiddayOrMidnight("09:00");
        assertEquals("It's Midday", resultMidday);

        String resultMidnight = serviceBean.convertGivenTimeToMiddayOrMidnight("00:00");
        assertEquals("It's Midnight", resultMidnight);


    }

    @Test
    void testInvalidTimeFormat() {
        // Test invalid time format
        String invalidTime = "invalidTime";
        String result = serviceBean.convertTimeInWords(invalidTime);
        assertEquals("Invalid time format", result);

    }
}



