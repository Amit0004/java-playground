package com.company;

/***
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Input -> [2, 7, 11, 15], target = 9;
 * Output -> [1, 2]
 * Array index in 1 based
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int low = 0, high = numbers.length - 1;

        while(low <= high) {
            int n = numbers[low] + numbers[high];
            if(n == target) {
                result[0] = low + 1;
                result[1] = high + 1;
                return result;
            } else if(n < target) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] input = {2, 7, 11, 15};
        for(int i : ts.twoSum(input, 9)) {
            System.out.print(i + " ");
        }
    }
}
