package com.sde;

/**
 * Maximum sum subarray
 * Link: https://www.codingninjas.com/studio/problems/630526?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * Level: Medium
 */
public class MaximumSumSubArray {

    public int maxSum(int[] n) {
        int result = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n.length; i++) {
            sum += n[i];

            if(sum > result) {
                result = sum;
            }
            if(sum <= 0) {
                sum = 0;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        MaximumSumSubArray mssa = new MaximumSumSubArray();
        int[] input = new int[]{-7, -8, -16, -4, -8, -5, -7, -11, -10, -12, -4, -6, -4, -16, -10};
        int maxSum = mssa.maxSum(input);
        System.out.println("Maximum sum subarray >> " + maxSum);
    }
}
