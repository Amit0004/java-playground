package com.sde;

import java.util.Arrays;
import java.util.Stack;

/**
 * Link: https://www.codingninjas.com/studio/problems/stock-span_5243295
 * Level: Medium
 */
public class StockSpan {
    public int[] stockSpan(int[] stocks) {
        int[]span = new int[stocks.length];

        //The stack stores last day with a stock greater than this day
        Stack<Integer>days = new Stack<Integer>();

        days.push(0);
        span[0] = 1;
        for(int i = 1 ; i < stocks.length ; i++){

            while(!days.isEmpty() && stocks[days.peek()]<=stocks[i]){
                days.pop();
            }

            if(!days.isEmpty())
                span[i] = i - days.peek();
            else
                span[i] = 1;
            days.push(i);

        }
        return span;
    }
    public static void main(String[] args) {
        StockSpan ss = new StockSpan();
        int[] input = {100, 80, 60, 70, 60, 75, 85};
        int[] result = ss.stockSpan(input);
        System.out.println("Stock Span >> " + Arrays.toString(result));
    }
}
