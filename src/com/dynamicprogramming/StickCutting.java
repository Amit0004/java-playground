package com.dynamicprogramming;

/**
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 * Level: Hard
 */
public class StickCutting {

    public int minCost(int n, int[] cuts) {
        int min = 0;
        min = unboundedKnapsack(cuts, n);
        return min;
    }

    public int unboundedKnapsack(int[] cuts, int n) {
        int[][] dp = new int[cuts.length + 1][n + 1];

        return dp[cuts.length - 1][n];
    }

    public static void main(String[] args) {
        StickCutting sc = new StickCutting();
        int[] input = {1, 3, 4, 5};
        int n = 7;
        int output = sc.minCost(n, input);
        System.out.println("Min cost output >> " + output);
    }
}
