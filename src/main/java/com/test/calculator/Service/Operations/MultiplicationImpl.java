package com.test.calculator.Service.Operations;

import org.springframework.stereotype.Component;

@Component
public class MultiplicationImpl implements Operation {

    @Override
    public double apply(double a, double b) {
        return a*b;
    }

    @Override
    public boolean isValid(char a) {
        return '*'==a;
    }
}
