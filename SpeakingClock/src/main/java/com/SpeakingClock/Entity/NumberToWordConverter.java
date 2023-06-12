package com.SpeakingClock.Entity;

public class NumberToWordConverter {
    private static final String[] units = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String convertToWord(int number) {
        if (number < 0 || number > 999) {
            throw new IllegalArgumentException("Number out of range");
        }

        if (number < 20) {
            return units[number];
        }

        if (number < 100) {
            return tens[number / 10] + " " + units[number % 10];
        }

        return units[number / 100] + " hundred " + convertToWord(number % 100);
    }
}
