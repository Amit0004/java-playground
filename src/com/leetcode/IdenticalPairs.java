package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Leetcode problem link: https://leetcode.com/problems/number-of-good-pairs/
 */
public class IdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        int[] hash = new int[101];
        int counter = 0;
        Arrays.fill(hash, Integer.MIN_VALUE);
        for(int i = 0; i < nums.length; i++) {
            int lastIndex = hash[nums[i]];
            if(lastIndex != Integer.MIN_VALUE) {
                counter += hash[nums[i]];
                hash[nums[i]] += 1;
            } else {
                hash[nums[i]] = 1;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        IdenticalPairs ip = new IdenticalPairs();
        int[] input = {1,2,3,1,1,3};
        int result = ip.numIdenticalPairs(input);
        System.out.println(result);
    }
}
