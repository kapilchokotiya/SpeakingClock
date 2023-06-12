package com.SpeakingClock.Service;

import com.SpeakingClock.Entity.NumberToWordConverter;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

@Service
public class TimeServiceImpl implements TimeService {
    @Override
    public String getCurrentTimeInWords() {
        LocalTime currentTime = LocalTime.now();
        return convertToWords(currentTime);
    }

    @Override
    public String convertToWords(String timeInput) {
        try {
            LocalTime time = LocalTime.parse(timeInput);
            return convertToWords(time);
        } catch (DateTimeParseException e) {
            return "Invalid time format. Please provide the time in HH:mm format.";
        }
    }

    private String convertToWords(LocalTime time) {
        if (time.equals(LocalTime.NOON)) {
            return "It's Midday";
        } else if (time.equals(LocalTime.MIDNIGHT)) {
            return "It's Midnight";
        }

        int hour = time.getHour();
        int minute = time.getMinute();

        String hourInWords = NumberToWordConverter.convertToWord(hour);
        String minuteInWords = NumberToWordConverter.convertToWord(minute);

        String timeInWords = " " + hourInWords + " " + minuteInWords;

        return timeInWords;
    }

}