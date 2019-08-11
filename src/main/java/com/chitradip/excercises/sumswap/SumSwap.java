package com.chitradip.excercises.sumswap;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SumSwap {



    SumSwap() {


    }

    public  void printSwapPair(List<Integer> a, List<Integer> b) {
        Integer suma = a.stream().mapToInt(x -> x).sum();
        Integer sumb = b.stream().mapToInt(x -> x).sum();

        int diff = suma - sumb;

        List<Integer> a1 = a.stream().sorted().collect(Collectors.toList());
        List<Integer> b1 = b.stream().sorted().collect(Collectors.toList());

        int i = 0;
        int j = 0;

        while ( i < a1.size() && j < b1.size()) {
            int currDiff = 2*(a1.get(i) - b1.get(j));
            if ( currDiff == diff) {
                System.out.println(" " + a1.get(i) + " " + b1.get(j));
                break;
            } else if ( currDiff < diff) {
                j++;
            } else  {
                i++;
            }
        }

    }

}
