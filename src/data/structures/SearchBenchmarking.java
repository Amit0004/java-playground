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

    public int quadarySearch(int[] arr, int target) {
        int start = Instant.now().getNano();
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid1 = low + (high - low) / 4;
            int mid2 = low + (high - low) / 2;
            int mid3 = low + 3 * (high - low) / 4;

            if (arr[mid1] == target) {
                System.out.println("Quadary search runtime >> " + (Instant.now().getNano() - start) + "ns");
                return mid1;
            } else if (arr[mid2] == target) {
                System.out.println("Quadary search runtime >> " + (Instant.now().getNano() - start) + "ns");
                return mid2;
            } else if (arr[mid3] == target) {
                System.out.println("Quadary search runtime >> " + (Instant.now().getNano() - start) + "ns");
                return mid3;
            }

            if (target < arr[mid1]) {
                high = mid1 - 1;
            } else if (target < arr[mid2]) {
                low = mid1 + 1;
                high = mid2 - 1;
            } else if (target < arr[mid3]) {
                low = mid2 + 1;
                high = mid3 - 1;
            } else {
                low = mid3 + 1;
            }
        }
        System.out.println("Quadary search runtime >> " + (Instant.now().getNano() - start) + "ns");
        return -1; // Element not found
    }



    public static void main(String[] args) {
        SearchBenchmarking sb = new SearchBenchmarking();
        int[] load = sb.loadGenerator(1_000_000);
        System.out.println("Running search for " + load.length + " elements");
        sb.binarySearch(load, 878987);
        sb.ternarySearch(load, 878987);
        sb.quadarySearch(load, 878987);
    }

}
