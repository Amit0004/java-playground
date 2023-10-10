package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public static List<String> palindrome = new ArrayList<>();
    static int[][] dp = new int[1001][1001];
    public int findPalindromePartition(String s, int i, int j) {
        if(i >= j) return 0;
        if(isPalindrome(s, i, j)) {
            return 0;
        };

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int temp = findPalindromePartition(s, i, k) + findPalindromePartition(s, k + 1, j) + 1;
            if(temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public int findPalindromePartitionMemoized(String s, int i, int j) {
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return memoizedPalindromePartition(s, i, j);
    }

    private int memoizedPalindromePartition(String s, int i , int j) {
        if(i >= j) return 0;
        if(isPalindrome(s, i, j)) return 0;
        if(dp[i][j] != -1) return 0;

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int temp = memoizedPalindromePartition(s, i, k) + memoizedPalindromePartition(s, k + 1, j) + 1;
            if(temp < min) {
                min = temp;
            }
        }
        dp[i][j] = min;
        return min;
    }

    public boolean isPalindrome(String s, int start, int end) {
        int i = start;
        int j = end;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    };

    public  List<String> getPalindrome() {
        return palindrome;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        String input = "ababbbabbababa";
        int result = pp.findPalindromePartition(input, 0, input.length() - 1);
        int result2 = pp.findPalindromePartitionMemoized(input, 0, input.length() - 1);
        System.out.println("No. of palindrome partition >> " + result);
        System.out.println("No. of palindrome partition memoized >> " + result2);
    }
}
