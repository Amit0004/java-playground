package interview.set;

import java.util.Arrays;

/**
 * Find the maximum sum of a subarray of size K
 * Input: arr : [2, 5, 6, 7, 3, 4], k : 3
 * Output: 18
 * Concept Used: Sliding Window
 */
public class MaximumSumSubarray {

    /**
     * Find the maximum sum of a subarray of size K
     * Input: arr : [2, 5, 6, 7, 3, 4], k : 3
     * Output: 18
     * Concept Used: Sliding Window
     */
    public int findMaxSubarray(int[] arr, int k) {
        if(arr.length == 0) {
            return 0;
        }

        int n = arr.length, i = 0, j = 0, sum = 0, maxSum = 0;
        while(j < n) {
            sum += arr[j];
            if(j - i + 1 < k) {
                j++;
            } else {
                maxSum = Math.max(sum, maxSum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }

    /**
     * Print the first negative number in every window of size k
     * Input: arr: [2, -1, 3, 4, -6, 4, 5], k : 3
     * Output: -1, -1, -6, -6, -6
     * @param arr
     * @param k
     */
    public void findFirstNegativeInteger(int[] arr, int k) {
        int i = 0, j = 0, n = arr.length;

        while(j < n) {
            if(j - i + 1 < k) {
                j++;
            } else {
                for(int p = i; p <= j; p++) {
                    if(arr[p] < 0) {
                        System.out.print(arr[p] + " ");
                        break;
                    }
                }
                i++;
                j++;
            }
        }
            System.out.println();
    }
    public static void main(String[] args) {
        int [] input = {2, 5, 6, 7, 3, 4};
        int k = 3;
        MaximumSumSubarray mss = new MaximumSumSubarray();
        int max = mss.findMaxSubarray(input, k);

        int[] negative = {12, -1, -7, 8, -15, 30, 16, 28};
        mss.findFirstNegativeInteger(negative, k);
        System.out.println("Sum >> " + max);
    }
}
