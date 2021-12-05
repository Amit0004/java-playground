package com.company;

public class SpecialStringAgain {

    public static long substrCount(int n, String s) {
        long result = n;
        for(int i = 0; i < n; i++) {
            int repeat = 0;
            // for same strings like 'aaaa', 'bb', 'cccc'
            while( (i + 1) < s.length() && s.charAt(i) == s.charAt(i+1)) {
                repeat++;
                i++;
            }
            result += repeat * (repeat + 1) / 2;

            // for different character strings 'asadas'

            int pointer = 1;
            while(
                    (i-pointer) >= 0 &&
                    (i + pointer) < n &&
                    s.charAt(i+pointer) == s.charAt(i-1) &&
                    s.charAt(i-pointer) == s.charAt(i-1)
            ) {
                result++;
                pointer++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        SpecialStringAgain ssa = new SpecialStringAgain();
        String s = "aaaa";
        System.out.println(ssa.substrCount(s.length(), s));
    }
}
