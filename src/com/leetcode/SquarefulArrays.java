package com.leetcode;

import java.util.*;

/**
 * Leetcode: https://leetcode.com/problems/number-of-squareful-arrays/
 * Problem level: Hard
 */
public class SquarefulArrays {
        public int numSquarefulPerms(int[] nums) {
            HashSet<List<Integer>> combinations = new HashSet();
            permutations(nums, 0, nums.length, combinations);
            System.out.println(Arrays.toString(combinations.toArray()));
            int counter = 0;
            for(List<Integer> n : combinations) {
                int i = 0, j = 1, totalPair = n.size() - 1;
                int sqp = 0;
                while(j < n.size()) {
                    double root = Math.sqrt(n.get(i) + n.get(j));
                    if(root - Math.ceil(root) == 0) sqp++;
                    i++;
                    j++;
                }
                if(sqp == totalPair) counter++;
            }
            return counter;
        }

        public void permutations(int[] nums, int start, int end, HashSet<List<Integer>> combinations) {
            if(start == end) {
                List<Integer> res = new ArrayList<>();
                for(int i = 0; i < nums.length; i++) {
                    res.add(nums[i]);
                }
                combinations.add(res);
                return;
            }

            for(int i = start; i < end; i++) {
                swap(nums, i, start);
                permutations(nums, start + 1, end , combinations);
                swap(nums, i , start);
            }
        }

        private void swap(int[] nums, int i , int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public boolean isPerfectSquare(int num) {
            double root = Math.sqrt(num);
            System.out.println("root >> " + root);
            double rootAbs = Math.ceil(root);
            System.out.println("root abs >> " + root);
            double absDiff = root - rootAbs;
            System.out.println("abs diff >> " + absDiff);
            return !(absDiff != 0.0);
        }

        public static void main(String[] args) {
            SquarefulArrays sqarr = new SquarefulArrays();
            int[] nums = {1, 17, 8};
            int result = sqarr.numSquarefulPerms(nums);
            System.out.println(result);
            System.out.println("perfect >> " + sqarr.isPerfectSquare(27));
            System.out.println("sum >> " + List.of(nums).toArray().toString());
        }
}
