package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pairs {

    public static int pairs(int k, List<Integer> arr) {
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.size(); i++) {
            map.put(arr.get(i), i);
        }
        for(int i = 0; i < arr.size(); i++) {
            int current = arr.get(i) + k;
            if(map.containsKey(current) && map.get(current) != i) {
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        Pairs p = new Pairs();
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(5);
        input.add(3);
        input.add(4);
        input.add(2);
        System.out.println(p.pairs(2, input));
    }
}
