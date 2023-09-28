package com.company;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i <= n; i++) {
            for(int j = 2*i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        SieveOfEratosthenes soe = new SieveOfEratosthenes();
        boolean[] result = soe.sieveOfEratosthenes(20);
        for(int i = 0 ; i < result.length; i++) {
            System.out.println(i + " " + result[i]);
        }
    }
}
