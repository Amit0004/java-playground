package com.leetcode;

import java.util.Arrays;

/**
 * Sort 0s, 1s and 2s
 * Leetcode Link: https://leetcode.com/problems/sort-colors/
 * GeeksForGeek: https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class Sort0s1s2s {
    public int[] sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        int temp = 0;
        while(mid <= high) {
            switch(nums[mid]) {
                case 0: {
                    temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                    break;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        Sort0s1s2s sort = new Sort0s1s2s();
        int[] input = {0,2,1,0,2,2,1,1,0};
        int[] nums = sort.sortColors(input);
        System.out.println(Arrays.toString(nums));
    }
}
