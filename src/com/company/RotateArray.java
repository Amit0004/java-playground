package com.company;
import java.util.*;

public class RotateArray {

    public static List<Integer> rotateArray(List<Integer> arr, int d) {
        List<Integer> result = new ArrayList<>();
        d %= arr.size();
        int len = arr.size();
        result = reverse(arr, 0, len - 1);
        result = reverse(arr, 0, len - d - 1);
        return reverse(arr, len - d, len -1);
    }

    public static List<Integer> reverse(List<Integer> a, int start, int end) {
        while(start < end) {
            int temp = a.get(start);
            a.set(start, a.get(end));
            a.set(end, temp);
            start++;
            end--;
        }
        return a;
    }
}
