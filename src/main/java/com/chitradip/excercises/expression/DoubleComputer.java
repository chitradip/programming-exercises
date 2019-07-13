package com.chitradip.excercises.expression;

import com.chitradip.excercises.expression.tokenizer.DoubleToken;
import com.chitradip.excercises.expression.tokenizer.ExpressionToken;
import com.chitradip.excercises.expression.tokenizer.NumericToken;
import com.chitradip.excercises.expression.tokenizer.Operator;

public class DoubleComputer {


    public static NumericToken compute(Operator operator, ExpressionToken expressionToken1, ExpressionToken expressionToken2) {
        double number1 = ((NumericToken) expressionToken1).getValue().doubleValue();
        double number2 = ((NumericToken) expressionToken2).getValue().doubleValue();

        return  DoubleToken.fromDouble(compute(operator, number1, number2));
    }

    public static double compute(Operator operator, double number1, double number2) {

        switch (operator) {
            case DIV:
                return
                        number1/number2;
            case MULT:
                return
                        number1*number2;
            case PLUS:
                return
                        number1+number2;
            case MINUS:
                return
                        number1-number2;
        }

        throw new IllegalStateException("Cannot happen");
    }
}
