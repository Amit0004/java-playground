package com.company;

/**
 * Check if a two strings are anagram of each other or not.
 * e.g. SILENT - LISTEN
 * */
public class CheckAnagram {

    public boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int[] letters = new int[1<<8];
        for(char c : s1.toCharArray()) {
            letters[c]++;
        }
        print(letters);
        System.out.println();
        for(char c : s2.toCharArray()) {
            letters[c]--;
        }
        print(letters);
        for(int i : letters) {
            if(i != 0) return false;
        }
        return true;
    }

    public void print(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
