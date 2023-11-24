package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Link: https://leetcode.com/problems/maximum-number-of-coins-you-can-get
 * Level: Medium
 */
public class LCDCMaxNumberCoin {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        Queue<Integer> q = new LinkedList();

        for(int i = piles.length - 1; i >= 0; i--) {
            q.offer(piles[i]);
        }

        int max = 0;
        while(!q.isEmpty()) {
            int alice = q.poll();
            int me = q.poll();
            max += me;
            int bob = q.poll();
        }

        boolean[] arr = new boolean[4];
        System.out.println("boolean >> " + arr[0]);

        return max;
    }

    public static void main(String[] args) {
        LCDCMaxNumberCoin mnc = new LCDCMaxNumberCoin();
        int[] input = {9,8,7,6,5,1,2,3,4};
        int max = mnc.maxCoins(input);
        System.out.println("Max coins >>> " + max);
    }
}
