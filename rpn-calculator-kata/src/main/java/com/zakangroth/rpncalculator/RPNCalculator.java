package com.zakangroth.rpncalculator;

import java.util.Arrays;
import java.util.Deque;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * A RPN expression (or a postfix expression) is one of the following:
 * a number X, in which case the value of the expression is that of X;
 * a sequence of the form E1 E2 O, where E1 and E2 are postfix expressions and O is an arithmetic operation;
 * in this case, the value of the expression is that of E1 O E2
 * <p>
 * <p>
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
        ADD("+", (deque) -> {
            int i1 = deque.poll();
            int i2 = deque.poll();
            deque.push(i1 + i2);
        }),
        SUB("-", (deque) -> {
            int i1 = deque.poll();
            int i2 = deque.poll();
            deque.push(i2 - i1);
        }),
        DIV("/", (deque) -> {
            int i1 = deque.poll();
            int i2 = deque.poll();
            deque.push(i2 / i1);
        }),
        MULT("*", (deque) -> {
            int i1 = deque.poll();
            int i2 = deque.poll();
            deque.push(i1 * i2);
        }),
        SQRT("SQRT", (deque) -> {
            int i = deque.poll();
            deque.push((int) Math.sqrt(i));
        }),
        MAX("MAX", (deque) -> {
            int max = deque.stream().mapToInt(Integer::intValue).max().getAsInt();
            deque.push(max);
        });

        private final String symbol;
        private final Consumer<Deque<Integer>> operator;

        Operator(String symbol, Consumer<Deque<Integer>> operator) {
            this.symbol = symbol;
            this.operator = operator;
        }

        public void convert(Deque<Integer> deque) {
            operator.accept(deque);
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

    public int convert(String inputChain) {
        RPNCalculatorArrayDeque deque = new RPNCalculatorArrayDeque();

        Pattern.compile(" ").splitAsStream(inputChain)
                .forEach(
                        input -> {
                            if (Operator.isOperator(input)) {
                                Operator.of(input).convert(deque);
                            } else {
                                deque.push(input);
                            }
                        }
                );

        return deque.poll();
    }
}
