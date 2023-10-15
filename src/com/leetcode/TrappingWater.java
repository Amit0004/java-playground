package com.leetcode;

/**
 * Link: https://www.codingninjas.com/studio/problems/trapping-rain-water_630519
 * Level: Medium
 */
public class TrappingWater {


    public long getTrappedWater(long[] height) {
        long result = 0;
        int n = height.length;
        int left = 0, right = n - 1;
        long maxLeft = 0, maxRight = 0;

        while(left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] >= maxLeft) maxLeft = height[left];
                else result += maxLeft - height[left];
                left++;
            } else {
                if(height[right] >= maxRight) maxRight = height[right];
                else result += maxRight - height[right];
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TrappingWater tw = new TrappingWater();
        long[] input = {3, 0, 0, 2, 0, 4};
        long output = tw.getTrappedWater(input);
        System.out.println("Trapped water >> " + output);
    }
}
