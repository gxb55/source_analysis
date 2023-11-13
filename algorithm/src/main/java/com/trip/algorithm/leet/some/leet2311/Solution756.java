package com.trip.algorithm.leet.some.leet2311;

/**
 * @author xbguo
 * @createTime 2023年11月12日 10:48:00
 */
public class Solution756 {
    public static void main(String[] args) {
        Solution756 solution756 = new Solution756();
        int[] row={0,4,5,3,2,1,6,7};
        int i = solution756.minSwapsCouples(row);
        System.out.println(i);
    }


    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int n = len / 2;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - unionFind.getCount();
    }

    private class UnionFind {

        private int[] parent;

        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            parent = new int[n];
            this.count = n;
            for (int i = 0; i < parent.length; i++) {
                // 自己指向自己
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int i = find(x);
            int j = find(y);
            if (i == j) {
                return;
            }
            // 至少交换的次数 = 所有情侣的对数 - 并查集里连通分量的个数
            count--;
            parent[i] = j;
        }
    }
}

