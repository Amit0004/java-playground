package com.sde;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Link: https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 * Link: https://www.codingninjas.com/studio/problems/fractional-knapsack_975286
 * Level: Easy
 * Concept Used: Greedy + Fractional Knapsack
 */
class Pair {
    int weight;
    int value;
    Pair(int weight, int value)
    {
        this.weight = weight;
        this.value = value;
    }

}
public class FractionalKnapsack {
    class ItemComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            double r1 = (double)a.value / (double) a.weight;
            double r2 = (double) b.value / (double) b.weight;
            return Double.compare(r2, r1);
        }
    }

    public double maximumValue(Pair[] items, int n, int w) {
        double result = 0.0;
        Arrays.sort(items, new ItemComparator());

        int currentWeight = 0;
        for(int i = 0; i < n; i++) {
            if(currentWeight + items[i].weight <= w) {
                currentWeight += items[i].weight;
                result += items[i].value;
            } else {
                int remain = w - currentWeight;
                result += ((double) items[i].value / (double) items[i].weight) * (double) remain;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FractionalKnapsack fk = new FractionalKnapsack();
        Pair[] input = {
                new Pair(50, 40),
                new Pair(40, 50),
                new Pair(90, 25),
                new Pair(120, 100),
                new Pair(10, 30),
                new Pair(200, 45),
        };

        int n = 6, w = 200;

        double output = fk.maximumValue(input, n, w);
        System.out.println("Fractional knapsack output >> " + output);
    }
}
