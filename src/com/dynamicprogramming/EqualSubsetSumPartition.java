package com.dynamicprogramming;

/**
 * Link: https://leetcode.com/problems/partition-equal-subset-sum/description/
 * Level: Medium
 */
public class EqualSubsetSumPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // If total sum is odd we cannot partition return false
        if(sum % 2 != 0) return false;

        return hasSubsetSum(nums, nums.length, sum / 2);
    };

    public boolean hasSubsetSum(int[] set, int n, int sum) {
      boolean[][] subset = new boolean[n + 1][sum + 1];

      // Initialise the DP matrix
      for(int i = 0; i < n + 1; i++) {
          subset[i][0] = true;
      }

        for(int i = 1; i < sum + 1; i++) {
            subset[0][i] = false;
        }

        // Fill in the rest values in the DP matrix
      for(int i = 1; i < n + 1; i++) {
          for(int j = 1; j < sum + 1; j++) {
              if(set[i - 1] <= j) {
                  subset[i][j] = subset[i - 1][j] || subset[i - 1][j - set[i - 1]];
              } else {
                  subset[i][j] = subset[i - 1][j];
              }
          }
      }

      return subset[n][sum];
    };

    public static void main(String[] args) {
        EqualSubsetSumPartition essp = new EqualSubsetSumPartition();
        int[] input = {1, 5, 11, 5};
        boolean output = essp.canPartition(input);
        System.out.println(output);
    }
}
