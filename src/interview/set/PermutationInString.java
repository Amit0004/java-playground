package interview.set;

/**
 * s1 - "ab"
 * s2 = "eidbaoo
 * output - true
 * permutation of s1 is present in s2 - "ba"
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 * */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        if(len > s2.length()) return false;
        int start = 0, end = s1.length() - 1;
        while(end < s2.length()) {
            if(checkAnagram(s1, s2.substring(start, end + 1))){
                return true;
            } else {
                end++;
                start++;
            }
        }
        return false;
    }

    public boolean checkAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int[] letters = new int[1<<8];
        for(char ch : s1.toCharArray()) {
            letters[ch]++;
        }
        for(char ch : s2.toCharArray()) {
            letters[ch]--;
        }
        for(int i : letters) {
            if(i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString pis = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaoo";
        System.out.println(pis.checkInclusion(s1, s2));
    }
}
