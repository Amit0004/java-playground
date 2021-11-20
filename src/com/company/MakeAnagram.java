package com.company;

public class MakeAnagram {

    public static int makeAnagram(String a, String b) {
        int count = 0;
        int[] aFreq = new int[26];
        int[] bFreq = new int[26];

        for(int i = 0; i < a.length(); i++) {
            char current = a.charAt(i);
            int position = (int)current - (int)'a';
            aFreq[position]++;
        }
        for(int i = 0; i < b.length(); i++) {
            char current = b.charAt(i);
            int position = (int)current - (int)'a';
            bFreq[position]++;
        }
        for(int i = 0; i < 26; i++) {
            int difference =  Math.abs(aFreq[i] - bFreq[i]);
            count += difference;
        }
        return count;
    }

    public static void main(String[] args) {
        MakeAnagram ma = new MakeAnagram();
        System.out.println(ma.makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
}
