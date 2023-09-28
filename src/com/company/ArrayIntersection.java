package com.company;

import java.util.HashSet;

/**
 * Intersection of two unsorted array
 * */
public class ArrayIntersection {

    public int arrayIntersection(int[] a, int[] b, int m, int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : a) {
            set.add(i);
        }

        HashSet<Integer> intersection = new HashSet<Integer>();
        for(int i : b) {
            if(set.contains(i)) intersection.add(i);
        }

        return intersection.size();
    }

    public static void main(String[] args) {
        int[] a = {89, 24, 74, 25, 11};
        int[] b = {89, 24, 34};
        ArrayIntersection ai = new ArrayIntersection();
        System.out.println(ai.arrayIntersection(a, b, a.length, b.length));
    }
}
