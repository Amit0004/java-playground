package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Find132Pattern {

    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int min = Integer.MIN_VALUE;

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<min){
                return true;
            }
            while(!st.empty() && st.peek()<nums[i]){
                min = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Find132Pattern fp = new Find132Pattern();
        int[] nums = {1,3,2,4,5,6,7,8,9,10};
        System.out.println(fp.find132pattern(nums));
    }
}
