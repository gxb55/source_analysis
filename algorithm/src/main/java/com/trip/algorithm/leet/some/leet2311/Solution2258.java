package com.trip.algorithm.leet.some.leet2311;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/11/9 10:33
 */
public class Solution2258 {
    public static void main(String[] args) {
        /*int[][] grid = {
                {0, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 2, 1, 0},
                {0, 2, 0, 0, 1, 2, 0},
                {0, 0, 2, 2, 2, 0, 2},
                {0, 0, 0, 0, 0, 0, 0}};*/

        // int[][] grid = {{0,0,0,0},{0,1,2,0},{0,2,0,0}};
        //  int[][] grid = {{0,0,0},{2,2,0},{1,2,0}};
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 2, 0, 2, 0},
                {0, 2, 0, 2, 2, 0, 2, 2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 2, 2, 0, 2, 2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2},
                {0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0},
                {0, 2, 2, 2, 2, 0, 2, 2, 2, 2, 0, 2, 2, 0, 0, 2, 2, 2, 0, 2, 2, 2},
                {0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 2, 0, 2, 0, 0, 2, 0},
                {2, 0, 2, 2, 2, 0, 2, 0, 2, 2, 0, 2, 2, 0, 0, 0, 0, 2, 2, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 2, 0, 0, 2, 0, 2, 2, 2, 0, 2, 0, 0, 2, 2, 2, 0},
                {2, 0, 2, 0, 2, 0, 1, 2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 2, 2, 0, 0, 0}};
      /*  int i = maximumMinutes(grid);
        System.out.println(i);*/


        Solution2258 solution2258 = new Solution2258();
        int i1 = solution2258.maximumMinutes1(grid);
        System.out.println(i1);
    }

    public int maximumMinutes1(int[][] grid) {
        Set<String> unTouchSet = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int v = grid[i][j];
                if (v == 2) {
                    unTouchSet.add(i + "-" + j);
                    grid[i][j] = -1;
                }
            }
        }
        int xLen = grid.length;
        int yLen = grid[0].length;
        int left = 0;
        int right = xLen * yLen;
        int t = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, grid, unTouchSet)) {
                t = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= (xLen * yLen)) {
            return 1000000000;
        }
        return t != -1 ? t : -1;
    }

    private boolean check(int mid, int[][] grid, Set<String> unTouchSet) {
        int[][] arr = new int[grid.length][grid[0].length];
        int xLen = grid.length;
        int yLen = grid[0].length;
        Set<String> set = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                arr[i][j] = grid[i][j];
                if (grid[i][j] == 1) {
                    list.add(new int[]{i, j});
                    set.add(i + "-" + j);
                }
            }
        }
        int v = mid;
        while (!list.isEmpty() && mid > 0) {
            List<int[]> nextList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i)[0];
                int y = list.get(i)[1];
                int val = arr[x][y];
                if ((x - 1) >= 0 && !unTouchSet.contains((x - 1) + "-" + y) && set.add((x - 1) + "-" + y) ) {
                    arr[x - 1][y] = val + 1;
                    nextList.add(new int[]{x - 1, y});
                }
                if ((x + 1) < xLen && !unTouchSet.contains((x + 1) + "-" + y) && set.add((x + 1) + "-" + y)  ) {
                    arr[x + 1][y] = val + 1;
                    nextList.add(new int[]{x + 1, y});
                }
                if ((y - 1) >= 0 && !unTouchSet.contains((x) + "-" + (y - 1)) && set.add((x) + "-" + (y - 1))  ) {
                    arr[x][y - 1] = val + 1;
                    nextList.add(new int[]{x, y - 1});
                }
                if ((y + 1) < yLen && !unTouchSet.contains((x) + "-" + (y + 1)) && set.add((x) + "-" + (y + 1)) ) {
                    arr[x][y + 1] = val + 1;
                    nextList.add(new int[]{x, y + 1});
                }
            }
            mid--;
            list = nextList;
        }
        if (arr[0][0] > 0) {
            return false;
        }

        Set<String> perSet = new HashSet<>();
        List<int[]> perList = new ArrayList<>();
        perList.add(new int[]{0, 0});
        perSet.add("0-0");
        if (list.isEmpty()) {
            while (!perList.isEmpty()) {
                perList = getPerson(arr, v, perSet, perList, unTouchSet);
            }
        }

        while (!list.isEmpty()) {
            perList = getPerson(arr, v, perSet, perList, unTouchSet);
            if (perList.size() == 0) {
                if (perSet.contains((xLen - 1) + "-" + (yLen - 1))) {
                    return true;
                } else {
                    return false;
                }
            }
            List<int[]> nextList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i)[0];
                int y = list.get(i)[1];
                int val = arr[x][y];
                if ((x - 1) >= 0) {
                    if (!unTouchSet.contains((x - 1) + "-" + y) && set.add((x - 1) + "-" + y) && arr[x - 1][y] <= 0) {
                        arr[x - 1][y] = val + 1;
                        nextList.add(new int[]{x - 1, y});
                    }

                }
                if ((x + 1) < xLen) {
                    if (!unTouchSet.contains((x + 1) + "-" + y) && set.add((x + 1) + "-" + y) && arr[x + 1][y] <= 0) {
                        arr[x + 1][y] = val + 1;
                        nextList.add(new int[]{x + 1, y});
                    }
                }
                if ((y - 1) >= 0) {
                    if (!unTouchSet.contains((x) + "-" + (y - 1)) && set.add((x) + "-" + (y - 1)) && arr[x][y - 1] <= 0) {
                        arr[x][y - 1] = val + 1;
                        nextList.add(new int[]{x, y - 1});
                    }

                }
                if ((y + 1) < yLen && !unTouchSet.contains((x) + "-" + (y + 1)) && set.add((x) + "-" + (y + 1)) && arr[x][y + 1] <= 0) {
                    arr[x][y + 1] = val + 1;
                    nextList.add(new int[]{x, y + 1});
                }
            }
            list = nextList;
            perList.removeAll(list);
            List<String> collect = list.stream().map(x -> x[0] + "-" + x[1]).collect(Collectors.toList());
            List<String> collect1 = perList.stream().map(x -> x[0] + "-" + x[1]).collect(Collectors.toList());
            collect1.removeAll(collect);
            perList=  collect1.stream().map(x->{
                String[] split = x.split("-");
               return new int[]{Integer.parseInt(split[0]),Integer.parseInt(split[1])};
            }).collect(Collectors.toList());
        }
        if (list.isEmpty()) {
            while (!perList.isEmpty()) {
                perList = getPerson(arr, v, perSet, perList, unTouchSet);
            }
        }
        return perSet.contains((xLen - 1) + "-" + (yLen - 1));

    }

    private List<int[]> getPerson(int[][] grid, int v, Set<String> set, List<int[]> list, Set<String> unTouchSet) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        List<int[]> nextList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            int val = grid[x][y];
            if ((x - 1) >= 0 && grid[x - 1][y] == 0 && set.add((x - 1) + "-" + y) && !unTouchSet.contains((x - 1) + "-" + y)) {
                grid[x - 1][y] = val - 1;
                nextList.add(new int[]{x - 1, y});
            }
            if ((x + 1) < xLen && grid[x + 1][y] == 0 && set.add((x + 1) + "-" + y) && !unTouchSet.contains((x + 1) + "-" + y)) {
                grid[x + 1][y] = val - 1;
                nextList.add(new int[]{x + 1, y});
            }
            if ((y - 1) >= 0 && grid[x][y - 1] == 0 && set.add((x) + "-" + (y - 1)) && !unTouchSet.contains((x) + "-" + (y - 1))) {
                grid[x][y - 1] = val - 1;
                nextList.add(new int[]{x, y - 1});
            }
            if ((y + 1) < yLen && grid[x][y + 1] == 0 && set.add((x) + "-" + (y + 1)) && !unTouchSet.contains((x) + "-" + (y + 1))) {
                grid[x][y + 1] = val - 1;
                nextList.add(new int[]{x, y + 1});
            }
        }
        return nextList;

    }

    /**
     * 0 表示草地。
     * 1 表示着火的格子。
     * 2 表示一座墙，你跟火都不能通过这个格子。
     *
     * @param grid
     * @return
     */
    public static int maximumMinutes(int[][] grid) {
        Set<String> unTouchSet = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int v = grid[i][j];
                if (v == 2) {
                    unTouchSet.add(i + "-" + j);
                } else if (v == 1) {
                    grid[i][j] = -1;
                }
            }
        }
        int xLen = grid.length;
        int yLen = grid[0].length;
        Set<String> set = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        set.add("0-0");
        while (!list.isEmpty()) {
            List<int[]> nextList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i)[0];
                int y = list.get(i)[1];
                int val = grid[x][y];
                if ((x - 1) >= 0 && grid[x - 1][y] == 0 && set.add((x - 1) + "-" + y)) {
                    grid[x - 1][y] = val + 1;
                    nextList.add(new int[]{x - 1, y});
                }
                if ((x + 1) < xLen && grid[x + 1][y] == 0 && set.add((x + 1) + "-" + y)) {
                    grid[x + 1][y] = val + 1;
                    nextList.add(new int[]{x + 1, y});
                }
                if ((y - 1) >= 0 && grid[x][y - 1] == 0 && set.add((x) + "-" + (y - 1))) {
                    grid[x][y - 1] = val + 1;
                    nextList.add(new int[]{x, y - 1});
                }
                if ((y + 1) < yLen && grid[x][y + 1] == 0 && set.add((x) + "-" + (y + 1))) {
                    grid[x][y + 1] = val + 1;
                    nextList.add(new int[]{x, y + 1});
                }
            }
            list = nextList;
        }
        boolean flag = set.contains((xLen - 1) + "-" + (yLen - 1));
        if (!flag) {
            return -1;
        }
        list.clear();
        set.clear();
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int val = grid[i][j];
                if (val >= 0) {
                    List<String> orDefault = map.getOrDefault(grid[i][j], new ArrayList<>());
                    orDefault.add(i + "-" + j);
                    map.put(grid[i][j], orDefault);
                }
                if (val == -1) {
                    list.add(new int[]{i, j});
                    set.add((i) + "-" + j);
                }
            }
        }

        while (!list.isEmpty()) {
            List<int[]> nextList = new ArrayList<>();
            List<String> list1 = new ArrayList<>();
            int t = 0;
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i)[0];
                int y = list.get(i)[1];
                int val = grid[x][y];
                t = val;
                if ((x - 1) >= 0 && !unTouchSet.contains((x - 1) + "-" + y) && set.add((x - 1) + "-" + y)) {
                    grid[x - 1][y] = val - 1;
                    nextList.add(new int[]{x - 1, y});
                    list1.add((x - 1) + "-" + y);
                }
                if ((x + 1) < xLen && !unTouchSet.contains((x + 1) + "-" + y) && set.add((x + 1) + "-" + y)) {
                    grid[x + 1][y] = val - 1;
                    nextList.add(new int[]{x + 1, y});
                    list1.add((x + 1) + "-" + y);
                }
                if ((y - 1) >= 0 && !unTouchSet.contains((x) + "-" + (y - 1)) && set.add((x) + "-" + (y - 1))) {
                    grid[x][y - 1] = val - 1;
                    nextList.add(new int[]{x, y - 1});
                    list1.add((x) + "-" + (y - 1));
                }
                if ((y + 1) < yLen && !unTouchSet.contains((x) + "-" + (y + 1)) && set.add((x) + "-" + (y + 1))) {
                    grid[x][y + 1] = val - 1;
                    nextList.add(new int[]{x, y + 1});
                    list1.add((x) + "-" + (y + 1));
                }
            }
            map.values().stream().forEach(x -> x.removeAll(list1));
            Map.Entry<Integer, List<String>> entry = map.entrySet().stream().filter(x -> x.getValue().size() == 0).sorted((x, y) -> x.getKey().compareTo(y.getKey())).findFirst().orElse(null);
            if (entry != null) {
                Integer key = entry.getKey();
                int v = t + 2;
                if ((key + v) == 0) {
                    return Math.abs(t + 2);
                }
                if ((key + v) > 0) {
                    return -1;
                }
            }
            list = nextList;
        }
        return 1000000000;
    }
}
