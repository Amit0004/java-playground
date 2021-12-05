package com.company;

import java.util.Scanner;

public class MultiDimensionArray {

    public static void printColumnSum() {
        Scanner sc = new Scanner(System.in);
        String[] size = sc.nextLine().split(" ");
        int n = Integer.valueOf(size[0]);
        int m = Integer.valueOf(size[1]);
        int[][] numbers = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] row = sc.nextLine().split(" ");
            for(int j = 0; j < m; j++) {
                numbers[i][j] = Integer.valueOf(row[j]);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(numbers[j][i] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        MultiDimensionArray mda = new MultiDimensionArray();
        mda.printColumnSum();
    }
}
