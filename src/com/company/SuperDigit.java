package com.company;

import java.util.Collections;

public class SuperDigit {

    public static int superDigit(String n, int k) {
        String input = String.join("", Collections.nCopies(k, n));
        return superDigit(input);
    }
    public static int superDigit(String n) {
        int sum = 0;
        if(n.length() == 1) return Integer.valueOf(n.split("")[0]);
        else {
            for(String k : n.split("")) {
                sum += Integer.valueOf(k);
            }
            String d = Integer.toString(sum);
            if(d.length() == 1) return Integer.valueOf(d.split("")[0]);
            else {
                return superDigit(d);
            }
        }
    }
    public static void main(String[] args) {
        SuperDigit sd = new SuperDigit();
        System.out.println(sd.superDigit("123", 3));
    }
}
