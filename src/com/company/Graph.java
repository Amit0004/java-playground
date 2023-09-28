package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {

    private LinkedList<Integer> adj[];

    public Graph(int v) {
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public String toString() {
        return adj.toString();
    }

    public int bfs(int source, int destination) {
        boolean[] vis = new boolean[adj.length];
        int[] parent = new int[adj.length];
        Queue<Integer> queue = new LinkedList();
        queue.offer(source);
        parent[source] = -1;
        vis[source] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == destination) break;
            for(int neighbour: adj[cur]) {
                if(!vis[neighbour]) {
                    vis[neighbour] = true;
                    parent[neighbour] = cur;
                    queue.add(neighbour);
                }
            }
        }
        int cur = destination;
        int distance = 0;
        while(parent[cur] != -1) {
            System.out.print(cur + " -> ");
            cur = parent[cur];
            distance++;
        }

        return distance;
    }

    public boolean dfs(int source, int destination) {
        if(source == destination) return true;
        boolean[] vis = new boolean[adj.length];
        return dfsUtil(source, destination, vis);

    }

    private boolean dfsUtil(int source, int destination, boolean vis[]) {
        if(source == destination) return true;
        for(int neighbour: adj[source]) {
            if(!vis[neighbour]) {
                vis[neighbour] = true;
                boolean isConnected = dfsUtil(neighbour, destination, vis);
                if(isConnected) return true;
            }
        }
        return false;
    }

    public boolean dfsStack(int source, int destination) {
        boolean[] vis = new boolean[adj.length];
        vis[source] = true;
        Stack<Integer> s = new Stack<>();
        s.push(source);

        while(!s.isEmpty()) {
            int cur = s.pop();
            if(cur == destination) return true;
            for(int neighbour: adj[cur]) {
                if(!vis[neighbour]) {
                    vis[neighbour] = true;
                    s.push(neighbour);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();

        Graph graph = new Graph(v);
        System.out.println("Enter " + e + " edges");
        for(int i = 0; i < e; i++) {
            int destination = sc.nextInt();
            int source = sc.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.println("Enter source and destination");
        int source = sc.nextInt();
        int destination = sc.nextInt();

        System.out.println("min distance " + graph.bfs(source, destination));
        System.out.println("possible " + graph.dfs(source, destination));
        System.out.println("possible " + graph.dfsStack(source, destination));

    }
}
