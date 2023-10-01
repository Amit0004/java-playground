package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal Triangle problem
 * Leetcode: https://leetcode.com/problems/pascals-triangle/
 * Problem Level: Easy
 */
public class PascalTriangle {

    /**
     * Return the number at a given row and column number from a pascal triangle
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     * 1 5 10 10 5 1
     * element at (5, 3) -> element at row 5 and col 3 => 6
     * Ref: https://www.youtube.com/watch?v=bR7mQgwQ_o8
     * @param row
     * @param col
     * @return
     */
    public int getNumber(int row, int col) {
       int result = 0;
       result = nCr(row - 1, col - 1);
       return result;
    }

    private int nCr(int n, int r) {
        int ans = 1;

        for(int i = 1; i <= r; i++) {
            ans = ans * (n - i);
            ans = ans / (i+1);
        }
        return ans;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 1; i <= numRows; i++) {
            result.add(generateRow(i));
        }
        return result;
    }

    public List<Integer> generateRow(int row) {
        List<Integer> result = new ArrayList();
        int ans = 1;
        result.add(1);
        for(int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            result.add(ans);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
//        int findNumber = pt.getNumber(5, 3);
        System.out.println("Number >> " + pt.generateRow(5).get(3));
    }
}
