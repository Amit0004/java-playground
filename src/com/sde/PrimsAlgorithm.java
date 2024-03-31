package com.sde;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Link: https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
 * Level: medium
 */

class MSTPair {
    int node, distance, parent;

    public MSTPair(int node, int weight, int parent) {
        this.parent = parent;
        this.node = node;
        this.distance = weight;
    }
}
public class PrimsAlgorithm {

    public int minimumSpanningTree(int v, int e, int[][] edges) {
        int sum = 0;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = constructAdjacencyList(edges, v);
        ArrayList<ArrayList<Integer>> mst = new ArrayList<>();

        PriorityQueue<MSTPair> pq = new PriorityQueue<MSTPair>((x, y) -> x.distance - y.distance);

        int[] visited = new int[v + 1];
        pq.add(new MSTPair(0, 0, 0));

        while(!pq.isEmpty()) {
            int weight = pq.peek().distance;
            int node = pq.peek().node;
            int parent = pq.peek().parent;
            pq.remove();

            if(visited[node] == 1) continue;

            mst.add(new ArrayList<>(){{
                add(parent);
                add(node);
                add(weight);
            }});

            visited[node] = 1;
            sum += weight;

            for(int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (visited[adjNode] == 0) {
                    pq.add(new MSTPair(adjNode, edW, node));
                }
            }
        }

        System.out.println("<< Minimum Spanning tree >>");
        for(ArrayList<Integer> list: mst) {
            System.out.println(list.toString());
        }

        return sum;
    }

    private ArrayList<ArrayList<ArrayList<Integer>>> constructAdjacencyList(int[][] edges, int v) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < edges.length; i++) {
            int finalI = i;
            adj.get(edges[i][0]).add(new ArrayList<>(){{
                add(edges[finalI][1]);
                add(edges[finalI][2]);
            }});

            adj.get(edges[i][1]).add(new ArrayList<>(){{
                add(edges[finalI][0]);
                add(edges[finalI][2]);
            }});
        }

        System.out.println("<< Adjacency Matrix >>");
        for(int i = 0; i < v; i++) {
            System.out.print("Node : " + i + " -> ");
            if(adj.get(i).isEmpty()) {
                System.out.print(adj.get(i).toString());
            } else {
                for(ArrayList<Integer> node : adj.get(i)) {
                    System.out.print(node.toString());
                }
            }
            System.out.println();
        }
        System.out.println("<< ---------------- >>");

        return adj;
    }
    public static void main(String[] args) {
        PrimsAlgorithm pa = new PrimsAlgorithm();
        int v = 7, e = 7;
        int[][] edges = {
                {0, 1, 3},
                {1, 3, 3},
                {1, 5, 10},
                {2, 4, 6},
                {2, 6, 9},
                {3, 6, 8},
                {4, 5, 6}
        };

        int output = pa.minimumSpanningTree(v, e, edges);
        System.out.println("Minimum spanning tree >> " + output);
        int[] run = new int[10];

    }
}
