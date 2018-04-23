package com.zakangroth.rpncalculator;

import java.util.ArrayDeque;

public class RPNCalculatorArrayDeque extends ArrayDeque<Integer> {

    public void push(String operationElement) {
        super.push(Integer.parseInt(operationElement));
    }
}