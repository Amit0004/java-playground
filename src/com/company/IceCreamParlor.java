package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceCreamParlor {

    public static void whatFlavors(List<Integer> cost, int money) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < cost.size(); i++) {
            map.put(cost.get(i), i);
        }
        int i = 0;
        while(money >= 0) {
            int diff = money - cost.get(i);
            if(map.containsKey(diff) && map.get(diff) != i) {
                result[0] = i;
                result[1] = map.get(diff);
                break;
            } else {
                i++;
            }
        }
        for(int j : result) {
            System.out.print(++j + " ");
        }
    }
    public static void main(String[] args) {
        IceCreamParlor icp = new IceCreamParlor();
        List<Integer> input = new ArrayList<>();
        input.add(4);
        input.add(3);
        input.add(2);
        input.add(5);
        input.add(7);
        int money = 8;
        icp.whatFlavors(input, money);
    }
}
