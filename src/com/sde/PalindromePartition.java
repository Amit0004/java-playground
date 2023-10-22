package com.sde;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/palindrome-partitioning/
 * Level: Medium
 */
public class PalindromePartition {

    public List<List<String>> palindromePartition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partition(0, s, path, result);
        return result;
    }

    public void partition(int index, String s, List<String> path, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); ++i) {
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                partition(i + 1, s, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartition pp = new PalindromePartition();
        String input = "aabb";
        List<List<String>> output = pp.palindromePartition(input);
        System.out.println("Palindrome partitions >> " + output);
    }
}
