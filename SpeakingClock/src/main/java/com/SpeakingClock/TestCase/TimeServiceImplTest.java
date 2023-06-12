package com.SpeakingClock.TestCase;



import com.SpeakingClock.Service.TimeServiceImpl;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;


class TimeServiceImplTest {

    @Test
    void getCurrentTimeInWords_ShouldReturnCurrentTimeInWords() {
        // Arrange
        TimeServiceImpl timeService = new TimeServiceImpl();

        // Act
        String result = timeService.getCurrentTimeInWords();

        // Assert
        System.out.println("Current Time in Words: " + result);
    }

    @Test
    void convertToWords_ShouldReturnTimeInWords() {
        // Arrange
        TimeServiceImpl timeService = new TimeServiceImpl();
        LocalTime time = LocalTime.of(8, 34);
        String expected = "eight thirty four";

        // Act
        String result = timeService.convertToWords(String.valueOf(time));

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void convertToWords_ShouldReturnMiddayForNoon() {
        // Arrange
        TimeServiceImpl timeService = new TimeServiceImpl();
        String time = String.valueOf(LocalTime.NOON);
        String expected = "It's Midday";

        // Act
        String result = timeService.convertToWords(time);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void convertToWords_ShouldReturnMidnightForMidnight() {
        // Arrange
        TimeServiceImpl timeService = new TimeServiceImpl();
        LocalTime time = LocalTime.MIDNIGHT;
        String expected = "It's Midnight";

        // Act
        String result = timeService.convertToWords(String.valueOf(time));

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void convertToWords_ShouldReturnInvalidTimeFormatForInvalidTimeInput() {
        // Arrange
        TimeServiceImpl timeService = new TimeServiceImpl();
        String timeInput = "abc";
        String expected = "Invalid time format. Please provide the time in HH:mm format.";

        // Act
        String result = timeService.convertToWords(timeInput);

        // Assert
        assertEquals(expected, result);
    }
}
