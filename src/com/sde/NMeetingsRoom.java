package com.sde;

import java.util.Arrays;

/**
 * Link: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 * Input:
 * N = 6
 * start[] = {1,3,0,5,8,5}
 * end[] =  {2,4,6,7,9,9}
 * Output:
 * 4
 */
public class NMeetingsRoom {
    public int maxMeeting(int[] start, int[] end, int n) {
        int result = 0;
        int currentEnd = Integer.MIN_VALUE;
        int[][] meetings = new int[n][3];

        for(int i = 0; i < n; i++) {
            meetings[i] = new int[]{start[i], end[i], i + 1};
        }
        Arrays.sort(meetings, (a, b) -> {
            if(a[1] < b[1]) {
                return -1;
            } else if(a[1] > b[1]) {
                return 1;
            } else if(a[2] < b[2]) {
                return -1;
            }
            return 1;
        });

        for(int[] meeting: meetings) {
            if(currentEnd < meeting[0]) {
                currentEnd = meeting[1];
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NMeetingsRoom nmr = new NMeetingsRoom();
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        int output = nmr.maxMeeting(start, end, start.length);
        System.out.println("N meeting output >> " + output);
    }
}
