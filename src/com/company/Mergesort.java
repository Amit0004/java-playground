package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mergesort {

    public static void mergesort(int[] arr) {
        mergesort(arr, new int[arr.length], 0, arr.length - 1);
    }

    public static void mergesort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd) return;
        int middle = (leftStart + rightEnd) / 2;
        mergesort(arr, temp, leftStart, middle);
        mergesort(arr, temp, middle + 1, rightEnd);
        merge(arr, temp, leftStart, rightEnd);
    }

    public static void merge(int[] arr, int[] temp,  int start, int end) {
        int leftEnd = (end + start) / 2;
        int rightStart = leftEnd + 1;
        int size = end - start + 1;

        int left = start;
        int right = rightStart;
        int index = start;

        while(left <= leftEnd && right <= end) {
            if(arr[left] < arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, end - right + 1);
        System.arraycopy(temp, start, arr, start, size);
    }

    public static void main(String[] args) {
        Mergesort ms = new Mergesort();
        int[] input = {9,2,6,3,7,3,11};
        ms.mergesort(input);

        for(int i : input) {
            System.out.print(i + " ");
        }

    }
}
