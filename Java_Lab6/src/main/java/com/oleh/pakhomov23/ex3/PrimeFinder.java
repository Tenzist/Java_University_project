package com.oleh.pakhomov23.ex3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PrimeFinder {
    public List<Integer> getAllPrimes(int from, int to) {
        List<Integer> primes = IntStream.range(from, to + 1)
                .filter(PrimeFinder::isPrime)
                .boxed()
                .collect(Collectors.toList());
        return primes;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        return IntStream.rangeClosed(2, n / 2).noneMatch(i -> n % i == 0);
    }
}
