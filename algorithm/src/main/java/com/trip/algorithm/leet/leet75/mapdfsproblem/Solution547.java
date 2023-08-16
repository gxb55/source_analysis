package com.trip.algorithm.leet.leet75.mapdfsproblem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/8/16 15:40
 */
public class Solution547 {
    public static void main(String[] args) {
        Solution547 solution547 =new Solution547();
        //int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        //int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        int[][] isConnected = {
                {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
        int circleNum = solution547.findCircleNum(isConnected);
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] isConnected) {
        int i = isConnected.length;
        UnionFind547 unionFind547 = new UnionFind547(i);
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                if(isConnected[j][k]==1){
                    unionFind547.union(j, k);
                }
            }
        }
        Integer count = unionFind547.getCount();
        return count;
    }
}

class UnionFind547 {

    public int[] parent;

    public UnionFind547(int n) {
        this.parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    /**
     * x指向y
     */
    public void union(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i == j) {
            return;
        }
        for (int k = 0; k < parent.length; k++) {
            if(parent[k]==i){
                parent[k]=j;
            }
        }
        parent[i] = j;
    }

    public int find(int x) {
        if (parent[x] != x) {
            int i = parent[x];
            parent[x] = find(i);
        }
        return parent[x];
    }

    public Integer getCount() {
        Set<Integer> res = new HashSet<>();
        for (int x : parent) {
            res.add(x);
        }
        return res.size();
    }
}