package com.company;

public class StringCompression {

    public String compress(String s) {
        String output = "";
        int sum = 1;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                sum++;
            } else {
                output = output + s.charAt(i) + sum;
                sum = 1;
            }
        }

        output = output + s.charAt(s.length() - 1) + sum;

        return output;
    }
}
