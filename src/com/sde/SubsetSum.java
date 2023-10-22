package com.sde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Link: https://practice.geeksforgeeks.org/problems/subset-sums2234/1
 * Level: Medium
 */
public class SubsetSum {

    public ArrayList<Integer> subsetSums(List<Integer> arr, int N){
        ArrayList<Integer> result = new ArrayList();
        calculateSum(0, 0, arr, N, result);
        Collections.sort(result);
        return result;
    }

    public void calculateSum(int index, int sum, List<Integer> nums, int N, ArrayList<Integer> result) {
        if(index == N) {
            result.add(sum);
            return;
        }
        calculateSum(index + 1, sum + nums.get(index), nums, N, result);
        calculateSum(index + 1, sum, nums, N, result);
    }
    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        List<Integer> input = List.of(5, 2, 1);
        ArrayList<Integer> output = ss.subsetSums(input, input.size());
        System.out.println("Subset sums >> " + output.toString());

    }
}
