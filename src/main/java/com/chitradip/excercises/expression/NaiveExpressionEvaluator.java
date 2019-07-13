package com.chitradip.excercises.expression;

import com.chitradip.excercises.expression.tokenizer.DoubleToken;
import com.chitradip.excercises.expression.tokenizer.ExpressionToken;
import com.chitradip.excercises.expression.tokenizer.NumericToken;
import com.chitradip.excercises.expression.tokenizer.Operator;

import java.util.ArrayList;
import java.util.List;

public class NaiveExpressionEvaluator implements ExpressionEvaluator {


    private ExpressionTokenizer expressionTokenizer = new ExpressionTokenizer();
    @Override
    public Number evaluateExpression(String expression) {

        List<ExpressionToken> expressionList = expressionTokenizer.tokenList(expression);

        var list = new ArrayList<ExpressionToken>();

        //First resolve the "/" and "*".
        /*
            In the list, there is alternating numbes and operands.
            We go through the list. We output the numbers and operands as is except in the case of * and /
            for * and /, we take the last output number and multipy or divide by the next number.
            We replace the last number with the result.

            For example, 2+3+4*5+2,
            We will output 2+3+4. When we encounter *, we will take "4" and multiply with 5 to get 20.
            We will replace the last number (4) with 20 to get
            2+3+20

            This gets rid of / and * and leaves us with + and -.

         */

        for ( int pos = 0; pos < expressionList.size(); pos++) {
            if ( pos % 2 == 0) {
                list.add(expressionList.get(pos));
            } else {
                Operator operator = (Operator) expressionList.get(pos);
                if ( operator == Operator.MULT  || Operator.DIV == operator) {
                    list.set(list.size()-1, DoubleComputer.compute(operator, list.get(list.size()-1), expressionList.get(pos+1)));
                    pos++;
                } else {
                    list.add(expressionList.get(pos));
                }
            }
        }


        //Now we should only have + and - left.
        /*
            Here we take each number from left to right and + or - the next number.
         */
        double finalValue = 0.0;
        Operator currOperator = Operator.PLUS;
        for ( int pos = 0; pos < list.size(); pos++) {
            if ( pos % 2 == 0) {
                finalValue = DoubleComputer.compute(currOperator, finalValue, ((NumericToken)list.get(pos)).getValue().doubleValue());
            } else {
                currOperator = (Operator) list.get(pos);
            }
        }


        return finalValue;
    }


}


