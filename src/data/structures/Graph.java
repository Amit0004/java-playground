package data.structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {

    private LinkedList<Integer> adjacent[];

    public Graph(int v) {
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

    public boolean dfs(int source, int destination) {
        boolean[] visited = new boolean[adjacent.length];
        visited[source] = true;
        return dfs(source, destination, visited);
    }

    private boolean dfs(int source, int destination, boolean[] visited) {
        if(source == destination) return true;
        for(int neighbour: adjacent[source]) {
            if(!visited[neighbour]) {
                visited[neighbour] = true;
                return dfs(neighbour, destination, visited);
            }
        }
        return false;
    }

    public boolean dfsRecursive(int source, int destination) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[adjacent.length];
        st.push(source);

        while(!st.isEmpty()) {
            int current = st.pop();
            if(current == destination) return true;

            for(int neighbour: adjacent[current]) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    st.push(neighbour);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();

        Graph graph = new Graph(v);
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
        System.out.println(graph.dfs(source, destination));
        System.out.println(graph.dfsRecursive(source, destination));
    }
}
