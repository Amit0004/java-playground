package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/arithmetic-subarrays
 * Level: Medium
 */
public class CheckArithmeticSubarray {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int q = l.length;

        List<Boolean> result = new ArrayList();

        for(int i = 0; i < q; i++) {
            int[] subset = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(subset);

            if(subset.length == 0 || subset.length == 1) result.add(true);
            else {
                int diff = Math.abs(subset[1] - subset[0]);
                int counter = 0;
                for(int j = 0; j < subset.length - 1; j++) {
                    if(Math.abs(subset[j + 1] - subset[j]) == diff) {
                        counter++;
                    } else {
                        result.add(false);
                        break;
                    }
                }
                if(counter == subset.length - 1) {
                    result.add(true);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CheckArithmeticSubarray cas = new CheckArithmeticSubarray();
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};
        List<Boolean> result = cas.checkArithmeticSubarrays(nums, l, r);
        System.out.println("Arithemetic subarry >> " + result.toString());
    }
}
