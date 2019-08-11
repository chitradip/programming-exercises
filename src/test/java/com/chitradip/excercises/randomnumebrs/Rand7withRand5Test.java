package com.chitradip.excercises.randomnumebrs;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Rand7withRand5Test {

    @Test
    void rand7() {

       Rand7withRand5 rand7withRand5 = new Rand7withRand5(new Rand5());

        Map<Integer, Integer> count = new HashMap<>();

       for ( int i =0 ; i < 1000000; i++) {
           count.compute(rand7withRand5.rand7(), (k,v) -> {
               if ( v == null ) {
                   return 1;
               } else {
                   return v + 1;
               }
           });
       }

       for ( int i = 0; i < 7; i++) {
           assertTrue( count.get(i) > 140000 && count.get(i) < 145000) ;
       }
    }
}