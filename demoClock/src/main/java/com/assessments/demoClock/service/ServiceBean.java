package com.assessments.demoClock.service;

import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class ServiceBean {

    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public String convertTimeInWords(String time) {
        try {
            validateTimeFormat(time);
            return convertTimeToWords(time);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public String getCurrentTimeInWords() {
        try {
            String currentTime = getCurrentTime();
            return convertTimeToWords(currentTime);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public String convertGivenTimeToMiddayOrMidnight(String time) {
        try {
            validateTimeFormat(time);
            String[] timeParts = time.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            System.out.println("this is " + hours);
            System.out.println("this is M  " + minutes);

            if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
                System.out.println("this is 1" + minutes);
                return "Invalid time";
            }
           // midday starts at 12am to 11.59AM
            if (hours >= 0 && hours <= 11 & minutes >= 0 && minutes <= 59) {
                return "It's Midday";
            }
            // midnuight starts at 12pm to 11:59 PM
            else if (hours >= 12 && hours <= 23 & minutes >= 0 && minutes <= 59) {
                return "It's Midnight";
            }
            else {
                System.out.println("this is 2" + minutes);
                return "Invalid Time";

            }
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }


    private void validateTimeFormat(String time) {
        try {
            timeFormat.setLenient(false);
            timeFormat.parse(time);
        } catch (ParseException | IllegalArgumentException e) {
            throw new RuntimeException("Invalid time format. Please provide a valid time in HH:mm format.");
        }
    }

    private String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        Date currentTime = calendar.getTime();
        return timeFormat.format(currentTime);
    }

    private String convertTimeToWords(String time) {
        try {
            String[] timeParts = time.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);

            String hoursInWords = convertNumberToWords(hours);
            String minutesInWords = convertNumberToWords(minutes);

            return "It's " + hoursInWords + " " + (minutes > 0 ? minutesInWords + " minutes" : "");
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error converting time to words");
        }
    }


    private String convertNumberToWords(int number) {
        // Basic implementation to convert numbers to words
        switch (number) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            case 20:
                return "twenty";
            case 21:
                return "twenty-one";
            case 22:
                return "twenty-two";
            case 23:
                return "twenty-three";
            case 24:
                return "twenty-four";
            case 25:
                return "twenty-five";
            case 26:
                return "twenty-six";
            case 27:
                return "twenty-seven";
            case 28:
                return "twenty-eight";
            case 29:
                return "twenty-nine";
            case 30:
                return "thirty";
            case 31:
                return "thirty-one";
            case 32:
                return "thirty-two";
            case 33:
                return "thirty-three";
            case 34:
                return "thirty-four";
            case 35:
                return "thirty-five";
            case 36:
                return "thirty-six";
            case 37:
                return "thirty-seven";
            case 38:
                return "thirty-eight";
            case 39:
                return "thirty-nine";
            case 40:
                return "forty";
            case 41:
                return "forty-one";
            case 42:
                return "forty-two";
            case 43:
                return "forty-three";
            case 44:
                return "forty-four";
            case 45:
                return "forty-five";
            case 46:
                return "forty-six";
            case 47:
                return "forty-seven";
            case 48:
                return "forty-eight";
            case 49:
                return "forty-nine";
            case 50:
                return "fifty";
            case 51:
                return "fifty-one";
            case 52:
                return "fifty-two";
            case 53:
                return "fifty-three";
            case 54:
                return "fifty-four";
            case 55:
                return "fifty-five";
            case 56:
                return "fifty-six";
            case 57:
                return "fifty-seven";
            case 58:
                return "fifty-eight";
            case 59:
                return "fifty-nine";
            default:
                return String.valueOf(number);
        }
    }

}
