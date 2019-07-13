package com.chitradip.excercises.expression;

import com.chitradip.excercises.expression.tokenizer.Operator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

abstract class ExpressionEvaluatorTest {

    protected ExpressionEvaluator expressionEvaluator;
    private Random random = new Random();

    @Test
    void integerTest() {
        assertEquals(2.0*3.0+5.0/6.0*3.0+15.0, expressionEvaluator.evaluateExpression("2*3+5/6*3+15"));
    }

    @Test
    void simpleTest() {
        assertEquals(21.24+32*32.32-323.3/23/2, expressionEvaluator.evaluateExpression("21.24+32*32.32-323.3/23/2"));
    }


    @Test
    void emptyTest() {
        assertEquals(0.0, expressionEvaluator.evaluateExpression(""));
    }
    @Test
    void single() {
        assertEquals(3.0, expressionEvaluator.evaluateExpression("3"));
    }

    @RepeatedTest(100)
    void randomTest() {

        StringBuilder stringBuilder = new StringBuilder();

        for ( int i = 0; i < 24; i++ ) {
            double curr = random.nextDouble() * 100;
            stringBuilder.append(curr);
            Operator operator = Operator.values()[random.nextInt(4)];
            stringBuilder.append(operator.toRepresentation());
        }
        stringBuilder.append(random.nextDouble() * 100);
        System.out.println(stringBuilder.toString());
        System.out.println(expressionEvaluator.evaluateExpression(stringBuilder.toString()));
        assertDoesNotThrow(() -> expressionEvaluator.evaluateExpression(stringBuilder.toString()));
    }
}