package com.sde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Next Permutation
 * Link: https://www.codingninjas.com/studio/problems/893046?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 */
public class NextPermutation {


    public ArrayList<Integer> nextPermutation(ArrayList<Integer> input) {
        int ind = -1;
        int n = input.size();

        for(int i = n - 2; i >=0; i--) {
            if(input.get(i) < input.get(i + 1)) {
                ind = i;
                break;
            }
        }

        if(ind == -1) {
            Collections.reverse(input);
            return input;
        }

        for(int i = n - 1; i > ind; i--) {
            if(input.get(i) > input.get(ind)) {
                int temp = input.get(ind);
                input.set(ind, input.get(i));
                input.set(i, temp);
                break;
            }
        }

        Collections.reverse(input.subList(ind + 1, n));
        return input;
    }
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(2, 3, 1, 4, 5));
        ArrayList<Integer> result = np.nextPermutation(input);
        System.out.println("Next Permutations >> " + result);
    }
}
