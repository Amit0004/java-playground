package com.leetcode;

/**
 * Leetcode problem 896
 *
 */
public class MonotonicArray {
        public boolean isMonotonic(int[] arr) {
            if(arr.length == 1) return true;
            int i = 0;
            int decCounter = 0;
            int ascCounter = 0;
            while(i < arr.length - 1) {
                if(arr[i] < arr[i + 1]) ascCounter++;
                else if(arr[i] > arr[i + 1]) decCounter++;
                else {
                    ascCounter++;
                    decCounter++;
                }
                i++;
            }
            if(ascCounter == arr.length - 1) return true;
            if(decCounter == arr.length - 1) return true;
            return false;
        }

        public static void main(String[] args) {
            MonotonicArray ma = new MonotonicArray();
            int[] input = {1, 2, 2, 3};
            System.out.println(ma.isMonotonic(input));
        }
}
