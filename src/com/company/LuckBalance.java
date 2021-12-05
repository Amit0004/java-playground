package com.company;

import java.util.*;

public class LuckBalance {


    public static int luckBalance(int k, List<List<Integer>> contests) {
        int totalLuck = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(List<Integer> l : contests) {
            if(map.containsKey(l.get(1))) {
                map.get(l.get(1)).add(l.get(0));
            } else {
                map.put(l.get(1), new ArrayList<>());
                map.get(l.get(1)).add(l.get(0));
            }
            totalLuck += l.get(0);
        }
        Collections.sort(map.get(1));
        for(int i = 0; i < (map.get(1).size() - k); i++) {
            totalLuck -= map.get(1).get(i);
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
        input = new ArrayList<>();
        c.add(1);
        c.add(1);
        input.add(c);
        input = new ArrayList<>();
        c.add(4);
        c.add(0);
        input.add(c);
        int k = 2;
        System.out.println(lb.luckBalance(k,input));
    }
}
