package data.structures;

import java.time.Instant;

public class SearchBenchmarking {

    public int[] loadGenerator(int n) {
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            result[i] = i;
        }

        return result;
    }

    public int ternarySearch(int[] sortedList, int target) {
        int start = Instant.now().getNano();
        int left = 0;
        int right = sortedList.length - 1;

        while (left <= right) {
            int partitionSize = (right - left) / 3;
            int mid1 = left + partitionSize;
            int mid2 = right - partitionSize;

            if (sortedList[mid1] == target) {
                System.out.println("Ternary search runtime >> " + (Instant.now().getNano() - start) + "ns");
                return mid1; // Element found at index 'mid1'
            } else if (sortedList[mid2] == target) {
                System.out.println("Ternary search runtime >> " + (Instant.now().getNano() - start) + "ns");
                return mid2; // Element found at index 'mid2'
            } else if (target < sortedList[mid1]) {
                right = mid1 - 1; // Adjust the right boundary
            } else if (target > sortedList[mid2]) {
                left = mid2 + 1; // Adjust the left boundary
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }

        System.out.println("Ternary search runtime >> " + (Instant.now().getNano() - start) + "ns");
        return -1; // Element not found in the list
    }
    public int binarySearch(int[] sortedList, int target) {
        int start = Instant.now().getNano();
        int left = 0;
        int right = sortedList.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedList[mid] == target) {
                System.out.println("Binary search runtime >> " + (Instant.now().getNano() - start) + "ns");
                return mid; // Element found at index 'mid'
            } else if (sortedList[mid] < target) {
                left = mid + 1; // Adjust the left boundary
            } else {
                right = mid - 1; // Adjust the right boundary
            }
        }
        System.out.println("Binary search runtime >> " + (Instant.now().getNano() - start) + "ns");
        return -1; // Element not found in the list
    }



    public static void main(String[] args) {
        SearchBenchmarking sb = new SearchBenchmarking();
        int[] load = sb.loadGenerator(1_000_000_000);
        System.out.println("Running search for " + load.length + " elements");
        sb.binarySearch(load, 1_000_000_000);
        sb.ternarySearch(load, 1_000_000_000);
    }

}
