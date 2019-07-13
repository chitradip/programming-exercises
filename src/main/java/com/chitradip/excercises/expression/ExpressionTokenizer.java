package com.chitradip.excercises.expression;

import com.chitradip.excercises.expression.tokenizer.DoubleToken;
import com.chitradip.excercises.expression.tokenizer.ExpressionToken;
import com.chitradip.excercises.expression.tokenizer.Operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpressionTokenizer {


    List<ExpressionToken> tokenList(String expression) {

        int startToken = 0;

        List<ExpressionToken> expressionTokens = new ArrayList<>();

        if ( startToken >= expression.length()) {
            return Collections.emptyList();
        }

        TokenWithPosition numberToken = nextNumericToken(expression, startToken);
        expressionTokens.add(numberToken.token);
        while ( numberToken.nextPosition < expression.length()) {
            TokenWithPosition opToken = nextOperatorToken(expression, numberToken.nextPosition);
            expressionTokens.add(opToken.token);
            if ( opToken.nextPosition >= expression.length()) {
                throw new IllegalArgumentException("Unreadable expression");
            } else {
                numberToken = nextNumericToken(expression, opToken.nextPosition);
                expressionTokens.add(numberToken.token);
            }
        }


        return expressionTokens;
    }

    private TokenWithPosition nextNumericToken(String expression, int startToken) {

        NumberPart numberPart = NumberPart.PRE_DECIMAL;
        int currToken = startToken;

        while (currToken < expression.length() &&
                (isNumeric(expression.charAt(currToken)) || expression.charAt(currToken) == '.') ) {
            if ( numberPart == NumberPart.PRE_DECIMAL &&
                    isNumeric(expression.charAt(currToken)) ) {
                currToken++;
            } else if ( numberPart == NumberPart.PRE_DECIMAL &&
                    expression.charAt(currToken) == '.') {
                currToken++;
                numberPart = NumberPart.POST_DECIMAL;
            } else if ( numberPart == NumberPart.POST_DECIMAL && isNumeric(expression.charAt(currToken)) ) {
                currToken++;
            } else {
                throw new IllegalStateException("Unrecognizable number");
            }
        }

        return new TokenWithPosition(currToken, DoubleToken.fromString(expression.substring(startToken, currToken)));


    }

    private TokenWithPosition nextOperatorToken(String expression, int startToken) {

        int currToken = startToken ;

        while (currToken < expression.length() &&
                (Operator.isOperatorPrefix(expression.substring(startToken, currToken+1)) )) {
            currToken++;
        }

        if ( Operator.isOperator(expression.substring(startToken, currToken)) ) {
            return new TokenWithPosition( currToken, Operator.fromRepresentation(expression.substring(startToken, currToken)));
        } else {
            throw new IllegalStateException("Unrecognizable operator");

        }



    }

    private boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    private enum NumberPart {
        PRE_DECIMAL,
        POST_DECIMAL
    }

    private static class TokenWithPosition {

        final int nextPosition;
        final ExpressionToken token;


        private TokenWithPosition(int nextPosition, ExpressionToken token) {
            this.nextPosition = nextPosition;
            this.token = token;
        }
    }

}
