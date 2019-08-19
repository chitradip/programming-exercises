package com.chitradip.excercises.powersOfPrimes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PowersOfPrimesTest {

    @Test
    public void basicTest() {
        PrimeNumberProvider primes = new PrimeNumberProvider();
        List<Integer> hundred = new PowersOfPrimes().sortedPowers(150);

        List<Integer> sortedHundred = new ArrayList<>(hundred);
        sortedHundred.sort(Integer::compareTo);
        assertEquals(hundred, sortedHundred);

        assertEquals(Arrays.asList(2,3, 4, 5, 7,8,9,11,13,16), hundred.subList(0, 10));
    }

}