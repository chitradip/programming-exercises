package com.chitradip.excercises.expression;

import com.chitradip.excercises.expression.tokenizer.ExpressionToken;
import com.chitradip.excercises.expression.tokenizer.NumericToken;
import com.chitradip.excercises.expression.tokenizer.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    First move to postfix
 */
public class PostFixEvaluator implements ExpressionEvaluator {
    private ExpressionTokenizer expressionTokenizer = new ExpressionTokenizer();

    @Override
    public Double evaluateExpression(String expression) {

        List<ExpressionToken> tokens = expressionTokenizer.tokenList(expression);

        if ( tokens.size() == 0) {
            return 0.0;
        }

        var postFixEncoding = toPostFix(tokens);

        var postFixEvalStack = new Stack<NumericToken>();

        for ( ExpressionToken token : postFixEncoding) {
            if ( token instanceof NumericToken) {
                postFixEvalStack.push((NumericToken) token);
            } else if ( token instanceof Operator) {
                NumericToken number2 = postFixEvalStack.pop();
                NumericToken number1 = postFixEvalStack.pop();

                //Apply the operator on the last 2 numbers.
                postFixEvalStack.push(DoubleComputer.compute((Operator) token, number1, number2));

            }
        }

        if ( postFixEvalStack.size() !=  1 ) {
            throw new IllegalStateException("Invalid postfix expression");
        }

        return postFixEvalStack.pop().getValue().doubleValue();
    }


    /*

     */
    private List<ExpressionToken> toPostFix(List<ExpressionToken> tokens) {
        var priorityComparator = Operator.comparator();

        var postFixEncoding = new ArrayList<ExpressionToken>();
        var stack = new Stack<Operator>();

        for ( ExpressionToken token : tokens) {
            //To convert to sealed type in java 13
            if ( token instanceof NumericToken) {
                postFixEncoding.add(token);
            } else if ( token instanceof Operator) {
                //If the has higher priority items, append them
                while ( !(stack.isEmpty() || priorityComparator.compare(stack.peek(), (Operator) token) < 0 )) {
                    postFixEncoding.add(stack.pop());
                }
                stack.push((Operator) token);
            } else {
                throw new IllegalStateException("Should not happen");
            }
        }

        while(!stack.isEmpty()) {
            postFixEncoding.add(stack.pop());
        }

        return postFixEncoding;
    }
}
