package com.leetcode;

import java.util.List;

/**
 * Find the repeating and misisng numfrom an array of continuos numbers
 * Link: https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 */
public class RepeatMissingNumber {

    public List<Integer> findNumber(List<Integer> numbers) {
        int n = numbers.size();

        // find S - Sn
        long sn = (n * (n + 1)) / 2;

        // find S2 - S2N
        long s2n = (n * (n + 1) * (2 * n + 1)) / 6;
        long s = 0, s2 = 0;
        for (Integer number : numbers) {
            s += (long) number;
            s2 += (long) number * (long) number;
        }

        long eq1 = s - sn;
        long eq2 = s2 - s2n;
        eq2 = eq2 / eq1;
        long x = (eq1 + eq2) / 2;
        long y = x - eq1;
        return List.of((int)x, (int)y);
    }
    public static void main(String[] args) {
        RepeatMissingNumber rmn = new RepeatMissingNumber();
        List<Integer> result = rmn.findNumber(List.of(1, 2, 3, 3));
        System.out.println(result.toString());
    }
}
