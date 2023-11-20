package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Link: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 * Level: Medium
 */
public class Unique3PalindromicSubsequence {

    public int countPalindromicSubsequence(String s) {
        int result = 0;
        Set<String> palindrome = new HashSet<>();
        int n = s.length();
        int i = 0, j = n - 1;
        while(i < n) {
            int last = j;
            while(last >= 0) {
                if(s.charAt(i) == s.charAt(last)) {
                    for (int k = i + 1; k < last; k++) {
                        String sb = String.valueOf(s.charAt(i)) +
                                s.charAt(k) +
                                s.charAt(last);
                        palindrome.add(sb);
                    }
                }
                last--;
            }
//            if(s.charAt(i) == s.charAt(j)) {
//                for(int k = i + 1; k < j; k++) {
//                    String sb = String.valueOf(s.charAt(i)) +
//                            s.charAt(k) +
//                            s.charAt(j);
//                    palindrome.add(sb);
//                }
//                j = n - 1;
//            } else {
//                j--;
//            }
            i++;
        }
        System.out.println("Palindromes >> " + palindrome.toString());
        result = palindrome.size();
        return result;
    }


    public static void main(String[] args) {
        Unique3PalindromicSubsequence ups = new Unique3PalindromicSubsequence();
        String input = "bbcbaba";
//        String input = "ckafnafqo";
//        String input = "aabca";
//        String input = "acd";
        System.out.println("Total palindromic subsequence of length 3 >> " + ups.countPalindromicSubsequence(input));
    }
}
