package com.sde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Link: https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 * Level: Medium
 */

 class NodeDistance {
    int node, distance;

    public NodeDistance(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
public class DijkstraAlgorithm {
    public int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        PriorityQueue<NodeDistance> pq = new PriorityQueue<NodeDistance>((x, y) -> x.distance - y.distance);

        int[] distance = new int[v];

        // initialize the distance array
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Set the source node distance as 0
        distance[s] = 0;

        // Insert the source node and distance in priority queue
        pq.add(new NodeDistance(s, 0));

        // Iterate on the priority queue
        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            int dist = pq.peek().distance;
            pq.poll();

            for(int i = 0; i < adj.get(i).size(); i++) {
                int weight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                // If the current distance is smaller than the distance update the distance array
                if(dist + weight < distance[adjNode]) {
                    distance[adjNode] = dist + weight;
                    pq.add(new NodeDistance(adjNode, distance[adjNode]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        DijkstraAlgorithm da = new DijkstraAlgorithm();
        int V = 3, E = 3, S = 2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{
            add(1);
            add(1);
        }};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{
            add(2);
            add(6);
        }};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{
            add(2);
            add(3);
        }};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{
            add(0);
            add(1);
        }};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{
            add(1);
            add(3);
        }};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{
            add(0);
            add(6);
        }};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>() {
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>() {
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };

        int[] result = da.dijkstra(V, adj, S);
        System.out.println("Shortest path >> " + Arrays.toString(result));
    }
}
