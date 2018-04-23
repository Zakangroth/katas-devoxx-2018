package com.zakangroth.stringcalculator;

import java.util.OptionalInt;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Multiple calculations bases on String typed inputs.
 * 1. Create add() method. The method can take 0, 1 or 2 numbers, and will return their sum. Empty returns 0.
 * 2. Allow add() to handle unknown amount of numbers
 * 3. Allow the add() method to handle new lines between numbers instead of commas.
 * 4. Support different delimiters. Example : //[delimiter]\n[numbers…]
 * 5. Calling add() with a negative number will throw an exception negatives not allowed
 * 6. Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
 */
public class StringCalculator {

    private static final String SEPARATOR = "[,\n]";

    public int add(String input) {

        if(input.isEmpty()){
            return 0;
        }

        if(input.startsWith("//")){
            String separator = input.substring(2,3);
            String values = input.substring(4);
            return add(values, separator);
        }

        return add(input, SEPARATOR);
    }

    private int add(String values, String separator){

        Supplier<Stream<String>> streamSupplier = () -> Pattern.compile(separator).splitAsStream(values);
        OptionalInt result = streamSupplier.get().mapToInt(Integer::parseInt).filter(num -> num < 0).findAny();

        if(result.isPresent()){
            throw new NumberFormatException("negatives not allowed");
        }

        return streamSupplier.get().mapToInt(Integer::parseInt).filter(num -> num < 1000).sum();
    }
}
