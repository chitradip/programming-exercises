package com.chitradip.excercises.pairswithsum;

import java.util.Objects;

public class OrderedPair<T extends Comparable<T>> {

    final private T first;
    final private T second;


    public OrderedPair(T first, T second) {

        T min, max;
        if ( first.compareTo(second) > 0 ) {
            max = first;
            min = second;
        } else {
            max = second;
            min = first;
        }
        this.first = min;
        this.second = max;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderedPair)) return false;
        OrderedPair<?> that = (OrderedPair<?>) o;
        return Objects.equals(first, that.first) &&
                Objects.equals(second, that.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
