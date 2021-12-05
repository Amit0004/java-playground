package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class FraudActivityNotification {

    public static int activityNotification(List<Integer> expenditure, int d) {
        int[] eList = expenditure.stream().mapToInt(i->i).toArray();
        int[] count = new int[201];
        int result = 0;
        for(int i = 0; i < d; i++) {
            count[eList[i]]++;
        }
        for(int i = d; i < eList.length; i++) {
            int median = (int)getMedian(count, d);
            if(median <= eList[i]) {
                result++;
            }
            count[eList[i-d]]--;
            count[eList[i]]++;
        }
        return result;
    }

    public static float getMedian(int[] count, int d) {
        int sum = 0;
        for(int i = 0; i < count.length; i++) {
            sum += count[i];
            if(2*sum == d) {
                return (2*i+1);
            } else if((2*sum) > d) {
                return(i*2);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        List<Integer> exp = new ArrayList<>();
        exp.add(10);
        exp.add(20);
        exp.add(30);
        exp.add(40);
        exp.add(50);
//        exp.add(1);
//        exp.add(2);
//        exp.add(3);
//        exp.add(4);
//        exp.add(4);
        FraudActivityNotification fan = new FraudActivityNotification();
        System.out.println(fan.activityNotification(exp, 3));
    }
}
