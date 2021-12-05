package com.company;

import java.util.*;

public class MinimumTimeRequired {

    public static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long max = machines[machines.length - 1];
        long minDays = 0;
        long maxDays = max*goal;
        long result = -1;
        while (minDays < maxDays) {
            long mid = (minDays + maxDays) / 2;
            long unit = 0;
            for (long machine : machines) {
                unit += mid / machine;
            }
            if (unit < goal) {
                minDays = mid+1;
            } else {
                result = mid;
                maxDays = mid;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        MinimumTimeRequired mtr = new MinimumTimeRequired();
        long[] input = {2, 3};
        System.out.println(mtr.minTime(input, 5));
    }
}
