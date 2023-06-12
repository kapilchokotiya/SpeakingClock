package com.SpeakingClock.Service;

public interface TimeService {
    String getCurrentTimeInWords();
    String convertToWords(String timeInput);
}