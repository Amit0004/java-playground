package com.dynamicprogramming;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int result = 0;

        int sum = 0;
        for(int i: nums) sum += i;
        int diff = (sum + target) / 2;
        return getSubsetSumCount(nums, nums.length, diff);
    }

    public int getSubsetSumCount(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < sum + 1; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] input = {1, 1, 1, 1, 1};
        int target = 3;
        int result = ts.findTargetSumWays(input, target);
        System.out.println("Target sum output >> " + result);
    }
}
