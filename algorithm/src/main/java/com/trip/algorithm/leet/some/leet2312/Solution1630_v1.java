package com.trip.algorithm.leet.some.leet2312;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1630_v1 {
    public static void main(String[] args) {
        Solution1630_v1 solution1630V1 = new Solution1630_v1();
      /*  int[][] arr = {{4, 3, 4, 10, 5, 5, 9, 2}, {10, 8, 2, 10, 9, 7, 5, 6}, {5, 8, 10, 10, 10, 7, 4, 2}, {5, 1, 3, 1, 1, 3, 1, 9}, {6, 4, 10, 6, 10, 9, 4, 6}};
        int i = solution1630V1.minimumEffortPath(arr);
        System.out.println(i);*/
        System.out.println(1);
    }

    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 1 && heights[0].length == 1) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        set.add("0_0");
        int left = 0;
        int right = 999999;
        int ans = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            while (!list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    
                }

            }
        }


        return res;
    }

    private void process(int[][] heights, int x, int y, Set<String> set, List<int[]> list) {
        if (x == heights.length - 1 && y == heights[0].length - 1) {
            int v = -1;
            for (int i = 1; i < list.size(); i++) {
                int a = heights[list.get(i)[0]][list.get(i)[1]];
                int b = heights[list.get(i - 1)[0]][list.get(i - 1)[1]];
                if (v == -1) {
                    v = Math.abs(b - a);
                } else {
                    v = Math.max(v, Math.abs(b - a));
                }
            }

            if (res == -1) {
                res = v;
                return;
            }
            res = Math.min(res, v);
            return;
        }
        int xLen = heights.length;
        int yLen = heights[0].length;
        if ((x - 1) >= 0 && !checkCanSkip(x, y, x - 1, y, heights)) {
            String str = (x - 1) + "_" + y;
            if (set.add(str)) {
                list.add(new int[]{x - 1, y});
                process(heights, x - 1, y, set, list);
                set.remove(str);
                list.remove(list.size() - 1);
            }
        }
        if ((y + 1) < yLen && !checkCanSkip(x, y, x, y + 1, heights)) {
            String str = (x) + "_" + (y + 1);
            if (set.add(str)) {
                list.add(new int[]{x, y + 1});
                process(heights, x, y + 1, set, list);
                set.remove(str);
                list.remove(list.size() - 1);
            }
        }
        if ((x + 1) < xLen && !checkCanSkip(x, y, x + 1, y, heights)) {
            String str = (x + 1) + "_" + y;
            if (set.add(str)) {
                list.add(new int[]{x + 1, y});
                process(heights, x + 1, y, set, list);
                set.remove(str);
                list.remove(list.size() - 1);
            }
        }
        if ((y - 1) >= 0 && !checkCanSkip(x, y, x, y - 1, heights)) {
            String str = (x) + "_" + (y - 1);
            if (set.add(str)) {
                list.add(new int[]{x, y - 1});
                process(heights, x, y, set, list);
                set.remove(str);
                list.remove(list.size() - 1);
            }
        }

    }

    private boolean checkCanSkip(int x, int y, int x1, int y1, int[][] heights) {
        if (res == -1) {
            return false;
        }
        if (res < Math.abs(heights[x][y] - heights[x1][y1])) {
            return true;
        }
        return false;
    }

    int res = -1;
}
