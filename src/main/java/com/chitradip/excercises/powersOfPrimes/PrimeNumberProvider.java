package com.chitradip.excercises.powersOfPrimes;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumberProvider {

    List<Integer> primes;
    public PrimeNumberProvider() {
        File file = new File("src/test/resources/primes/primes.0.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.lines().collect(Collectors.joining(","));
            primes = Arrays.stream(line.split(","))
                    .map(String::trim)
                    .map(Integer::valueOf).collect(Collectors.toList());

        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    public int getNthPrime(int n) {
        return primes.get(n);
    }

}
