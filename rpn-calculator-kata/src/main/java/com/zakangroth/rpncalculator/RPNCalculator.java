package com.zakangroth.rpncalculator;

/**
 * A RPN expression (or a postfix expression) is one of the following:
 * a number X, in which case the value of the expression is that of X;
 * a sequence of the form E1 E2 O, where E1 and E2 are postfix expressions and O is an arithmetic operation;
 * in this case, the value of the expression is that of E1 O E2
 *
 *
 * Examples :
 * 1 => 1
 * 1 2 + => (1 + 2) = 3
 * 20 5 / => (20 / 5) = 4
 * 4 2 + 3 - => (4 + 2) - 3 = 3
 * 3 5 8 * 7 + * => 3*((5*8) + 7) = 141
 * 9 SQRT => 3
 * 5 8 1 4 2 MAX => 8
 */
public class RPNCalculator {

    public int convert(String input) {
        return 0;
    }

}
