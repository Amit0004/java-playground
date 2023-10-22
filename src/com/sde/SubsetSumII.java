package com.sde;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/subsets-ii/description/
 * Level: Medium
 */
public class SubsetSumII {

    public List<List<Integer>> getSubsSets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubset(0, nums, new ArrayList<Integer>(), result);
        return result;
    }

    private void findSubset(int index, int[] arr, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for(int i = index;i < arr.length;i++){
            if(i != index && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            findSubset(i + 1, arr, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetSumII ssi = new SubsetSumII();
        int[] input = {1, 2, 2};
        List<List<Integer>> output = ssi.getSubsSets(input);
        System.out.println("Subsets >> " + output.toString());
    }
}
