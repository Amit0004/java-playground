package com.leetcode;

import java.util.Arrays;

/**
 * Link: https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
 * Level: Medium
 * TC: O(2 * nlogn) + O(2n)
 * SC: O(1)
 */
public class MinimumPlatforms {
    public int getMinimumPlatforms(int[] arr, int[] dep, int n) {
        int max = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platNeeded = 1;
        int i = 1, j = 0;
        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {
                platNeeded++;
                i++;
            } else if(arr[i] > dep[j]) {
                platNeeded--;
                j++;
            }

            if(platNeeded > max) {
                max = platNeeded;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MinimumPlatforms mp = new MinimumPlatforms();
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        int output = mp.getMinimumPlatforms(arr, dep, n);
        System.out.println("Minimum platforms required >> "+ output);
    }
}

