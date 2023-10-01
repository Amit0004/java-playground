package com.leetcode;

public class SetZeroMatrix {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) col0 = 0;
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(col0 == 0) matrix[i][0] = 0;
        }
    }
    public static void main(String[] args) {
        int[][] input = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        SetZeroMatrix szm = new SetZeroMatrix();
        szm.setZeroes(input);
        for(int i = 0; i < input.length - 1; i++) {
            for(int j = 0; j < input[i].length - 1; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}
