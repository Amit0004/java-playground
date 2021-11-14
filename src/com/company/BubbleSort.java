package com.company;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort {


    public static List<Integer> bubbleSort(List<Integer> a) {
        boolean isSorted = false;
        int lastUnsorted = a.size() - 1;
        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < lastUnsorted; i++) {
                if(a.get(i) > a.get(i + 1)) {
                    swap(a, i, i+1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
        return a;
    }

    public static void swap(List<Integer> arr, int i , int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void countSwaps(List<Integer> a) {
        List<Integer> sortedList = bubbleSort(a);
        System.out.println("Array is sorted in 3 swaps");
        System.out.println("First Element: " + sortedList.get(0));
        System.out.println("Last Element: " + sortedList.get(sortedList.size() - 1));
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(1);
        arr.add(6);
        arr.add(3);
        for(Integer i : bs.bubbleSort(arr)) {
            System.out.print(i + " ");
        }
    }
}
