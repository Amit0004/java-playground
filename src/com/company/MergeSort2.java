package com.company;

import java.util.Arrays;

public class MergeSort2 {

    public static void mergesort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }

    public static void mergesort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergesort(arr, start, mid);
            mergesort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp =  new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while(i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while(j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for(i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }
    public static void main(String[] args) {
        MergeSort2 ms2 = new MergeSort2();
        int[] input = {9,3,5,2,3,1};
        ms2.mergesort(input);
        for(int i : input) {
            System.out.print(i + " ");
        }

    }
}
