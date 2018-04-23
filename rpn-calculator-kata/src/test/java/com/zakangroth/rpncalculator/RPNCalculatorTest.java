package com.zakangroth.rpncalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RPNCalculatorTest {

    @Test
    public void should_return_1_for_input_1() {

        RPNCalculator calculator = new RPNCalculator();
        String input = "1";
        int expectedOutput = 1;
        
        int output = calculator.convert(input);

        assertEquals(expectedOutput, output);
    }
    

    @Test
    public void should_return_3_for_input_1_2_ADD() {
        
        RPNCalculator calculator = new RPNCalculator();
        String input = "1 2 +";
        int expectedOutput = 3;
        
        int output = calculator.convert(input);
        
        assertEquals(expectedOutput, output);
    }


    @Test
    public void should_return_4_for_input_20_5_DIV() {


        RPNCalculator calculator = new RPNCalculator();
        String input = "20 5 /";
        int expectedOutput = 4;

        int output = calculator.convert(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_3_for_input_4_2_ADD_3_SUB() {

        RPNCalculator calculator = new RPNCalculator();
        String input = "4 2 + 3 -";
        int expectedOutput = 3;

        int output = calculator.convert(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_141_for_input_3_5_8_MULT_7_ADD_MULT() {

        RPNCalculator calculator = new RPNCalculator();
        String input = "3 5 8 * 7 + *";
        int expectedOutput = 141;

        int output = calculator.convert(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_3_for_input_9_SQRT() {

        RPNCalculator calculator = new RPNCalculator();
        String input = "9 SQRT";
        int expectedOutput = 3;

        int output = calculator.convert(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_8_for_input_5_8_1_4_2_MAX() {

        RPNCalculator calculator = new RPNCalculator();
        String input = "5 8 1 4 2 MAX";
        int expectedOutput = 8;

        int output = calculator.convert(input);

        assertEquals(expectedOutput, output);
    }
}