package com.zakangroth.rpncalculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.regex.Pattern;

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

    private enum Operator {
        ADD("+", (i1, i2) -> i1 + i2),
        SUB("-", (i1, i2) -> i2 - i1),
        DIV("/", (i1, i2) -> i2 / i1),
        MULT("*", (i1, i2) -> i1 * i2);

        private final String symbol;
        private final IntBinaryOperator operator;

        Operator(String symbol, IntBinaryOperator operator) {
            this.symbol = symbol;
            this.operator = operator;
        }

        public int convert(int i1, int i2) {
            return operator.applyAsInt(i1, i2);
        }

        public static Operator of(String operationElement) {
            Optional<Operator> operator = findOperatorBySymbol(operationElement);
            return operator.orElse(null);
        }

        public static boolean isOperator(String operationElement) {
            Optional<Operator> operator = findOperatorBySymbol(operationElement);
            return operator.isPresent();
        }

        private static Optional<Operator> findOperatorBySymbol(String operationElement) {
            return Arrays.stream(values()).filter(op -> op.symbol.equals(operationElement)).findAny();
        }
    }

    public int convert(String input) {
        RPNCalculatorArrayDeque deque = new RPNCalculatorArrayDeque();

        Pattern.compile(" ").splitAsStream(input)
                .forEach(
                        operationElement -> {
                            if (Operator.isOperator(operationElement)) {
                                int leftOperand = deque.poll();
                                int rightOperand = deque.poll();
                                int result = Operator.of(operationElement).convert(leftOperand, rightOperand);
                                deque.push(result);
                            } else {
                                deque.push(operationElement);
                            }
                        }
                );

        return deque.poll();
    }
}
