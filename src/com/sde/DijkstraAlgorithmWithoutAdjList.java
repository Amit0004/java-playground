package com.sde;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Link: https://www.codingninjas.com/studio/problems/920469
 * Level: Medium
 */

/**
 * Class to store the node and the distance in Priority queue
 */
class NodeDistancePair {
    int node, distance;
    public NodeDistancePair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

/**
 * Shortest path using Dijkstra Algorithm using graph as input
 */
public class DijkstraAlgorithmWithoutAdjList {

    public ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> graph, int vertices, int edges, int source) {
        ArrayList<Integer> distance = new ArrayList<>();

        // Construct Adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = constructAdjacencyList(graph, vertices);

        // Initialize the distance array
        for(int i = 0; i < vertices; i++) {
            distance.add(Integer.MAX_VALUE);
        }

        // Set the source node to 0 in distance array
        distance.set(source, 0);

        // Initialize the Priority queue with source node and distance 0
        PriorityQueue<NodeDistancePair> pq = new PriorityQueue<NodeDistancePair>((x, y) -> x.distance - y.distance);
        pq.add(new NodeDistancePair(source, 0));

        // Start the DFS on priority queue
        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            int dist = pq.peek().distance;
            pq.poll();

            for(int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int weight = adj.get(node).get(i).get(1);

                if(dist + weight < distance.get(adjNode)) {
                    distance.set(adjNode, dist + weight);
                    pq.add(new NodeDistancePair(adjNode, distance.get(adjNode)));
                }
            }
        }

        return distance;
    }

    /**
     * Method for constructing adjacency list from the given graph
     * @param graph
     * @return Adjacency list
     */
    private ArrayList<ArrayList<ArrayList<Integer>>> constructAdjacencyList(ArrayList<ArrayList<Integer>> graph, int vertices) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for(int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        for(ArrayList<Integer> node : graph) {
            adj.get(node.get(0)).add(new ArrayList<>(){{
                add(node.get(1));
                add(node.get(2));
            }});

            // For undirected graph we need to add this
            adj.get(node.get(1)).add(new ArrayList<>(){{
                add(node.get(0));
                add(node.get(2));
            }});
        }

        System.out.println("<< Adjacency Matrix >>");
        for(int i = 0; i < vertices; i++) {
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
        DijkstraAlgorithmWithoutAdjList dawa = new DijkstraAlgorithmWithoutAdjList();

        int vertices = 5, edges = 7, source = 0;
        ArrayList<Integer> edge1 = new ArrayList<>(){{
            add(0);
            add(1);
            add(7);
        }};
        ArrayList<Integer> edge2 = new ArrayList<>(){{
            add(0);
            add(2);
            add(1);
        }};
        ArrayList<Integer> edge3 = new ArrayList<>(){{
            add(0);
            add(3);
            add(2);
        }};
        ArrayList<Integer> edge4 = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }};
        ArrayList<Integer> edge5 = new ArrayList<>(){{
            add(1);
            add(3);
            add(5);
        }};
        ArrayList<Integer> edge6 = new ArrayList<>(){{
            add(1);
            add(4);
            add(1);
        }};
        ArrayList<Integer> edge7 = new ArrayList<>(){{
            add(3);
            add(4);
            add(7);
        }};

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(){{
            add(edge1);
            add(edge2);
            add(edge3);
            add(edge4);
            add(edge5);
            add(edge6);
            add(edge7);
        }};

        System.out.println("<< Input graph >>");
        for(ArrayList<Integer> nodes: graph) {
            System.out.println(nodes.toString());
        }
        System.out.println("<< ----------- >>");

        ArrayList<Integer> distance = dawa.dijkstra(graph, vertices, edges, source);
        System.out.println("Shortest distance >> " + distance.toString());

    }
}
