package com.company;

/**
 * Move all the zero to the end of the list keeping order of non zero elements same
 * Input -> [1, 0, 3, 0, 12]
 * Output -> [1, 3, 12, 0, 0]
 * */
public class MoveZeroes {

    public static void moveZero(int[] input) {
        int index = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] != 0) {
                input[index++] = input[i];
            }
        }

        for(int i = index; i < input.length; i++) {
            input[i] = 0;
        }

        for(int i : input) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] input = {1, 0, 3, 0, 12};
        mz.moveZero(input);
    }
}
