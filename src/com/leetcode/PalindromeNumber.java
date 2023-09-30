package com.leetcode;

import java.math.BigInteger;

/**
 * Palindrome number
 * Leetcode problem link: https://leetcode.com/problems/palindrome-number/
 * Problem level: Easy
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        char[] digits = String.valueOf(x).toCharArray();
        if(digits.length == 0 || digits.length == 1) return true;
        int left = 0, right = digits.length - 1;
        while(left <= right) {
            if(digits[left] != digits[right]) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        int num = 121;
        System.out.println(pn.isPalindrome(num));
        System.out.println(Long.valueOf("1000000000000000000000000000001"));
    }
}
