package com.leetcode;

import java.util.*;

public class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals) {
        sort(intervals, 0);
        Stack<List<Integer>> st = new Stack<>();
        for(int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!st.isEmpty()) {
                List<Integer> current = st.peek();
                int lastStart = current.get(0);
                int lastEnd = current.get(1);
                if(start <= lastEnd) {
                    end = Math.max(lastEnd, end);
                    start = Math.min(lastStart, start);
                    st.pop();
                    st.push(List.of(start, end));
                } else {
                    st.push(List.of(start, end));
                }
            } else {
                st.push(List.of(start, end));
            }
        }

        int[][] mergedList = new int[st.size()][2];
        int left = st.size() - 1;
        while(!st.isEmpty()) {
            List<Integer> temp = st.pop();
            mergedList[left][0] = temp.get(0);
            mergedList[left][1] = temp.get(1);
            left--;
        };
        return mergedList;
    }

    public void sort(int[][] list, int col) {
        Arrays.sort(list, (a, b) -> Integer.compare(a[col],b[col]));
    }
    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {1, 2},
                {3, 8},
                {15, 18}
        };
        int[][] list = mi.mergeIntervals(intervals);
        Arrays.stream(list).forEach(li -> System.out.print(Arrays.toString(li) + " "));
//        System.out.println(Arrays.toString(list));
    }
}
