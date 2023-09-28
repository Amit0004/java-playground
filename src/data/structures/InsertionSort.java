package data.structures;

public class InsertionSort {

    public int[] insertionSort(int[] input) {
        for(int i = 1 ; i < input.length; i++) {
            int temp = input[i];
            int j = i - 1;
            while(j >= 0 && input[j] > temp) {
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = temp;
        }
        return input;
    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] input = {3, 6, 1, 7, 8};
        for(int i : is.insertionSort(input)) {
            System.out.print(i + " ");
        }
    }
}
