package data.structures;

import java.time.Instant;
import java.util.*;

/**
 * Sorting Algorithms
 * Selection Sort - TC: O(n2) SC: O(n)
 * Bubble Sort - TC: O(n2) SC: O(n)
 * Insertion Sort - TC: O(n2) SC: O(n)
 * Merge Sort - TC: O(nlogn) SC: O(n)
 * Quick Sort - TC: O(nlogn) SC: O(1)
 */
public class SortingAlgorithms {
    /**
     * Selection sort
     * Ref: https://www.youtube.com/watch?v=HGk_ypEuS24
     * @param nums
     * @return
     */
    public int[] selectionSort(int[] nums) {
        int start = Instant.now().getNano();
//        System.out.println("Selection sort started with input >> " + Arrays.toString(nums));
        for(int i = 0; i < nums.length; i++) {
            int min = i;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] < nums[min]) min = j;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        System.out.println("Selection sort runtime >> " + (Instant.now().getNano() - start) + "ns");
        return nums;
    }

    /**
     * Bubble sort
     * Ref: https://www.youtube.com/watch?v=HGk_ypEuS24
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
//        System.out.println("Bubble sort started with input >> " + Arrays.toString(nums));
        int start = Instant.now().getNano();
        boolean didSwap = false;
        for(int i = nums.length - 1; i >= 0; i--) {
            for(int j = 0; j < i - 1; j++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    didSwap = true;
                }
            }
            if(!didSwap) {
                break;
            }
        }
        System.out.println("Bubble sort runtime >> " + (Instant.now().getNano() - start) + "ns");
        return nums;
    }

    /**
     * InsertionSort
     * Ref: https://www.youtube.com/watch?v=HGk_ypEuS24
     * @param nums
     * @return
     */
    public int[] insertionSort(int[] nums) {
//        System.out.println("Insertion sort started with input >> " + Arrays.toString(nums));
        int start = Instant.now().getNano();
        for(int i = 0; i < nums.length - 1; i++) {
            int j = i;
            while(j > 0 && nums[j - 1] > nums[j]) {
                int temp = nums[j - 1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        System.out.println("Insertion sort runtime >> " + (Instant.now().getNano() - start) + "ns");
        return nums;
    }

    /**
     * Merge Sort
     * Ref: https://www.youtube.com/watch?v=ogjf7ORKfd8
     * @param nums
     * @return
     */
    public int[] mergeSort(int[] nums) {
        int start = Instant.now().getNano();
//        System.out.println("Merge sort started with input >> " + Arrays.toString(nums));
        mergeSortAlgorithm(nums, 0, nums.length - 1);
        System.out.println("Merge sort runtime >> " + (Instant.now().getNano() - start) + "ns");
        return nums;
    };

    private void mergeSortAlgorithm(int[] nums, int low, int high) {
        if(low == high) return;
        int mid = (high + low) / 2;
        mergeSortAlgorithm(nums, low, mid);
        mergeSortAlgorithm(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> res = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while(left <= mid && right <= high) {
            if(nums[left] <= nums[right]) {
                res.add(nums[left]);
                left++;
            } else {
                res.add(nums[right]);
                right++;
            }
        }

        while(left <= mid) {
            res.add(nums[left]);
            left++;
        }

        while(right <= high) {
            res.add(nums[right]);
            right++;
        }

        for(int i = low; i <= high; i++) {
            nums[i] = res.get(i - low);
        }
    }

    /**
     * QuickSort
     * Ref: https://www.youtube.com/watch?v=WIrA4YexLRQ
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums) {
        int start = Instant.now().getNano();
//        System.out.println("Quick sort started with input >> " + Arrays.toString(nums));
        quickSortAlgorithm(nums, 0, nums.length - 1);
        System.out.println("Quick sort runtime >> " + (Instant.now().getNano() - start) + "ns");
        return nums;
    }

    private void quickSortAlgorithm(int[] nums, int low, int high) {
        if(low < high) {
            int pivot = partition(nums, low, high);
            quickSortAlgorithm(nums, low, pivot - 1);
            quickSortAlgorithm(nums, pivot + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;
        while(i < j) {
            while(nums[i] <= pivot && i <= high - 1) i++;
            while(nums[j] > pivot && j >= low + 1) j--;
            if(i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, low, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] generateInput(int count) {
        int[] load = new int[count];
        for(int i = 0; i < count; i++) {
            load[i] = (int)(Math.random() * 10);
        }
        return load;
    }

    public static void main(String[] args) {
        SortingAlgorithms sA = new SortingAlgorithms();
        int[] input = {2,4,1,5,7,2,3,5,9};
        System.out.println("----------------------- Selection Sort Results ----------------------------");
        int[] selectionSort = sA.selectionSort(sA.generateInput(10));
        System.out.println("Result >> " + Arrays.toString(selectionSort));
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("----------------------- Bubble Sort Results -------------------------------");
        int[] bubbleSort = sA.bubbleSort(sA.generateInput(10));
        System.out.println("Result >> " + Arrays.toString(bubbleSort));
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("----------------------- Insertion Sort Results ----------------------------");
        int[] insertionSort = sA.insertionSort(sA.generateInput(10));
        System.out.println("Result >> " + Arrays.toString(insertionSort));
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("----------------------- Merge Sort Results --------------------------------");
        int[] mergeSortResult = sA.mergeSort(sA.generateInput(10));
        System.out.println("Result >> " + Arrays.toString(mergeSortResult));
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("----------------------- Quick Sort Results --------------------------------");
        int[] quickSort = sA.quickSort(sA.generateInput(10));
        System.out.println("Result >> " + Arrays.toString(quickSort));
        System.out.println("---------------------------------------------------------------------------");
    }
}
