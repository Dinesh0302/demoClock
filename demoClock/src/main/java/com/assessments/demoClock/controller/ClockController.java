package com.assessments.demoClock.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import com.assessments.demoClock.service.ServiceBean;

@RestController
public class ClockController {
    private final ServiceBean serviceBean;

    @Autowired
    public ClockController(ServiceBean serviceBean) {
        this.serviceBean = serviceBean;
    }


    @GetMapping("/")
    @Operation(summary = "Redirect to Swagger UI", description = "Redirects to Swagger UI")
    public RedirectView redirectToSwaggerUI() {
        return new RedirectView("/swagger-ui.html");
    }

    @GetMapping("/givenTime")
    @Operation(summary = "Convert the given time to words", description = "Returns the time in words for the given time")
    public ResponseEntity<String> convertGivenTimeToWords(@RequestParam String time) {
        try {
            String result = serviceBean.convertGivenTimeToMiddayOrMidnight(time);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/convert")
    @Operation(summary = "Convert the current time to words", description = "Returns the current time in words")
    public ResponseEntity<String> convertCurrentTimeToWords() {
        try {
            String result = serviceBean.getCurrentTimeInWords();
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
