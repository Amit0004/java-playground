package com.leetcode;

import java.util.Arrays;

public class SquarefulArraysDfs {
        boolean[] used;

        static int dfscounter = 0;
        int[] A;
        int result = 0;
        int curCount = 0;
        public int numSquarefulPerms(int[] A) {
            Arrays.sort(A);
            used = new boolean[A.length];
            this.A = A;
            DFS(-1);
            System.out.println("dfs runs >> " + dfscounter);
            return result;
        }
        private void DFS(int lastIndex) {
            dfscounter++;
            if (curCount == A.length) {
                result ++;
                return;
            }
            for (int i = 0; i < A.length; i++) {
                if (used[i] || (i > 0 && A[i] == A[i-1] && !used[i-1])) continue;
                if (lastIndex != -1 && !isPerfectSquare(A[i] + A[lastIndex])) continue;
                curCount ++;
                used[i] = true;
                DFS(i);
                curCount --;
                used[i] = false;
            }
        }
        private boolean isPerfectSquare(int x) {
            double sr = Math.sqrt(x);
            return ((sr - Math.floor(sr)) == 0);
        }

    public static void main(String[] args) {
        SquarefulArraysDfs sqarr = new SquarefulArraysDfs();
        int[] nums = {1, 17, 8};
        int result = sqarr.numSquarefulPerms(nums);
        System.out.println(result);
    }
}
