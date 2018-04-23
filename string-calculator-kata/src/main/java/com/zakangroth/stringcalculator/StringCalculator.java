package com.zakangroth.stringcalculator;

import java.util.regex.Pattern;

/**
 * Multiple calculations bases on String typed inputs.
 * 1. Create add() method
 * 2. Allow add() to handle unknown amount of numbers
 * 3. Allow the add() method to handle new lines between numbers instead of commas.
 * 4. Support different delimiters.
 * 5. Calling add() with a negative number will throw an exception negatives not allowed
 * 6. Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
 */
public class StringCalculator {

    /**
     * The method can take 0, 1 or 2 numbers, and will return their sum.
     * For an empty string it will return 0.
     * Example ` ` or 1 or 1,2.
     * @param input
     * @return
     */
    public int add(String input) {

        if(input.isEmpty()){
            return 0;
        }

        return Pattern.compile(",").splitAsStream(input).mapToInt(Integer::parseInt).sum();    }
}
