package com.sde;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://www.codingninjas.com/studio/problems/find-minimum-number-of-coins_975277
 * Link: https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * Level: Easy
 * Concept: Greedy algorithm
 */
public class MinimumCoinsGreedy {

    public List<Integer> getMinimumCoinsGreedy(int amount) {
        List<Integer> result = new ArrayList<>();
        int min = 0;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

        int pointer =  coins.length - 1;
        while(amount > 0) {
            if(amount >= coins[pointer]) {
                int count = amount / coins[pointer];
                min += count;
                amount -= (count * coins[pointer]);
                for(int i = 0; i < count; i++) {
                    result.add(coins[pointer]);
                }
            }
            pointer--;
        }
        return result;
    }
    public static void main(String[] args) {
        MinimumCoinsGreedy mcg = new MinimumCoinsGreedy();
        int amount = 87;
        System.out.println("Minimum coins greedy >> " + mcg.getMinimumCoinsGreedy(amount));
        System.out.println("Minimum coins dp >> " + mcg.getMinimumCoinsGreedy(amount));
    }
}
