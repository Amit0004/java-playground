package com.leetcode;

/**
 * Link: https://leetcode.com/problems/longest-palindromic-substring/description/
 * Level: Medium
 */
public class LongestPalindromicSubstringV2 {

    public String longestPalindrome(String s) {
        String result = "";
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0) {
                    dp[i][j] = 1 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        printDp(dp);
        return result;
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
    public static void main(String[] args) {
        LongestPalindromicSubstringV2 lcsv2 = new LongestPalindromicSubstringV2();
        String input = "babad";
        System.out.println("Longest palindrome >> " + lcsv2.longestPalindrome(input));
    }
}
