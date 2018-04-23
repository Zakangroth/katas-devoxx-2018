package com.zakangroth.fizzbuzzkata;

/**
 * This class is intended to return :
 * Fizz for numbers divisible by 3
 * Buzz for numbers divisible by 5
 * FizzBuzz for numbers divisible by 3 and 5
 */
public class FizzBuzz {

    public String fizzBuzz(int input) {
        StringBuilder stringBuilder = new StringBuilder();

        if (isDivisibleBy3(input)){
            stringBuilder.append("Fizz");
        }

        if (isDivisibleBy5(input)){
            stringBuilder.append("Buzz");
        }

        return stringBuilder.toString();
    }

    private boolean isDivisibleBy3(int input){
        return (input % 3) == 0;
    }

    private boolean isDivisibleBy5(int input){
        return (input % 5) == 0;
    }
}
