package com.chitradip.excercises.expression.tokenizer;

import java.util.Arrays;
import java.util.Comparator;

public enum  Operator implements ExpressionToken {

    PLUS("+", 500),
    MINUS("-", 500),
    MULT("*", 1000),
    DIV("/", 1000);

    private String value;
    private int priority;

    Operator(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }



    public static boolean isOperator(String value) {
        return Arrays.stream(Operator.values()).anyMatch( x -> x.value.equals(value));
    }

    public static boolean isOperatorPrefix(String value) {
        return Arrays.stream(Operator.values()).anyMatch( x -> x.value.startsWith(value));
    }

    public  static Operator fromRepresentation(String value) {

        //TODO make a static hashmap if there more expressions in future
        for ( Operator op : Operator.values()) {
            if ( op.value.equals(value)) {
                return op;
            }
        }

        throw new IllegalArgumentException("Unknown operator " + value );

    }



    public String toRepresentation() {
        return value;
    }


    private final static PriorityComparator comparator = new PriorityComparator();

    public static Comparator<Operator> comparator() {
        return comparator;
    }

    public static class PriorityComparator implements Comparator<Operator> {

        @Override
        public int compare(Operator operator, Operator t1) {
            return Integer.compare(operator.priority, t1.priority);
        }
    }

}
