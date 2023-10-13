package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/3sum/description/
 * Level: Medium
 *
 * Sample input 1
 * Input: nums = [0,1,1]
 * Output: []
 *
 * Sample input 2
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;
        if(nums.length == 0) return result;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) {
                    j++;
                } else if(sum > 0) {
                    k--;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] input = {};
        int target = 0;

        List<List<Integer>> result = ts.threeSum(input);
        System.out.println("Three sum output >> " + result);
    }
}
