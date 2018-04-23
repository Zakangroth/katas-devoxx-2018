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

    @Test
    public void should_return_4_for_an_input_of_2_custom_separator_2_and_custom_separator_is_w() {

        StringCalculator calculator = new StringCalculator();
        String input = "//w\n2w2";
        int expectedOutput = 4;

        int output = calculator.add(input);

        assertEquals(expectedOutput, output);
    }

    @Test(expected = NumberFormatException.class)
    public void should_return_number_format_exception_for_input_minus_5() {

        StringCalculator calculator = new StringCalculator();
        String input = "-5";

        calculator.add(input);
    }

    @Test
    public void should_return_6_for_input_6_comma_1325() {

        StringCalculator calculator = new StringCalculator();
        String input = "6,1325";
        int expectedOutput = 6;

        int output = calculator.add(input);

        assertEquals(expectedOutput, output);
    }
}
