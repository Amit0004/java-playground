package com.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Level: Medium
 */
public class FirstPositionAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int start = -1, end = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                start = mid;
                end = mid;
                while (start > 0 && nums[start - 1] == target) {
                    start--;
                }
                while (end < nums.length - 1 && nums[end + 1] == target) {
                    end++;
                }
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{ start, end} ;
    }



    public static void main(String[] args) {
        FirstPositionAndLastPosition fp = new FirstPositionAndLastPosition();
        int[] input = {5};
        int target = 5;
        int[] result = fp.searchRange(input, target);
        System.out.println("Range output >> " + Arrays.toString(result));
    }
}
