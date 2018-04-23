package com.zakangroth.fizzbuzzkata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void should_return_nothing_when_called_with_1() {

        FizzBuzz fizzBuzz = new FizzBuzz();

        int input = 1;
        String expectedOutput = "";

        String output = fizzBuzz.fizzBuzz(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_fizz_when_called_with_3() {

        FizzBuzz fizzBuzz = new FizzBuzz();

        int input = 3;
        String expectedOutput = "Fizz";

        String output = fizzBuzz.fizzBuzz(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_buzz_when_called_with_5() {

        FizzBuzz fizzBuzz = new FizzBuzz();

        int input = 5;
        String expectedOutput = "Buzz";

        String output = fizzBuzz.fizzBuzz(input);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_return_fizzbuzz_when_called_with_15() {

        FizzBuzz fizzBuzz = new FizzBuzz();

        int input = 15;
        String expectedOutput = "FizzBuzz";

        String output = fizzBuzz.fizzBuzz(input);

        assertEquals(expectedOutput, output);
    }
}
