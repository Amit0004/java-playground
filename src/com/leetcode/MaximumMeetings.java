package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Link: https://www.codingninjas.com/studio/problems/maximum-meetings_1062658
 * Level: Easy
 */
public class MaximumMeetings {

    class Meeting {
        public Integer start;
        public Integer end;
        public Meeting(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }
    public int maxMeetings(int[] start, int[] end, int n) {
        int result = 1;
        Arrays.sort(start);
        Stack<Meeting> meetings = new Stack<>();
        meetings.add(new Meeting(start[0], end[0]));
        for(int i = 1; i < n; i++) {
            Meeting m = meetings.peek();
            if(m.end < start[i]) {
                meetings.add(new Meeting(start[i], end[i]));
            }
        }
        return meetings.size();
    }

    public static void main(String[] args) {
        MaximumMeetings mm = new MaximumMeetings();
        int[] start = {668, 300, 36, 895, 704};
        int[] end = {1480, 623, 370, 1569, 1369};
        int output = mm.maxMeetings(start, end, start.length);
        System.out.println("Maximum meetings >> " + output);
    }
}
