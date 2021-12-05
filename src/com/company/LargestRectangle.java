package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Collections;

public class LargestRectangle {

    public static long largestRectangle(List<Integer> h) {
        Stack<Long> st = new Stack<>();
        Collections.sort(h);
        for(int i = 0; i < h.size() - 1; i++) {
            long area = h.get(i) * (h.size() - i);
            st.push(area);
        }
        return st.pop();
    }

    public static void main(String[] args) {
        LargestRectangle lr = new LargestRectangle();
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        System.out.println(lr.largestRectangle(input));
    }
}
