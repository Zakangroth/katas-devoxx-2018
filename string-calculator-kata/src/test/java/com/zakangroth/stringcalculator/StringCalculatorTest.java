package com.zakangroth.stringcalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void should_return_0_for_empty_input() {

        StringCalculator calculator = new StringCalculator();
        String input = "";
        int expectedOutput = 0;

        int output = calculator.add(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_1_for_input_1() {

        StringCalculator calculator = new StringCalculator();
        String input = "1";
        int expectedOutput = 1;

        int output = calculator.add(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_6_for_input_1_comma_2_comma_3() {

        StringCalculator calculator = new StringCalculator();
        String input = "1,2,3";
        int expectedOutput = 6;

        int output = calculator.add(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_7_for_an_input_of_6_newline_1() {

        StringCalculator calculator = new StringCalculator();
        String input = "6\n1";
        int expectedOutput = 7;

        int output = calculator.add(input);

        assertEquals(expectedOutput, output);
    }
}
