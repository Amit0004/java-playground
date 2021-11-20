package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class FraudActivityNotification {

    public static int activityNotification(List<Integer> expenditure, int d) {
        int counter = 0;
        int slow = 0;
        for(int i = 0; i < expenditure.size(); i++) {
            if(i >= d) {
                float med = getMedian(expenditure, slow, i);
                if(expenditure.get(i) >= (int)(2 * med)) {
                    counter++;
                }
                slow++;
            } else {
                continue;
            }
        }
        return counter;
    }

    public static float getMedian(List<Integer> arr, int start, int end) {
        float median = 0.0f;
        List<Integer> list = new ArrayList<>();
        while(start <= end-1) {
            list.add(arr.get(start));
            start++;
        }
        Collections.sort(list);
        if(list.size() % 2 == 0) {
            median = (list.get(list.size() / 2) + list.get((list.size() + 1) / 2)) / 2;
        } else {
            median = list.get(list.size() / 2);
        }
        return median;
    }

    public static void main(String[] args) {
        List<Integer> exp = new ArrayList<>();
//        exp.add(10);
//        exp.add(20);
//        exp.add(30);
//        exp.add(40);
//        exp.add(50);
        exp.add(1);
        exp.add(2);
        exp.add(3);
        exp.add(4);
        exp.add(4);
        FraudActivityNotification fan = new FraudActivityNotification();
        System.out.println(fan.activityNotification(exp, 4));
    }
}
