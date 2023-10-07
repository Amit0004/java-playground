package com.dynamicprogramming;

import java.time.Instant;

/**
 * https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=33
 */
public class MatrixChainMultiplication {
    public int mcmRecursive(int[] arr, int i, int j) {
        int result = 0;

        // Base condition
        if(i >= j) return 0;

        int min = Integer.MAX_VALUE;

        for(int k = i; k < j; k++) {
            int temp = mcmRecursive(arr, i, k) + mcmRecursive(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            if(temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public int mcmMemoized(int[] arr, int start , int end) {
        int st = Instant.MIN.getNano();
        int[][] dp = new int[1001][1001];
        for(int k = 0; k < dp.length; k++) {
            for(int l = 01; l < dp[k].length; l++) {
                dp[k][l] = -1;
            }
        }
        int result = mcmMemoizedAlgorithm(arr, start, end, dp);
        return result;
    };

    private int mcmMemoizedAlgorithm(int[] arr, int i, int j, int[][] dp) {
        if(i >= j) return 0;
        int min = Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for(int k = i; k < j; k++) {
            int temp = mcmMemoizedAlgorithm(arr, i, k, dp) +
                    mcmMemoizedAlgorithm(arr, k + 1, j, dp) +
                    (arr[i - 1] * arr[k] * arr[j]);
            if(temp < min) {
                min = temp;
            }
        }
        dp[i][j] = min;
        return min;
    }
    public static void main(String[] args) {
        MatrixChainMultiplication mcm = new MatrixChainMultiplication();
        int[] input  = {40, 20, 30, 10, 30, 20};

        int recSt = Instant.MIN.getNano();
        int output = mcm.mcmRecursive(input, 1, input.length - 1);
        int recEnd = Instant.MIN.getNano();
        System.out.println("Recursive MCM execution time >> " + (recEnd - recSt));

        int st = Instant.MIN.getNano();
        int output2 = mcm.mcmMemoized(input, 1, input.length - 1);
        int et = Instant.MIN.getNano();
        System.out.println("Memoized MCM execution time >> " + (et - st));


        System.out.println("Matrix chain multiplication recursive output >> " + output);
        System.out.println("Matrix chain multiplication memoized output >> " + output2);
    }
}
