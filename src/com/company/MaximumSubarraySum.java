package com.company;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarraySum {

    public static long maximumSum(List<Long> a, long m) {
        long currentSum = 0;
        long maxSum = 0;
        for(int i = 0; i < a.size(); i++) {
            currentSum = (currentSum + a.size()) % m;
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaximumSubarraySum mss = new MaximumSubarraySum();
        List<Long> input = new ArrayList<>();
        input.add(3l);
        input.add(3l);
        input.add(9l);
        input.add(9l);
        input.add(5l);
        long modulo = 7;
        System.out.println(mss.maximumSum(input, modulo));
    }
}
