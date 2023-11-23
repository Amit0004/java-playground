package com.sde;

import java.util.*;

public class CycleDetectionUndirectedBFS {

    public static String cycleDetection(int[][] edges, int n, int m) {
        List<Integer>[] adj = new List[n + 1];

        System.out.println("size >> " + adj.length);

        for (int[] node : edges) {
            int from = node[0];
            int to = node[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }
            adj[from].add(to);
        }

        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (detectCycle(adj, i, visited)) {
                    return "Yes";
                }
            }
        }

        return "No";
    }

    private static boolean detectCycle(
            List<Integer>[] adj, int node, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{node, -1});
        visited[node] = true;

        while (!q.isEmpty()) {
            int cur = q.peek()[0];
            int parent = q.peek()[1];
            q.remove();

            if (adj[cur] != null)
                for (Integer ii : adj[cur]) {
                    if (!visited[ii]) {
                        q.add(new int[]{ii, cur});
                        visited[ii] = true;
                    } else if (parent != ii) {
                        return true;
                    }
                }
        }

        return false;
    }

    public static void main(String[] args) {
        CycleDetectionUndirectedBFS cdub = new CycleDetectionUndirectedBFS();
        int[][] edges = {
                {2, 1},
                {3, 1},
        };
        int n = 3;
        int m = 2;

        System.out.println("Cycle >> " + cdub.cycleDetection(edges, n, m));
    }
}
