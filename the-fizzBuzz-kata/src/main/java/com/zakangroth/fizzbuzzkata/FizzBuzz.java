package com.zakangroth.fizzbuzzkata;

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
