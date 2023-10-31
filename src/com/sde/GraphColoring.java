package com.sde;

import java.util.List;

/**
 * Link: https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
 * Link: https://www.codingninjas.com/studio/problems/m-coloring-problem_981273
 * Concepts: Recursion and Backtracking
 * Level: Medium
 */
public class GraphColoring {
    public static boolean graphColoring(List< Integer >[] G, int[] color, int i, int C) {
        // Your code here
        int n = G.length;
        if (solve(i, G, color, n, C)) return true;
        return false;
    }
    private static boolean isSafe(int node, List < Integer > [] G, int[] color, int n, int col) {
        for (int it: G[node]) {
            if (color[it] == col) return false;
        }
        return true;
    }
    private static boolean solve(int node, List < Integer > [] G, int[] color, int n, int m) {
        if (node == n) return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, G, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, G, color, n, m) == true) return true;
                color[node] = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<Integer>[] graph = new List[]{List.of(
                List.of(0, 1, 0),
                List.of(1, 0, 1),
                List.of(0, 1, 0))};
        int m = 2;
        int n = 3;

        GraphColoring gc = new GraphColoring();
        boolean output = gc.graphColoring(graph, m);
        System.out.println("Graph coloring output >> " + output);
    }
}
