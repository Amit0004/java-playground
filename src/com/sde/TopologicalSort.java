package com.sde;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Link: https://practice.geeksforgeeks.org/problems/topological-sort/1
 * Level: Medium
 */
public class TopologicalSort {

    /**
     * Topological sort using BFS
     * @param V
     * @param adj
     * @return
     */
    public int[] topologicalSortBFS(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];

        for(int i = 0; i < V; i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList();

        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] topo = new int[V];
        int index = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            topo[index++] = node;

            for(int it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }

    /**
     * Topological sort using DFS
     * @param V
     * @param adj
     * @return
     */
    public int[] topologicalSortDFS(int V, List<List<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++){
            if(visited[i] == 0) {
                dfs(i, visited, st, adj);
            }
        }

        int[] result = new int[V];
        int index = 0;
        while(!st.isEmpty()) {
            result[index++] = st.pop();
        }

        return result;
    }

    private void dfs(int node, int[] visited, Stack<Integer> st, List<List<Integer>> adj) {
        visited[node] = 1;

        for(Integer it : adj.get(node)) {
            if(visited[it] == 0) {
                dfs(it, visited, st, adj);
            }
        }
        st.push(node);
    }
}
