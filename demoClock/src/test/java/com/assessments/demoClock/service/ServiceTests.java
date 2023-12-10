package com.assessments.demoClock.service;

import com.assessments.demoClock.service.ServiceBean;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceBeanTests {

    private final ServiceBean serviceBean = new ServiceBean();


    @Test
    void testConvertTimeInWords() {

        String result = serviceBean.convertTimeInWords("12:30");
        assertEquals("It's twelve thirty minutes", result);

        String result2 = serviceBean.convertTimeInWords("13:03");
        assertEquals("It's thirteen three minutes", result2);

    }

    //@Disabled
    @Test
    void testConvertGivenTimeToMiddayOrMidnight() {
        // Test converting given time to midday or midnight
        String resultMidnight = serviceBean.convertGivenTimeToMiddayOrMidnight("23:00");
        assertEquals("It's Midnight", resultMidnight);

        String resultMidday = serviceBean.convertGivenTimeToMiddayOrMidnight("00:00");
        assertEquals("It's Midday", resultMidday);

        String resultInvalid = serviceBean.convertGivenTimeToMiddayOrMidnight("40:05");
        assertEquals("Invalid time format. Please provide a valid time in HH:mm format.", resultInvalid);


    }


    @Test
    void testInvalidTimeFormat() {
        // Test invalid time format
        String invalidTime = "invalidTime";
        String result = serviceBean.convertTimeInWords(invalidTime);
        assertEquals("Invalid time format. Please provide a valid time in HH:mm format.", result);

    }
}



