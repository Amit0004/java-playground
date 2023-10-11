package com.dynamicprogramming;

public class LongestCommonSubsequence {

    public int lcsRecursive(String s1, String s2, int n, int m) {
        int counter = 0;
        if(n == 0 || m == 0) {
            return 0;
        }

        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcsRecursive(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(
                    lcsRecursive(s1, s2, n, m - 1),
                    lcsRecursive(s1, s2, n - 1, m)
            );
        }
    }

    public int lcsTopDown(String s1, String s2, int x, int y) {
        int[][] dp = new int[x + 1][y + 1];

        for(int i = 0; i < x + 1; i++) {
            dp[i][0] = 0;
        };

        for(int i = 0; i < y + 1; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i < x + 1; i++) {
            for(int j = 1; j < y + 1; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i][j - 1],
                            dp[i - 1][j]
                    );
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        int n = s1.length();
        int m = s2.length();

        int output = lcs.lcsRecursive(s1, s2, n, m);
        int output2 = lcs.lcsTopDown(s1, s2, n, m);
        System.out.println("LCS recursive output >> " + output);
        System.out.println("LCS top down output >> " + output2);
    }
}
