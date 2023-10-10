package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode: https://leetcode.com/problems/burst-balloons/
 * Coding Ninjas: https://www.codingninjas.com/studio/problems/mining-diamonds_4244494
 */
public class BurstBaloons {
    public int maxCoins(int a[], int len) {
        List<Integer> nums = Arrays.stream(a)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        nums.add(0, 1);
        nums.add(1);

        int n = a.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return mcm(nums, 1, a.length, dp);
    }

    private int mcm(List<Integer> arr, int i , int j, int[][] dp) {
        int max = Integer.MIN_VALUE;
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        for(int k = i; k <= j; k++) {
            int cost = (arr.get(i - 1) * arr.get(k) * arr.get(j + 1)) +
                    mcm(arr, i, k - 1, dp) +
                    mcm(arr, k + 1, j, dp);
            max = Math.max(max, cost);
        }
        dp[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        BurstBaloons bb = new BurstBaloons();
        int[] input = {7, 1, 8};
        int n = input.length;
        int output = bb.maxCoins(input, n);
        System.out.println("Burst baloons output >> " + output);
    }
}
