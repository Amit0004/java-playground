package com.dynamicprogramming;

/**
 * 0/1 Knapsack problem recursive code
 * Input: wt[] - weight of the items
 * val[] - value for each item
 * capacity - capacity of the knapsack
 * n - length of the array
 * Find the maximum profit possible with given bag size
 * Ref: https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3
 */
public class KnapsackRecursive {

    /**
     * Time complexity: O(n2)
     * @param wt
     * @param val
     * @param capacity
     * @param n
     * @return
     */
    public int knapsackRecursive(int[] wt, int[] val, int capacity, int n) {
        if(n == 0 || capacity == 0) {
            return 0;
        }
        int result = 0;

        if(wt[n-1] <= capacity) {
            return Math.max(
                    val[n-1] + knapsackRecursive(wt, val, capacity - wt[n-1], n - 1),
                    knapsackRecursive(wt, val, capacity, n - 1)
            );
        } else if(wt[n-1] > capacity) {
            return knapsackRecursive(wt, val, capacity, n - 1);
        }
        return result;
    }

    /**
     * Time complexity: O(n)
     * Space Complexity: O(n * M) - where n is the size of the knapsack and M is the size of the input
     * @param wt
     * @param val
     * @param capacity
     * @param size
     * @return
     */
    public int knapsackMemoized(int[] wt, int[] val, int capacity, int size) {
        int[][] dp = new int[capacity + 1][size + 1];
        return memoizedKnapsack(wt, val, capacity, size, dp);
    }

    private int memoizedKnapsack(int[] wt, int[] val, int capacity, int size, int[][] dp) {
        if(size == 0 || capacity == 0) {
            return 0;
        }
        if(dp[capacity][size] != -1) {
            return dp[capacity][size];
        }

        if(wt[size - 1] <= capacity) {
            dp[capacity][size] = Math.max(
                    val[size - 1] + memoizedKnapsack(wt, val, capacity, size - 1, dp),
                    memoizedKnapsack(wt, val, capacity, size - 1, dp)
            );
        } else {
            dp[capacity][size] = memoizedKnapsack(wt, val, capacity, size, dp);
            return dp[capacity][size];
        }
        return 0;
    }


    public int topdownKnapsack(int[] wt, int[] val, int w, int n) {
      int[][] dp = new int[n + 1][w + 1];

      // initialize the first row and column
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < w + 1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Call the recursive function to fill the entire DP table
        topdownKnapsackAlgorithm(wt, val, w, n, dp);

      return dp[n][w];
    };

    public void topdownKnapsackAlgorithm(int[] wt, int[] val, int w, int n, int[][] dp) {
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j <  w + 1; j++) {
                if(wt[i - 1] <= j) {
                    dp[i][j] = Math.max(
                      val[i - 1] + dp[i - 1][j - wt[i - 1]],
                      dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        KnapsackRecursive kr = new KnapsackRecursive();
        int[] wt = {1, 2, 3, 4};
        int[] val = {1, 4, 5, 7};
        int capacity = 7;
        int result = kr.knapsackRecursive(wt, val, capacity, wt.length);
        int memoizedOutput = kr.knapsackRecursive(wt, val, capacity, wt.length);
        int topdownOutput = kr.topdownKnapsack(wt, val, capacity, wt.length);
        System.out.println("Recursive solution >> " + result);
        System.out.println("Memoized solution >> " + memoizedOutput);
        System.out.println("Top down solution >> " + topdownOutput);
    }
}
