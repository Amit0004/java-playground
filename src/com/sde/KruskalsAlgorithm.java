package com.sde;

import data.structures.DisjointSets;

import java.util.Arrays;

/**
 * Link: https://www.codingninjas.com/studio/problems/1082553?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * Level: medium
 */
public class KruskalsAlgorithm {

    public int kruskalsAlgorithm(int n, int[][] edges) {
        int mst = 0;

        // Sort the array in increasing weight order
        Arrays.sort(edges, (x, y) -> x[2] - y[2]);

        for(int[] row: edges) {
            System.out.println(Arrays.toString(row));
        }

        DisjointSets ds = new DisjointSets(n);

        for(int i = 0; i < edges.length; i++) {
            int wt = edges[i][2];
            int from = edges[i][0];
            int to = edges[i][1];

            if(ds.findUParent(from) != ds.findUParent(to)) {
                mst += wt;
                ds.unionBySize(from, to);
            }
        }

        return mst;
    }
    public static void main(String[] args) {
        KruskalsAlgorithm ka = new KruskalsAlgorithm();
        int n = 5;
        int[][] edges = {
                {1, 2, 6},
                {2, 3, 5},
                {3, 4, 4},
                {1, 4, 1},
                {1, 3, 2},
                {3, 5, 3}
        };

        int mst = ka.kruskalsAlgorithm(n, edges);
        System.out.println("Kruskals minimum >> " + mst);
    }
}
