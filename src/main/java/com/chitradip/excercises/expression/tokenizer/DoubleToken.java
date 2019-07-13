package com.chitradip.excercises.expression.tokenizer;

public class DoubleToken extends NumericToken {

    private final Double value;

    private DoubleToken(Double value) {
        this.value = value;
    }

    public static DoubleToken fromString(String number) {
       return new DoubleToken(Double.valueOf(number));
    }
    public static DoubleToken fromDouble(double number) {
        return new DoubleToken(number);
    }
    @Override
    public Double getValue() {
        return value;
    }
}
