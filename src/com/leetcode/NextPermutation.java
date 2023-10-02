package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode problem link: https://leetcode.com/problems/next-permutation/
 * Problem Level: Medium
 *
 */
public class NextPermutation {
    public int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        // Step 1: Find the break point
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: Check the break point
        if(index == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }

        // Step 3: Find the smallest greater element than index
        for(int i = n - 1; i > index; i--) {
            if(nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverse(nums, index + 1, n-1);
        return nums;
    }

    /**
     * 1, 2, 3, 4
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] input = {1, 2, 3};
        int[] nextPermutation = np.nextPermutation(input);
        System.out.println(Arrays.toString(nextPermutation));
        int[] reverseInput = {1, 3, 4, 5, 4};
        np.reverse(reverseInput, 1, 3);
        System.out.println(Arrays.toString(reverseInput));
    }
}
