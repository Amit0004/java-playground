package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317
 * Level: Hard
 */
public class MinimumSumPartition {

    public int minSumPartition(int[] nums, int n) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        List<Integer> range = findSubsetSum(nums, n, sum);

        System.out.println("Range >> " + range);

        int min = Integer.MAX_VALUE;
        for(Integer i: range) {
            min = Math.min(min, Math.abs(sum - (2 * i)));
        }
        return min;
    }

    public List<Integer> findSubsetSum(int[] nums, int n, int sum) {
        List<Integer> result = new ArrayList<>();
        boolean[][] dp = new boolean[n + 1][sum + 1];

        Math.pow(2, 3);
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][i] = dp[i - 1][j];
                }
            }
        }

        boolean[] sumRng = dp[n];

        for(int i = 0; i < sum / 2; i++) {
            if(sumRng[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public void printDp(boolean[][] matrix) {
        int rows = matrix.length;
        for(int i = 0 ; i < rows; i++) {
            int cols = matrix[i].length;
            for(int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinimumSumPartition msp = new MinimumSumPartition();
        int[] input = {1, 6, 11, 5};
        int output = msp.minSumPartition(input, input.length);
        System.out.println("Minimum sum partition >> " + output);
    }

}
