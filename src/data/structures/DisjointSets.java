package data.structures;

import java.util.ArrayList;
import java.util.List;

public class DisjointSets {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSets(int n) {
        for(int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(0);
        }
    }

    public int findUParent(int node) {
        if(node == parent.get(node)) {
            return node;
        }

        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int parentOfu = findUParent(u);
        int parentOfv = findUParent(v);

        if(parentOfu == parentOfv) return;

        if(rank.get(parentOfu) < rank.get(parentOfv)) {
            parent.set(parentOfu, parentOfv);
        } else if(rank.get(parentOfv) < rank.get(parentOfu)) {
            parent.set(parentOfv, parentOfu);
        } else {
            parent.set(parentOfv, parentOfu);
            int rankOfu = rank.get(parentOfu);
            rank.set(parentOfu, rankOfu + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int parentOfu = findUParent(u);
        int parentOfv = findUParent(v);

        if(parentOfu == parentOfv) return;

        if(size.get(parentOfu) < size.get(parentOfv)) {
            parent.set(parentOfu, parentOfv);
            size.set(parentOfv, size.get(parentOfu) + size.get(parentOfv));
        } else {
            parent.set(parentOfv, parentOfu);
            size.set(parentOfu, size.get(parentOfu) + size.get(parentOfv));
        }
    }

    public static void main(String[] args) {
        DisjointSets ds = new DisjointSets(5);
        ds.unionByRank(0, 1);
        ds.unionByRank(0, 2);
        ds.unionByRank(3, 2);
        ds.unionByRank(4, 4);

        System.out.println(ds.findUParent(4));
    }
}
