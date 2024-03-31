package com.sde;

import java.util.Arrays;

/**
 * Link: https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
 * Level: Medium
 */
public class FloydWarshallAlgorithms {

    public void floydWarshall(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                }

                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) (1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        FloydWarshallAlgorithms fwa = new FloydWarshallAlgorithms();
        int[][] matrix = {{0, 1, 43}, {1, 0, 6}, {-1, -1, 0}};

        fwa.floydWarshall(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
