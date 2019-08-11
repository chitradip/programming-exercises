package com.chitradip.excercises.sumswap;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumSwapTest {

    private SumSwap sumSwap = new SumSwap();

    @Test
    public void testArray() {
        List<Integer> a = List.of(4,1,2,1,1,2);
        List<Integer> b = List.of(3,6,3,3);

        sumSwap.printSwapPair(a, b);
    }

}