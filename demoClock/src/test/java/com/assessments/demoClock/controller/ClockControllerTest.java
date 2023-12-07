package com.assessments.demoClock.controller;

import com.assessments.demoClock.service.ServiceBean;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClockControllerTest {

    @Mock
    private ServiceBean serviceBean;

    @InjectMocks
    private ClockController clockController;

    @Test
    public void testConvertGivenTimeToWords() {
        // Arrange
        String givenTime = "08:34";
        String expectedResult = "It's eight thirty-four";
        when(serviceBean.convertGivenTimeToMiddayOrMidnight(givenTime)).thenReturn(expectedResult);

        ResponseEntity<String> response = clockController.convertGivenTimeToWords(givenTime);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
        verify(serviceBean, times(1)).convertGivenTimeToMiddayOrMidnight(givenTime);
    }

    @Test
    public void testConvertCurrentTimeToWords() {
        // Arrange
        String expectedResult = "It's current time in words";
        when(serviceBean.getCurrentTimeInWords()).thenReturn(expectedResult);

        // Act
        ResponseEntity<String> response = clockController.convertCurrentTimeToWords();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
        verify(serviceBean, times(1)).getCurrentTimeInWords();
    }
}
