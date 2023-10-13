package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/4sum/
 * Level: Medium
 * Sample input 1
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * Sample input 2
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();

        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++) {
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;

                while(k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if((long)sum == (long)target) {
                        result.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++; l--;
                        while(k < l && nums[k] == nums[k - 1]) k++;
                        while(k < l && nums[l] == nums[l + 1]) l--;
                    } else if(sum < target) k++;
                    else l--;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] input = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> result = fs.fourSum(input, target);
        System.out.println("Four sum output >> " + result);
    }

}
