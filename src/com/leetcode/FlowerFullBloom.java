package com.leetcode;

import java.util.*;

public class FlowerFullBloom {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        HashMap<Integer, Integer> garden = new HashMap();
        List<Integer> result = new ArrayList<>();

        for(int[] fl: flowers) {
            int start = fl[0];
            int end = fl[1];

            for(int i = start; i <= end; i++) {
                garden.put(i, garden.getOrDefault(i, 0) + 1);
            }
        }
        for(int p: people) {
            result.add(garden.getOrDefault(p, 0));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        FlowerFullBloom ffb = new FlowerFullBloom();
//        int[][] flowers = {
//                {1, 6},
//                {3, 7},
//                {9, 12},
//                {4, 13}
//        };
//        int[] people = {2, 3, 7, 11};

        int[][] flowers = {
                {19, 37},
                {19, 38},
                {19, 35},
        };
        int[] people = {6,7,21,1,13,37,5,37,46,43};

        int[] output = ffb.fullBloomFlowers(flowers, people);
        System.out.println("Full flower bloom output >> " + Arrays.toString(output));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(3);
        pq.add(1);
        pq.add(130);
        pq.add(-9);

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
