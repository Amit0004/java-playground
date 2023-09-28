package com.company;

public class ReverseString2 {

    public String reverse(String str) {
        String[] words = str.split(" ");
        for(int i = 0; i < words.length; i++) {
            words[i] = reverseWord(words[i]);
        }
        return String.join(" ", words);
    }

    public String reverseWord(String word) {
        char[] ch = word.toCharArray();
        int left = 0, right = ch.length - 1;
        while(left <= right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        ReverseString2 rs = new ReverseString2();
        String input = "Amit anand software";
        System.out.println(rs.reverse(input));
    }
}
