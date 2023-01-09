package com.trip.algorithm.leet.some.leet12;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/12/14 10:39
 */
public class Solution1697 {
    public static void main(String[] args) {
        Solution1697 solution1697 = new Solution1697();
       /* int n = 3;
        int[][] edgeList = {{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}}, queries = {{0, 1, 2}, {0, 2, 5}};*/

        int n = 5;
        int[][] edgeList = {{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}}, queries = {{0, 4, 14}, {1, 4, 13}};

       /* int n = 13;
        int[][] edgeList = {{9, 1, 53}, {3, 2, 66}, {12, 5, 99}, {9, 7, 26}, {1, 4, 78},
                {11, 1, 62}, {3, 10, 50}, {12, 1, 71}, {12, 6, 63}, {1, 10, 63}, {9, 10, 88},
                {9, 11, 59}, {1, 4, 37}, {4, 2, 63}, {0, 2, 26}, {6, 12, 98}, {9, 11, 99},
                {4, 5, 40}, {2, 8, 25}, {4, 2, 35}, {8, 10, 9}, {11, 9, 25}, {10, 11, 11},
                {7, 6, 89}, {2, 4, 99}, {10, 4, 63}};
        int[][] queries = {{9, 7, 65}, {9, 6, 1}, {4, 5, 34}, {10, 8, 43}, {3, 7, 76}, {4, 2, 15}, {7, 6, 52}, {2, 0, 50}, {7, 6, 62}, {1, 0, 81}, {4, 5, 35}, {0, 11, 86}, {12, 5, 50}, {11, 2, 2}, {9, 5, 6}, {12, 0, 95}, {10, 6, 9}, {9, 4, 73}, {6, 10, 48}, {12, 0, 91}, {9, 10, 58}, {9, 8, 73}, {2, 3, 44}, {7, 11, 83}, {5, 3, 14}, {6, 2, 33}};
*/
       /* int n = 34;
        int[][] edgeList = {{17, 26, 57}, {4, 15, 100}, {31, 18, 23}, {6, 18, 32}, {12, 26, 19}, {8, 9, 14}, {18, 33, 99}, {4, 30, 60}, {27, 5, 52}, {5, 12, 31}, {30, 16, 63}, {31, 25, 15}, {32, 5, 89}, {27, 13, 31}, {11, 5, 30}, {18, 30, 5}, {10, 31, 21}, {30, 16, 100}, {1, 5, 15}, {24, 11, 61}, {2, 10, 97}, {20, 32, 12}, {24, 17, 1}, {33, 5, 27}, {11, 6, 71}, {16, 31, 93}, {16, 32, 59}, {12, 31, 28}, {22, 13, 79}, {19, 24, 39}, {28, 17, 36}, {3, 9, 82}, {19, 10, 88}, {9, 23, 89}, {17, 2, 70}, {25, 2, 66}, {30, 8, 74}, {26, 0, 77}, {25, 23, 86}, {7, 4, 48}, {22, 11, 21}, {20, 24, 46}, {30, 20, 41}, {16, 20, 48}, {28, 0, 77}};
        int[][] queries = {{14, 25, 32}, {16, 7, 80}, {16, 2, 2}, {2, 24, 3}, {17, 4, 30}, {30, 6, 56}, {0, 4, 89}, {5, 15, 89}, {10, 18, 40}, {8, 1, 37}, {19, 2, 13}, {1, 28, 66}, {7, 16, 24}, {13, 33, 67}, {32, 31, 26}, {12, 29, 88}, {8, 24, 72}, {30, 16, 87}, {6, 26, 14}, {28, 25, 100}, {12, 13, 54}, {11, 21, 59}, {26, 8, 60}, {26, 19, 27}, {20, 26, 80}, {30, 11, 21}, {15, 7, 49}, {26, 28, 81}, {4, 32, 22}, {21, 26, 32}, {22, 25, 46}, {9, 6, 13}, {21, 26, 9}, {14, 29, 33}, {5, 3, 13}, {23, 27, 84}, {7, 6, 27}, {28, 25, 50}, {2, 10, 78}, {33, 14, 62}, {12, 19, 76}, {29, 26, 26}, {6, 8, 9}, {7, 18, 56}, {26, 17, 91}};
*/

        boolean[] booleans = solution1697.distanceLimitedPathsExist1(n, edgeList, queries);
        System.out.println(Arrays.toString(booleans));
    }

    public boolean[] distanceLimitedPathsExist1(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> queries[a][2] - queries[b][2]);

        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        boolean[] res = new boolean[queries.length];
        int k = 0;
        for (int i : index) {
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                merge(uf, edgeList[k][0], edgeList[k][1]);
                k++;
            }
            res[i] = find(uf, queries[i][0]) == find(uf, queries[i][1]);
        }
        return res;
    }

    public int find(int[] uf, int x) {
        while (uf[x] != x) {
            x = uf[x];
        }
        return x;
    }

    public void merge(int[] uf, int x, int y) {
        x = find(uf, x);
        y = find(uf, y);
        uf[y] = x;
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        MyMap map = new MyMap();
        for (int[] arr : edgeList) {
            int begin = arr[0];
            int end = arr[1];
            int val = arr[2];
            Point beginPoint = map.pointMap.getOrDefault(begin, new Point(begin));
            Point endPoint = map.pointMap.getOrDefault(end, new Point(end));
            Side side1 = new Side(beginPoint, endPoint, val);
            Side side2 = new Side(endPoint, beginPoint, val);
            if (map.pointMap.containsKey(begin)) {
                map.pointMap.get(begin).list.add(side1);
            } else {
                map.pointMap.put(begin, beginPoint);
                beginPoint.list.add(side1);
            }
            if (map.pointMap.containsKey(end)) {
                map.pointMap.get(end).list.add(side2);
            } else {
                map.pointMap.put(end, endPoint);
                endPoint.list.add(side2);
            }
        }
        boolean[] dp = new boolean[queries.length];
        int index = 0;
        for (int[] arr : queries) {
            int begin = arr[0];
            int end = arr[1];
            int val = arr[2];
            if (check(begin, end, val, map)) {
                dp[index] = true;
            } else {
                dp[index] = false;
            }
            index++;
        }
        return dp;
    }

    private boolean check(int begin, int end, int val, MyMap map) {
        Point point = map.pointMap.get(begin);
        if (point == null) {
            return false;
        }
        LinkedList<Point> list = new LinkedList<>();
        Set<Point> set = new HashSet<>();
        list.add(point);
        set.add(point);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Point pop = list.pollFirst();
                if (pop.list != null) {
                    List<Point> collect = pop.list.stream().filter(x -> x.weight < val).map(x -> x.endPoint)
                            .filter(x -> !set.contains(x)).filter(x -> x != null).peek(x -> list.addLast(x)).collect(Collectors.toList());
                    set.addAll(collect);
                }
            }
        }
        Optional<Point> first = set.stream().filter(x -> x.val == end).findFirst();
        return first.isPresent();
    }

}

class MyMap {
    public Map<Integer, Point> pointMap;

    public MyMap() {
        pointMap = new HashMap<>();
    }
}

class Point {
    public int val;
    public List<Side> list;

    public Point(int val) {
        this.val = val;
        this.list = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return val == point.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    public Point() {
    }
}

class Side {
    public Point beginPoint;
    public Point endPoint;
    public int weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Side side = (Side) o;
        return (weight == side.weight && Objects.equals(beginPoint, side.beginPoint) && Objects.equals(endPoint, side.endPoint)) || (weight == side.weight && Objects.equals(beginPoint, side.endPoint) && Objects.equals(endPoint, side.beginPoint));
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginPoint.val + endPoint.val, weight);
    }

    @Override
    public String toString() {
        return "Side{" +
                "beginPoint=" + beginPoint.val +
                ", endPoint=" + endPoint.val +
                ", weight=" + weight +
                '}';
    }

    public Side(Point beginPoint, Point endPoint, int weight) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
        this.weight = weight;
    }
}
