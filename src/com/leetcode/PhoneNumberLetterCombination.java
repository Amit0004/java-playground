package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * Prblem level: Medium
 */
public class PhoneNumberLetterCombination {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character, String> numToAlpha = new HashMap<>();
        numToAlpha.put('2', "abc");
        numToAlpha.put('3', "def");
        numToAlpha.put('4', "ghi");
        numToAlpha.put('5', "jkl");
        numToAlpha.put('6', "mno");
        numToAlpha.put('7', "pqrs");
        numToAlpha.put('8', "tuv");
        numToAlpha.put('9', "wxyz");

        char[] charArr = digits.toCharArray();
        return result;
    }

    public static void main(String[] args) {
        PhoneNumberLetterCombination pnlc = new PhoneNumberLetterCombination();
        String input = "23";
        List<String> output = pnlc.letterCombinations(input);
        System.out.println(output);
    }
}
