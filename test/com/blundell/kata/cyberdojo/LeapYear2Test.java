package com.blundell.kata.cyberdojo;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapYear2Test {

    @Test
    public void testIfNotDivisibleByFourReturnCommonYear() throws Exception {
        boolean leapYear = isLeapYear(1995);

        assertFalse(leapYear);
    }

    @Test
    public void testIfDivisibleByFourButNotBy100ReturnLeapYear() throws Exception {
        boolean leapYear = isLeapYear(1996);

        assertTrue(leapYear);
    }

    @Test
    public void testIfDivisibleByFourAndBy100ReturnCommonYear() throws Exception {

        boolean leapYear = isLeapYear(1900);

        assertFalse(leapYear);
    }

    @Test
    public void testIfDivisibleByFourAndBy100AndAlsoBy400ReturnLeapYear() throws Exception {

        boolean leapYear = isLeapYear(2000);

        assertTrue(leapYear);
    }

    public boolean isLeapYear(int year) {
        if (year % 4 != 0)
            return false;
        else if (year % 100 != 0)
            return true;
        else if (year % 400 == 0)
            return true;
        return false;
    }
}
