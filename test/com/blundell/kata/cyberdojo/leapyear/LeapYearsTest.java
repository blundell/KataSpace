package com.blundell.kata.cyberdojo.leapyear;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapYearsTest {

    @Test
    public void yearNotDivisibleByFour_returnsCommonYear() {
        int year = 1995;

        boolean isLeapYear = LeapYears.isLeapYear(year);

        assertFalse(isLeapYear);
    }

    @Test
    public void yearDivisibleByFourButNotBy100_returnsLeapYear() {
        int year = 1996;

        boolean isLeapYear = LeapYears.isLeapYear(year);

        assertTrue(isLeapYear);
    }

    @Test
    public void yearDivisibleByFourAndDivisibleBy100ButNotDivisibleBy400_returnsCommonYear() {
        int year = 1900;

        boolean isLeapYear = LeapYears.isLeapYear(year);

        assertFalse(isLeapYear);
    }

    @Test
    public void yearDivisibleByFourAndDivisibleBy100AndDivisibleBy400_returnsLeapYear() {
        int year = 2000;

        boolean isLeapYear = LeapYears.isLeapYear(year);

        assertTrue(isLeapYear);
    }

}
