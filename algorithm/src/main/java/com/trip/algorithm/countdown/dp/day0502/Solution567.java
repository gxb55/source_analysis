package com.trip.algorithm.countdown.dp.day0502;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author xbguo
 * @createTime 2023年05月02日 18:57:00
 */
public class Solution567 {
    public static void main(String[] args) {
        Solution567 solution567 = new Solution567();
        // int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        int m = 8, n = 50, maxMove = 23, startRow = 5, startColumn = 26;
        //  int m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1;

        int paths = solution567.findPaths1(m, n, maxMove, startRow, startColumn);
        System.out.println(paths);
    }


    public int findPaths1(int m, int n, int maxMove, int startRow, int startColumn) {
        return process(m, n, maxMove, startRow, startColumn);
    }

    static Map<String, Long> map = new HashMap<>();
    static int mod = 1000000007;

    private int process(int m, int n, int resCount, int curRow, int cutColumn) {
        if (resCount < 0) {
            return 0;
        }
        if (map.containsKey(curRow + "_" + cutColumn + "_" + resCount)) {
            return (int) (map.get(curRow + "_" + cutColumn + "_" + resCount) % mod);
        }
        if (curRow < 0 || curRow >= m || cutColumn < 0 || cutColumn >= n) {
            if (resCount >= 0) {
                return 1;
            }
        }
        long res = (process(m, n, resCount - 1, curRow - 1, cutColumn) % mod
                + process(m, n, resCount - 1, curRow + 1, cutColumn) % mod) % mod
                + (process(m, n, resCount - 1, curRow, cutColumn + 1) % mod
                + process(m, n, resCount - 1, curRow, cutColumn - 1) % mod) % mod;
        String s = curRow + "_" + cutColumn + "_" + resCount;
        map.put(s, res % mod);
        return (int) (res % mod);
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startColumn, maxMove});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2];
            if (z < 0) {
                continue;
            }
            if (x < 0 || x >= m || y < 0 || y >= n) {
                if (z >= 0) {
                    count = count + 1;
                    count = count % mod;
                    // System.out.println("x:"+x+" y:"+y+" z:"+z);
                }
                continue;
            }
            queue.add(new int[]{x - 1, y, z - 1});
            queue.add(new int[]{x, y - 1, z - 1});
            queue.add(new int[]{x + 1, y, z - 1});
            queue.add(new int[]{x, y + 1, z - 1});
        }
        return (int) count;
    }
}
