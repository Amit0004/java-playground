package com.dynamicprogramming;

/**
 *
 */
public class SubsetSum {

    /**
     * Time complexity: O(sum * n)
     * Space complexity: O(sum * n)
     * @param set
     * @param n
     * @param sum
     * @return
     */
    public boolean isSubsetSumPresent(int[] set, int n, int sum) {

        boolean[][] subset = new boolean[sum + 1][n + 1];

        // if sum is 0 answer is true
        for(int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }

        // if set is empty ans is false
        for(int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }

        // fill the entire DP table
        for(int i = 1; i <= sum; i++) {
            for(int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if(set[j - 1] <= i) {
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }
            }
        }

        return subset[sum][n];
    }

    public boolean isSubsetSumPresentV2(int[] set, int n, int sum) {
        boolean[][] subset = new boolean[n + 1][sum + 1];

        // Initialize
        for(int i = 0; i < n + 1; i++) {
            subset[i][0] = true;
        }

        for(int j = 1; j < sum + 1; j++) {
            subset[0][j] = false;
        }

        // Fill the rest values
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(set[i - 1] <= j) {
                    subset[i][j] = subset[i - 1][j] || subset[i - 1][j - set[i - 1]];
                } else {
                    subset[i][j] = subset[i - 1][j];
                }
            }
        }
        printDp(subset);
        return subset[n][sum];
    }

    public boolean isSubsetSumPresentRecursive(int[] set, int n, int sum) {
      return findSubsetSumRecursively(set, n , sum);
    };

    public boolean findSubsetSumRecursively(int[] set, int n, int sum) {
        if(sum == 0) {
            return true;
        };
        if(n == 0) return false;

        if(set[n - 1] <= sum) {
            return (findSubsetSumRecursively(set, n - 1, sum - set[n - 1]) || findSubsetSumRecursively(set, n - 1 , sum));
        } else {
            return findSubsetSumRecursively(set, n - 1 , sum);
        }
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
        SubsetSum ss = new SubsetSum();
        int[] input = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean isPresent = ss.isSubsetSumPresent(input, input.length, sum);
        boolean isPresent2 = ss.isSubsetSumPresentV2(input, input.length, sum);
        boolean isPresentRecursively = ss.isSubsetSumPresentRecursive(input, input.length, sum);
        System.out.println("SubsetSum output >> " + isPresent);
        System.out.println("SubsetSum output >> " + isPresent2);
        System.out.println("SubsetSum recursively output >> " + isPresentRecursively);
    }
}
