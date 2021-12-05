package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifference {

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        int minSum = Integer.MAX_VALUE;
        Collections.sort(arr);
        for(int i = 0; i < arr.size()-1; i++) {
            int diff = Math.abs(arr.get(i) - arr.get(i+1));
            if (diff < minSum) {
                minSum = diff;
            }
        }
        return minSum;
    }
    public static void main(String[] args) {
        MinimumAbsoluteDifference mad = new MinimumAbsoluteDifference();
        List<Integer> input = new ArrayList<>();
        input.add(-2);
        input.add(2);
        input.add(4);
        System.out.println(mad.minimumAbsoluteDifference(input));
    }
}
