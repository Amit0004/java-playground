package com.company;
import java.util.ArrayList;
import java.util.List;

public class Quicksort {

    public static List<Integer> quickSort(List<Integer> input) {
        quickSort(input, 0, input.size() - 1);
        return input;
    }

    public static void quickSort(List<Integer> input, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = input.get(((left + right) / 2));
        int index = partition(input, left, right, pivot);
        quickSort(input, left, index - 1);
        quickSort(input, index, right);
    }

    public static int partition(List<Integer> arr, int left, int right, int pivot) {
        while(left <= right) {
            while(arr.get(left) < pivot) {
                left++;
            }
            while(arr.get(right) > pivot) {
                right--;
            }
            if(left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(List<Integer> arr, int left, int right) {
        int temp = arr.get(left);
        arr.set(left, arr.get(right));
        arr.set(right, temp);
    }

    public static void main(String[] args) {
        Quicksort qs = new Quicksort();
        List<Integer> input = new ArrayList<>();

        input.add(9);
        input.add(8);
        input.add(3);
        input.add(7);
        input.add(5);
        input.add(0);

        for(int i : qs.quickSort(input)) {
            System.out.print(i + " ");
        }
    }
}
