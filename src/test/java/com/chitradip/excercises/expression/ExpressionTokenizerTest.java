package com.chitradip.excercises.expression;

import com.chitradip.excercises.expression.tokenizer.ExpressionToken;
import com.chitradip.excercises.expression.tokenizer.NumericToken;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTokenizerTest {

    private ExpressionTokenizer expressionTokenizer = new ExpressionTokenizer();

    @Test
    public void emptyTest() {
        List<ExpressionToken> list = expressionTokenizer.tokenList("");

        assertEquals(0, list.size());

    }

    @Test
    public void singleNumber() {
        List<ExpressionToken> list = expressionTokenizer.tokenList("21.23");

        assertEquals(1, list.size());
        assertEquals(21.23, ((NumericToken)list.get(0)).getValue().doubleValue());

    }

    @Test
    public void singleInteger() {
        List<ExpressionToken> list = expressionTokenizer.tokenList("21");

        assertEquals(1, list.size());
        assertEquals(21.0, ((NumericToken)list.get(0)).getValue().doubleValue());

    }

    @Test
    public void simpleExpression() {
        List<ExpressionToken> list = expressionTokenizer.tokenList("21.24+32*32.32-323.3/23/2");
        assertEquals(11, list.size());

    }

    @Test
    public void malformedExpression() {
        assertThrows(IllegalArgumentException.class, () -> expressionTokenizer.tokenList("21+"));
        assertThrows(IllegalArgumentException.class, () -> expressionTokenizer.tokenList("21.24+32*32.32-323.3/23/"));
        assertThrows(IllegalArgumentException.class, () -> expressionTokenizer.tokenList("+32*32.32-323.3/23/2"));
        assertThrows(IllegalArgumentException.class, () -> expressionTokenizer.tokenList("21.24+*32.32-323.3/23/2"));
        assertThrows(IllegalArgumentException.class, () -> expressionTokenizer.tokenList("+"));
    }

}