package com.dynamicprogramming;

public class SubsetSumCount {

    public int getSubsetCount(int[] nums, int sum) {
        int n = nums.length;
        int[][] counter = new int[n + 1][sum + 1];

        for(int i = 0; i < n + 1; i++) {
            counter[i][0] = 1;
        }

        for(int i = 1; i < sum + 1; i++) {
            counter[0][i] = 0;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(nums[i - 1] <= j) {
                    counter[i][j] = counter[i - 1][j] + counter[i - 1][j - nums[i - 1]];
                } else {
                    counter[i][j] = counter[i - 1][j];
                }
            }
        }

        return counter[n][sum];
    };
    public static void main(String[] args) {
        SubsetSumCount ssc = new SubsetSumCount();
        int[] input = {2, 3 ,5 ,6 ,8, 10};
        int sum = 10;
        int output = ssc.getSubsetCount(input, sum);
        System.out.println("Count of subset sum >> " + output);
    }
}
