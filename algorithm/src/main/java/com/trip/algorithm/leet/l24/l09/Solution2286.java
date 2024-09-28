package com.trip.algorithm.leet.l24.l09;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2286 {
    public static void main(String[] args) {
        /**
         * ["BookMyShow", "gather", "gather", "scatter", "scatter"]
         * [[2, 5], [4, 0], [2, 0], [5, 1], [5, 1]]
         */
      /*  int n=2;
        int m=5;
        BookMyShow show =new BookMyShow(n,m);
        System.out.println(Arrays.toString(show.gather(4,0)));
        System.out.println(Arrays.toString(show.gather(2,0)));
        System.out.println(show.scatter(5,1));
        System.out.println(show.scatter(5,1)); */

       /* int n=4;
        int m=5;
        BookMyShow show =new BookMyShow(n,m);
        System.out.println(show.scatter(6,2));
        System.out.println(show.scatter(5,1));*/


       /* int n = 5;
        int m = 9;
        BookMyShow show = new BookMyShow(n, m);
        System.out.println(JSON.toJSONString(show.gather(10, 1)));
        System.out.println(JSON.toJSONString(show.scatter(3, 3)));
        System.out.println(JSON.toJSONString(show.gather(9, 1)));*/
           int n = 5;
        int m = 10;
        BookMyShow show = new BookMyShow(n, m);
        System.out.println(JSON.toJSONString(show.scatter(9, 1)));
        System.out.println(JSON.toJSONString(show.scatter(1, 3)));
        System.out.println(JSON.toJSONString(show.gather(3, 4)));
        System.out.println(JSON.toJSONString(show.gather(1, 1)));

       /* ["BookMyShow","scatter","scatter","gather","gather","gather"]
[[5,10],[9,1],[1,3],[3,4],[1,1],[10,4]]*/
    }

}

class BookMyShow {
    Map<Integer, Line> map = new HashMap<>();
    int n = 0;
    int m = 0;

    public BookMyShow(int n, int m) {
        this.n = n;
        this.m = m;
        for (int i = 0; i < n; i++) {
            map.put(i, new Line(0, m - 1));
        }
    }

    public int[] gather(int k, int maxRow) {
        if(k>m){
            return new int[]{};
        }
        List<Map.Entry<Integer, Line>> collect = map.entrySet().stream().sorted((x, y) -> x.getKey() - y.getKey()).collect(Collectors.toList());
        for (Map.Entry<Integer, Line> entry : collect) {
            if (entry.getKey() > maxRow) {
                return new int[]{};
            } else {
                Line value = entry.getValue();
                int i = value.right - value.left + 1;
                boolean b = i >= k;
                if (b) {
                    int t = 0;
                    int v = value.left;
                    while (t < k) {
                        value.left++;
                        t++;
                    }

                    return new int[]{entry.getKey(), v};
                }
            }
        }
        clearMap(map);
        return new int[]{};
    }

    private void clearMap(Map<Integer, Line> map) {
        for (int i = 0; i < n; i++) {
            Line line = map.get(i);
            if (line != null && line.left > line.right) {
                map.remove(i);
            }
        }
    }

    public boolean scatter(int k, int maxRow) {
        List<Map.Entry<Integer, Line>> collect = map.entrySet().stream().sorted((x, y) -> x.getKey() - y.getKey()).collect(Collectors.toList());

        List<Integer> indexList = new ArrayList<>();
        boolean flag = false;
        for (Map.Entry<Integer, Line> entry : collect) {
            if (entry.getKey() > maxRow) {
                return false;
            } else {
                Line value = entry.getValue();
                int i = value.right - value.left + 1;
                if (i >= k) {
                    int t = 0;
                    while (t < k) {
                        value.left++;
                        t++;
                    }
                    flag = true;
                    break;
                } else {
                    k -= i;
                    indexList.add(entry.getKey());
                }
            }
        }
        if (flag) {
            for (int x : indexList) {
                map.remove(x);
            }
            return true;
        }
        return false;
    }
}

class Line {
    int left;
    int right;

    public Line(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public Line() {
    }
}