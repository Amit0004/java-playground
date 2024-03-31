package com.sde;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Link: https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm
 * Level: Medium
 */
public class BellmanFordAlgorithm {

    public int[] bellmanFord(int v, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] distance = new int[v];
        Arrays.fill(distance, (int)1e8);

        distance[s] = 0;

        // N-1 relaxation of edges
        for(int i = 0; i < v - 1; i++) {
            for(ArrayList<Integer> node : edges) {
                int from = node.get(0);
                int to = node.get(1);
                int weight = node.get(2);

                if(distance[from] != 1e8 && distance[from] + weight < distance[to]) {
                    distance[to] = distance[from] + weight;
                }
            }
        }

        // Nth relaxation of edges to check negative cycle
        for(ArrayList<Integer> node: edges) {
            int from = node.get(0);
            int to = node.get(1);
            int weight = node.get(2);

            if(distance[from] != 1e8 && distance[from] + weight < distance[to]) {
                return new int[]{-1};
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        BellmanFordAlgorithm bfa = new BellmanFordAlgorithm();
        int v = 3, s = 2;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(){{
            add(new ArrayList<>() {{
                add(0);
                add(1);
                add(5);
            }});
            add(new ArrayList<>() {{
                add(1);
                add(0);
                add(3);
            }});
            add(new ArrayList<>() {{
                add(1);
                add(2);
                add(-1);
            }});
            add(new ArrayList<>() {{
                add(2);
                add(0);
                add(1);
            }});
        }};

        int[] result = bfa.bellmanFord(v, edges, s);
        System.out.println("Bellman ford output >> " + Arrays.toString(result));
    }
}
