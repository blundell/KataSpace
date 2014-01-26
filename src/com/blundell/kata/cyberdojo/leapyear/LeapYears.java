package com.blundell.kata.cyberdojo.leapyear;

public class LeapYears {

    private static final boolean LEAP_YEAR = true;
    private static final boolean COMMON_YEAR = false;

    public static boolean isLeapYear(int year) {
        if (divisibleByFour(year) && !divisibleBy100(year)) {
            return LEAP_YEAR;
        } else if (divisibleByFour(year) && divisibleBy100(year) && divisibleBy400(year)) {
            return LEAP_YEAR;
        }
        return COMMON_YEAR;
    }

    private static boolean divisibleByFour(int year) {
        return year % 4 == 0;
    }

    private static boolean divisibleBy100(int year) {
        return year % 100 == 0;
    }

    private static boolean divisibleBy400(int year) {
        return year % 400 == 0;
    }
}
