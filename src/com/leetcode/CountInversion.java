package com.leetcode;

public class CountInversion {


    public long countInversion(long[] arr, int n) {
        long counter = 0;
        long[] minleft = new long[n];
        minleft[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            minleft[i] = Math.min(minleft[i + 1], arr[i]);
        }

        for(int i = 0; i < n - 1; i++) {
            if(arr[i] > minleft[i + 1]) {
                counter += 1;
            }
        }
        return counter;
    };

    public static void main(String[] args) {
        CountInversion ci = new CountInversion();
        long[] input = {3, 2, 1};
        long result = ci.countInversion(input, input.length);
        System.out.println("Total number of inversions >> " + result);
    }
}
