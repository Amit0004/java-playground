package com.leetcode;


import java.util.Arrays;

/**
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous
 * Level: HARD
 */
public class MinNumberOperationContinuousArray {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int count=Integer.MAX_VALUE,j=1,dup=0;
        int[] dupArr = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            while(j<nums.length&&nums[j]<=nums[i]+nums.length-1) {
                if(nums[j]==nums[j-1]) ++dup;
                dupArr[j]=dup;
                j++;
            }
            count = Math.min(count, i+(nums.length-j)+dup-dupArr[i]);
        }
        return count;
    }
    public static void main(String[] args) {
        MinNumberOperationContinuousArray mca = new MinNumberOperationContinuousArray();
        int[] input  = {1,10,100,1000};
        int output = mca.minOperations(input);
        System.out.println("Min operation >> " + output);
    }
}
