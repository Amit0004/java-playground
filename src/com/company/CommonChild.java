package com.company;

import java.util.HashSet;
import java.util.Set;

public class CommonChild {


    public static int commonChild(String s1, String s2) {
        return lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
    }

    public static int lcs(char[] x, char[] y, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if(x[i - 1] == y[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[m][n];
    }
    public static void main(String[] args) {
        CommonChild cc = new CommonChild();
        String s1 = "ABCD";
        String s2 = "ABDC";
        System.out.println(cc.commonChild(s1, s2));
    }
}
