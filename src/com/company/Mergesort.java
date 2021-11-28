package com.company;

import java.util.ArrayList;
import java.util.List;

public class Mergesort {

    public static void mergesort(List<Integer> arr) {
        if(arr.size() == 0) return;
        mergesort(arr, new int[arr.size()], 0, arr.size() - 1);
    }

    public static void mergesort(List<Integer> arr, int[] temp, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergesort(arr, temp, leftStart, middle);
        mergesort(arr, temp, middle + 1, rightEnd);
        merge(arr, temp, leftStart, rightEnd);
    }

    public static void merge(List<Integer> arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd) {
            if(arr.get(left) <= arr.get(right)) {
                temp[index] =  arr.get(left);
                left++;
            } else {
                temp[index] = arr.get(right);
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }
    public static void main(String[] args) {
        Mergesort ms = new Mergesort();
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(5);
        list.add(2);
        list.add(11);
        list.add(1);
        list.add(0);
        ms.mergesort(list);
//        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }
}
