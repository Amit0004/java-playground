package com.dynamicprogramming;

import java.util.Arrays;

/**
 * Link: https://www.codingninjas.com/studio/problems/630471
 * Level: Medium
 */
public class CoinChangeCodingNinjas {

    public long countWaysToMakeChange(int coins[], int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 1; i <= amount; i++) {
            int sum = 0;
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] != 0) {
                    sum += dp[i] + dp[i - coins[j]] + 1;
                }
            }
            dp[i] = sum;
            sum = 0;

        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeCodingNinjas cccn  = new CoinChangeCodingNinjas();
        int[] coins = {1, 2, 3};
        int amount = 4;
        long output = cccn.countWaysToMakeChange(coins, amount);
        System.out.println("Coin changes > " + output);
    }
}
