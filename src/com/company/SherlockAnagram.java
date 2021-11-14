package com.company;
import java.util.*;

import java.util.ArrayList;

public class SherlockAnagram {

    public static final int ALPHABET_COUNT = 26;
    static boolean isAnagram(String str1, String str2) {
        char[] chCount1 = new char[ALPHABET_COUNT];
        char[] chCount2 = new char[ALPHABET_COUNT];

        for(int i = 0, n = str1.length(); i < n; i++) {
            chCount1[str1.charAt(i) - 97] += 1;
            chCount2[str2.charAt(i) - 97] += 1;
        }

        for(int i = 0; i < ALPHABET_COUNT; i++) {
            if(chCount1[i] != chCount2[i]) {
                return false;
            }
        }

        return true;
    }


    public static int sherlockAndAnagram(String str) {
        int count = 0;
        for(int i = 1, n = str.length(); i < n; i++) {
            List<String> subList = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if(i + j <= n) {
                    subList.add(str.substring(j, i + j));
                }
            }

            for(int k = 0, size = subList.size(); k < size; k++) {
                for(int l = k + 1; l < size; l++) {
                    if(isAnagram(subList.get(k), subList.get(l))) count++;
                }
            }
        }

        return count;
    }
}
