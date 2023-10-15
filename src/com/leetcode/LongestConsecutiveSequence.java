package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/
 * Level: Medium
 *
 * Sample input 1
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 *
 * Sample input 2
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return 1;

        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int current = 1;
        for(int i = 0; i < n - 1; i++) {
            if((long)nums[i] + 1 == (long)nums[i + 1]) {
                current++;
            } else {
                current = 1;
            }
            max = Math.max(current, max);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] input = {1,2,0,1};
        int output = lcs.longestConsecutive(input);
        System.out.println("Longest consecutive sequence >> " + output);
    }
}
