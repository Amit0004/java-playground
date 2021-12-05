package com.company;

public class LongestCommonSubsequence {

    /**
     * Recursive solution
     * Time complexity - O(2^m*n)
     * Space complexity - O(m + n)
     * */
    public static int lcsMethod1(char[] x, char[] y, int i, int j) {
        if(i <= 0 || j <= 0) {
            return 0;
        }
        if(x[i -1] == y[j-1]) {
            return 1 + lcsMethod1(x, y, i - 1, j - 1);
        } else {
            return Math.max(lcsMethod1(x, y, i - 1, j), lcsMethod1(x, y, i, j - 1));
        }
    }

    /**
     * Recursive + memoization solution
     * Top down approach
     * Time complexity - O(m*n)
     * Space complexity - O(m*n)
     * */
    public static int lcsMethod2(char[] x, char[] y, int i, int j, Integer[][] dp) {
        if(i <= 0 || j <= 0) {
            return 0;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        if(x[i-1] == y[j-1]) {
            return 1 + lcsMethod2(x, y, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(lcsMethod2(x, y, i - 1, j, dp), lcsMethod2(x, y, i, j - 1, dp));
        }
    }

    /**
     * DP solution
     * Bottom up approach (tabulation)
     * Time complexity - O(m*n)
     * Space complexity - O(m+n)
     * */
    public static int lcsMethod3(char[] x, char[] y, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if(x[i - 1] == y[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[m][n];
    }

    /**
     * Optimized DP solution
     * Time complexity - O(m*n)
     * Space Complexity - O(n)
     * */
    public static int lcsMethod4(char[] x, char[] y, int m, int n) {
        int[] memo = new int[n+1];
        for(int i = 1; i <= m; i++) {
            int prev = 0;
            for(int j = 1; j <= n; j++) {
                int temp = memo[j];
                if(x[i-1] == y[j-1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[i], memo[j -1]);
                }
                prev = temp;
            }
        }
        return memo[n];
    }
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "ABCD";
        String s2 = "ABDC";
        System.out.println(lcs.lcsMethod1(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println(lcs.lcsMethod2(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), new Integer[s1.length() + 1][s2.length() + 2]));
        System.out.println(lcs.lcsMethod3(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println(lcs.lcsMethod4(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    }
}
