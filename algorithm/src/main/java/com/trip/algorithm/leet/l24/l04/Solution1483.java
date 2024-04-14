package com.trip.algorithm.leet.l24.l04;

import java.util.Arrays;

public class Solution1483 {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {-1, 0, 0, 1, 1, 2, 2};
        TreeAncestor treeAncestor = new TreeAncestor(n, arr);
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(3 >> 1);
    }
}

class TreeAncestor {
    int[][] dp = null;

    public TreeAncestor(int n, int[] parent) {
        dp = new int[n][16];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x, -1));
        for (int i = 0; i < parent.length; i++) {
            // 给i节点的父节点赋值
            dp[i][0] = parent[i];
        }
        for (int i = 1; i < 16; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(dp[j][i-1]==-1){
                    continue;
                }
                dp[j][i]=dp[dp[j][i-1]][i-1];
            }
        }
    }


    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < 16; i++) {
            if (((k >> i) & 1) != 0) {
                node = dp[node][i];
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
}

