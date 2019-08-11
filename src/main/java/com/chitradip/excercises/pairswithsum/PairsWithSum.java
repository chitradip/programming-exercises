package com.chitradip.excercises.pairswithsum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PairsWithSum {

    public PairsWithSum() {

    }


    public List<OrderedPair<Integer>> pairsToSum(List<Integer> numbers, int sumTo) {

        var retList = new ArrayList<OrderedPair<Integer>>();

        var partialSums = new HashSet<Integer>();

        for ( Integer number : numbers ) {
            int rest = sumTo - number;
            if ( partialSums.contains(number) ) {
                retList.add(new OrderedPair<>(number, rest));
            } else {
                partialSums.add(rest);
            }
        }

        return retList;

    }



}
