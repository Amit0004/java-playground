package com.company;
import java.util.Comparator;

import java.util.*;

public class LuckBalance {

    public static int luckBalance(int k, List<List<Integer>> contests) {
        int totalLuck = 0;
        Collections.sort(contests, (Comparator<List<Integer>>) (a, b) -> -1 * Integer.compare(a.get(0), b.get(0)));
        for(int i = 0; i < contests.size(); i++) {
            int luck = contests.get(i).get(0);
            int importance = contests.get(i).get(1);

            if(importance == 1 && k > 0) {
                k--;
                totalLuck += luck;
            } else if(importance == 1 && k == 0) {
                totalLuck -= luck;
            }
            if(importance == 0) {
                totalLuck += luck;
            }
        }
        return totalLuck;
    }

    public static void main(String[] args) {
        LuckBalance lb = new LuckBalance();
        List<Integer> c = new ArrayList<>();
        List<List<Integer>> input = new ArrayList<>();
        c.add(5);
        c.add(1);
        input.add(c);
        c = new ArrayList<>();
        c.add(4);
        c.add(0);
        input.add(c);
        c = new ArrayList<>();
        c.add(6);
        c.add(1);
        input.add(c);
        c = new ArrayList<>();
        c.add(2);
        c.add(1);
        input.add(c);
        c = new ArrayList<>();
        c.add(8);
        c.add(0);
        input.add(c);

        int k = 2;
        System.out.println(lb.luckBalance(k,input));
    }
}
