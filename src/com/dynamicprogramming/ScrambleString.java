package com.dynamicprogramming;

/**
 * https://leetcode.com/problems/scramble-string/description/
 * Level: Hard
 */
public class ScrambleString {

    public boolean isScrambleString(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.isEmpty()) return false;

        return scrambleStringRecursive(s, t);
    }

    private boolean scrambleStringRecursive(String s, String t) {
        boolean flag = false;
        if(s.equals(t)) return true;
        int n = s.length();
        for(int i = 1; i < n; i++) {
            String substring = s.substring(n - i, i);
            String substring1 = t.substring(i, n - i);
            boolean condition1 =
                    scrambleStringRecursive(s.substring(0, i), substring1) &&
                            scrambleStringRecursive(substring, t.substring(0, n - 1));
            boolean condition2 =
                    scrambleStringRecursive(s.substring(0, i), t.substring(0, i)) &&
                            scrambleStringRecursive(substring, substring1);
            if(condition1 || condition2) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        ScrambleString ss = new ScrambleString();
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println("Is Scramble String >> " + ss.isScrambleString(s1, s2));
    }
}
