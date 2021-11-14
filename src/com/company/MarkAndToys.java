package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarkAndToys {

    public static Integer maximumToys(List<Integer> prices, int k) {
        int max = 0;
        Collections.sort(prices);
        for(int i = 0; i < prices.size() - 1; i++) {
            k = k - prices.get(i);
            if(k >= 0) {
                max++;
            } else {
                break;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        MarkAndToys mt = new MarkAndToys();
        List<Integer> prices = new ArrayList<>();
        prices.add(1);
        prices.add(12);
        prices.add(5);
        prices.add(111);
        prices.add(200);
        prices.add(1000);
        prices.add(10);
        int budget = 50;
        System.out.println(mt.maximumToys(prices, budget));
    }
}
