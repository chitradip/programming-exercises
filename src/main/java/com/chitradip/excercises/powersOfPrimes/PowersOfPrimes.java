package com.chitradip.excercises.powersOfPrimes;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PowersOfPrimes {

    PrimeNumberProvider primeNumberProvider = new PrimeNumberProvider();

    public List<Integer> sortedPowers(int n) {

        List<Integer> retVal = new ArrayList<>();
        PriorityQueue<PrimeNumberWithExponent> pq = new PriorityQueue<>();

        int currIdx = 0;

//        primeNumberProvider.getNthPrime(0);
//        lastUsed.put( primeNumberProvider.getNthPrime(0),  primeNumberProvider.getNthPrime(0));


        while ( n-- > 0 ){

            //Add new primes if necessary
            if ( pq.isEmpty() ||  pq.peek().num > primeNumberProvider.getNthPrime(currIdx) ) {
                pq.offer( PrimeNumberWithExponent.baseNumber(primeNumberProvider.getNthPrime(currIdx++)));
            }

            PrimeNumberWithExponent next = pq.poll();
            retVal.add(next.num);
            pq.offer(next.nextNumber());
        }
        return retVal;
    }

    private static class PrimeNumberWithExponent implements Comparable<PrimeNumberWithExponent> {
        final int basePrime;
        final int num;

        public static PrimeNumberWithExponent baseNumber(int num) {
            return new PrimeNumberWithExponent(num, num);
        }

        private PrimeNumberWithExponent(int basePrime, int num) {
            this.basePrime = basePrime;
            this.num = num;
        }

        @Override
        public int compareTo(PrimeNumberWithExponent primeNumberWithExponent) {
            return Integer.compare(this.num, primeNumberWithExponent.num);
        }

        public   PrimeNumberWithExponent nextNumber() {
            return new PrimeNumberWithExponent(basePrime, num * basePrime);
        }
    }



}
