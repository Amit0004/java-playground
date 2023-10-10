package com.dynamicprogramming;

public class EggDrop {
    public int twoEggDrop(int n) {

        return solve(2, n);
    }

    public int solve(int e, int f) {
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;
        int min = Integer.MAX_VALUE;

        for(int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(
                    solve(e - 1, k - 1), solve(e, f - k)
            );

            min = Math.min(min, temp);
        }
        return min;
    }
    public static void main(String[] args) {
        EggDrop ed = new EggDrop();
        int floor = 100;
        int output = ed.twoEggDrop(floor);
        System.out.println("Egg drop recursive output >> " + output);
    }
}
