package com.zakangroth.leapyearkata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeapYearTest {

    @Test
    public void should_return_false_when_called_with_1900(){

        LeapYear leapYear = new LeapYear();

        int input = 1900;
        boolean expectedOutput = false;

        boolean output = leapYear.isLeapYear(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_false_when_called_with_2001(){

        LeapYear leapYear = new LeapYear();

        int input = 2001;
        boolean expectedOutput = false;

        boolean output = leapYear.isLeapYear(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_true_when_called_with_1996(){

        LeapYear leapYear = new LeapYear();

        int input = 1996;
        boolean expectedOutput = true;

        boolean output = leapYear.isLeapYear(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_true_when_called_with_2000(){

        LeapYear leapYear = new LeapYear();

        int input = 2000;
        boolean expectedOutput = true;

        boolean output = leapYear.isLeapYear(input);

        assertEquals(expectedOutput, output);
    }

}
