package com.dynamicprogramming;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    public int getLongestPalindromicSubstringLength(String str) {
        int result = 0;
        result = lcs(str);
        return result;
    }

    public int lcs(String k1) {
        String k2 = new StringBuilder(k1).reverse().toString();
        int max = 0;
        String output = "";
        int m = k1.length();
        int n = k2.length();

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(k1.charAt(i - 1) == k2.charAt(j - 1)) {
                    dp[i][j] =  1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                    System.out.println("Substring >> " + k2.substring(i - 1, j - 1));
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        printDp(dp);
        return max;
    }

    public void printDp(int[][] matrix) {
        int rows = matrix.length;
        for(int i = 0 ; i < rows; i++) {
            int cols = matrix[i].length;
            for(int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String getLongestPalindromicSubstring(String str) {
        return str;
    }
    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String input = "babad";
        int output = lps.getLongestPalindromicSubstringLength(input);
        System.out.println("Length of longest palindromic substring >>" + output);
    }
}
