package data.structures;

public class BubbleSort {


    public int[] bubbleSort(int[] input) {
        int pass, swapped = 1, temp;
        for(pass = input.length - 1; pass >= 0; pass--) {
            swapped = 0;
            for(int i = 0; i <= pass - 1; i++) {
                if(input[i] > input[i+1]) {
                    temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                    swapped = 1;
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] input = {3, 6, 1, 7, 8};
        for(int i : bs.bubbleSort(input)) {
            System.out.print(i + " ");
        }
    }
}
