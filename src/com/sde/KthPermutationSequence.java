package com.sde;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/permutation-sequence/description/
 * Level: HARD
 */
public class KthPermutationSequence {

    public String getPermutation(int n , int k) {

        int factorial = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            factorial *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k - 1;
        String result = "";
        while(true) {
            result = result + numbers.get(k / factorial);
            numbers.remove(k / factorial);
            if(numbers.size() == 0) {
                break;
            }
            k = k % factorial;
            factorial = factorial / numbers.size();
        }

        return result;
    }

    public static void main(String[] args) {
        KthPermutationSequence kps = new KthPermutationSequence();
        String output = kps.getPermutation(3, 3);
        System.out.println("Kth permutation sequence output >> " + output);
    }
}
