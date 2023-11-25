package com.sde;

import java.util.*;

/**
 * Link: https://www.codingninjas.com/studio/problems/985311?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * Level: Hard
 */
public class KosarajuAlgorithm {

    public List<List<Integer>> stronglyConnectedComponent(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();

        // Prerequisite - Construct the adjacency list

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : edges) {
            adj.get(it[0]).add(it[1]);
        }

        System.out.println("<< Adjacency list >>");
        for (List<Integer> list : adj) {
            System.out.println(list.toString());
        }

        // Step 1: Sort the graph (Topological sort)
        int[] visited = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                dfs(i, adj, st, visited);
            }
        }
        // Step 2: Transpose the graph
        List<List<Integer>> transpose = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            transpose.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            visited[i] = 0;
            for(Integer it : adj.get(i)) {
                transpose.get(it).add(i);
            }
        }

        System.out.println("<< Transposed graph list >>");
        for (List<Integer> list : transpose) {
            System.out.println(list.toString());
        }

        // Step 3: Reverse Dfs
        while(!st.isEmpty()) {
            int node = st.pop();
            List<Integer> scc = new ArrayList<>();
            if(visited[node] == 0) {
                reverseDfs(node, transpose, visited, scc);
                result.add(scc);
                scc = new ArrayList<>();
            }
        }
        return result;
    }

    private void dfs(int node, List<List<Integer>> adj, Stack<Integer> st, int[] visited) {
        visited[node] = 1;
        for(Integer it : adj.get(node)) {
            if(visited[it] == 0) {
                dfs(it, adj, st, visited);
            }
        }
        st.push(node);
    }

    private void reverseDfs(int node, List<List<Integer>> transpose, int[] visited, List<Integer> scc) {
        visited[node] = 1;
        scc.add(node);
        for(Integer it : transpose.get(node)) {
            if(visited[it] == 0) {
                reverseDfs(it, transpose, visited, scc);
            }
        }
    }
    public static void main(String[] args) {
        KosarajuAlgorithm ka = new KosarajuAlgorithm();
        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {1, 4},
                {2, 3},
                {3, 2},
                {4, 0}
        };

        List<List<Integer>> scc = ka.stronglyConnectedComponent(n, edges);

        for (List<Integer> l : scc) {
            System.out.println(l.toString());
        }
    }
}
