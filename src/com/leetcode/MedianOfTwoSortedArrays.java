package com.leetcode;

import java.util.*;

/**
 * Leetcode Problem link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Problem level: HARD
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mergedArray = merge(nums1, nums2);
        int totalLength = nums1.length + nums2.length;
        double median;
        if (totalLength % 2 == 0) {
            int mid = (int) (double) ((mergedArray.size() - 1) / 2);
            median = (double) (mergedArray.get(mid) + mergedArray.get(mid + 1)) / 2;
        } else {
            int mid = (int) (double) (mergedArray.size() / 2);
            median = (double) mergedArray.get(mid);
        }
        return median;
    }

    public List<Integer> merge(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                result.add(nums1[i]);
                i++;
            } else if (nums1[i] >= nums2[j]) {
                result.add(nums2[j]);
                j++;
            }
        }

        while (i < nums1.length) {
            result.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            result.add(nums2[j]);
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays mts = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(mts.findMedianSortedArrays(nums1, nums2));
    }
}
