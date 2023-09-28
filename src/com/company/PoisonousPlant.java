package com.company;

import java.util.*;

public class PoisonousPlant {

    public static int poisonousPlant(List<Integer> p) {
        int counter = 0;
        Stack<Integer> st1 = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        q.addAll(p);
        st1.push(q.peek());
        while(!st1.isEmpty()) {
            Queue<Integer> mq = new LinkedList<>();
            mq.offer(null);
            counter++;
        }

        System.out.println(q.peek());
//        System.out.println(st2.toString());
        return counter;
    }
    public static void main(String[] args) {
        PoisonousPlant pp = new PoisonousPlant();
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(6);
        input.add(2);
        input.add(7);
        input.add(5);
        System.out.println(pp.poisonousPlant(input));
    }
}
