package com.company;

public class AlternatingCharacter {

    public static int alternatingCharacter(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.length());
        for(int i = 0; i < sb.length()-1; i++) {
            if(sb.charAt(i) == sb.charAt(i+1)) {
                count++;
                sb.deleteCharAt(i+1);
            } else  {
                continue;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        AlternatingCharacter ac = new AlternatingCharacter();
        String input = "ABABABAB";
        System.out.println(ac.alternatingCharacter(input));
    }
}
