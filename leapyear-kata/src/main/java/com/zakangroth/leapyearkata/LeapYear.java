package com.zakangroth.leapyearkata;

/**
 * This class returns true if the provided year is a leap year. Otherwise : false.
 * A leap year is :
 * divisible by 4
 * but is not otherwise divisible by 100 unless it is also divisible by 400.
 *
 *
 * For example :
 * 2001 is a typical common year
 * 1900 is an atypical common year
 * 1996 is a typical leap year
 * 2000 is an atypical leap year.
 */
public class LeapYear {

    public boolean isLeapYear(int year) {
        return isTypicalLeapYear(year) && (!isAnAtypicalCommonYear(year) || isAnAtypicalLeapYear(year));
    }

    private static boolean isTypicalLeapYear(int year) {
        return (year % 4) == 0;
    }

    private boolean isAnAtypicalCommonYear(int year) {
        return (year % 100) == 0;
    }

    private boolean isAnAtypicalLeapYear(int year) {
        return (year % 400) == 0;
    }

}
