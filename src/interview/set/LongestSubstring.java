package interview.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest substring without repeating characters
 * Input -> "abcabcabc"
 * Output -> 3 "abc"
 * */
public class LongestSubstring {

    public int longestSubstring(String input) {
        int maxSoFar = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while(i < input.length()) {
            char c = input.charAt(i);
            while(set.contains(c)) {
                set.remove(input.charAt(j));
                ++j;
            }
            set.add(c);
            maxSoFar = Math.max(maxSoFar, i - j + 1);
            ++i;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        String input = "pwwkew";
        System.out.println(ls.longestSubstring(input));
    }
}
