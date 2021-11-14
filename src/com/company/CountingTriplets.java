package com.company;
import java.util.*;

public class CountingTriplets {

    public static long countTriplet(List<Long> arr, long r) {
        long result = 0;
        Map<Long, Long> rightMap = new HashMap<>();
        Map<Long, Long> leftMap = new HashMap<>();

        for(long l : arr) {
            rightMap.put(l, rightMap.getOrDefault(l, 0L) + 1);
        }

        for(int i = 0; i < arr.size(); i++) {
            long n1 = 0l, n2 = 0l;
            long current = arr.get(i);
            rightMap.put(current, rightMap.getOrDefault(current, 0l) - 1);

            if(leftMap.containsKey(current / r) && current % r == 0) {
                n1 = leftMap.get(current / r);
            }
            if(rightMap.containsKey(current * r)) {
                n2 = rightMap.get(current * r);
            }

            result += n1 * n2;
            leftMap.put(current, leftMap.getOrDefault(current, 0l) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Long> l = new ArrayList<>();
        l.add(1l);
        l.add(5l);
        l.add(5l);
        l.add(25l);
        l.add(125l);

        CountingTriplets ct = new CountingTriplets();
        System.out.println(ct.countTriplet(l, 5l));
    }
}
