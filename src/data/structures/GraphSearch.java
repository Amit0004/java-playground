package data.structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphSearch {

    private LinkedList<Integer> adjacent[];

    public GraphSearch(int v) {
        adjacent = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adjacent[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacent[source].add(destination);
        adjacent[destination].add(source);
    }

    public int bfs(int source, int destination) {
        boolean[] visited = new boolean[adjacent.length];
        int[] parent = new int[adjacent.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        parent[source] = -1;

        while(!q.isEmpty()) {
            int current = q.poll();
            if(current == destination) break;
            for(int neighbour: adjacent[current]) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    parent[neighbour] = current;
                    q.add(neighbour);
                }
            }
        }

        int current = destination;
        int distance = 0;
        while(parent[current] != -1) {
            System.out.print(current + " -> ");
            current = parent[current];
            distance++;
        }
        System.out.println(source);
        return distance;
    }

    public boolean dfsRecursive(int source, int destination) {
        boolean[] visited = new boolean[adjacent.length];
        visited[source] = true;
        return dfsRecursive(source, destination, visited);
    }

    /**
     * Depth first search using iterative approach
     * Used a stack to keep track of all the element to traverse
     * */
    private boolean dfsIterative(int source, int destination) {
        if(source == destination) return true;
        boolean[] visited = new boolean[adjacent.length];
        visited[source] = true;
        Stack<Integer> st = new Stack<>();
        st.push(source);

        while(!st.isEmpty()) {
            int current = st.pop();
            if(current == destination) return true;
            for(int neighbour: adjacent[source]) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    st.push(neighbour);
                }
            }
        }
        return false;
    }

    /**
     * Depth first search - Recursive approach
     * Check if a given path is present in a given graph
     * Does not gurantee a shortest path*/
    private boolean dfsRecursive(int source, int destination, boolean[] visited) {
        if(source == destination) return true;
        for(int neighbour: adjacent[source]) {
            if(!visited[neighbour]) {
                visited[neighbour] = true;
                return dfsRecursive(neighbour, destination, visited);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();

        GraphSearch graph = new GraphSearch(v);
        System.out.println("Enter " + e + " edges");

        for(int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.println("Enter source and destination");
        int source = sc.nextInt();
        int destination = sc.nextInt();
        System.out.println(graph.bfs(source, destination));
        System.out.println(graph.dfsRecursive(source, destination));
        System.out.println(graph.dfsIterative(source, destination));
    }
}
