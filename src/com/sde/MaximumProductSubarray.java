package com.sde;

/**
 * Link: https://leetcode.com/problems/maximum-product-subarray/
 * Level: Medium
 */
public class MaximumProductSubarray {

    public int getMaxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int maxProductSoFar = 1;

        for(int i = 0; i < nums.length; i++) {
            if(maxProductSoFar < 0 && nums[i] > 0 && i == nums.length - 1) {
                maxProductSoFar = 1;
            }
            maxProductSoFar *= nums[i];
            maxProduct = Math.max(maxProductSoFar, maxProduct);

            if(maxProductSoFar == 0) {
                maxProductSoFar = 1;
            }
        }

        return maxProduct;
    }
    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
//        int[] nums = {-3, -1, -1};
//        int[] nums = {-2,3,-4};
        int[] nums = {2,-5,-2,-4,3};
        System.out.println("Maximum product subarray > " + mps.getMaxProduct(nums));
    }

}
