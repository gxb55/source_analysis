package com.trip.algorithm.leet.some.leet11;

import java.util.*;

/**
 * @auther: xbguo
 * @date: 2022/11/2 18:52
 * @description: 1620
 */
public class Solution1620 {
    public static void main(String[] args) {
        Solution1620 solution1620 = new Solution1620();
      /*  int[][] towers = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        int radius = 2;*/

     /*   int[][] towers = {{1,2,13},{2,1,7},{0,1,9}};
        int radius = 2;*/

        /*int[][] towers = {{42, 0, 0}};
        int radius = 7;*/
    /*    int[][] towers = {{0, 1, 2}, {2, 1, 2}, {1, 0, 2}, {1, 2, 2}};
        int radius = 1;
        */
       /* int[][] towers = {{33,24,12},{5,34,12},{9,45,6},{28,12,12}};
        int radius = 2;*/
        int[][] towers = {{31,13,33},{24,45,38},{28,32,23},{7,23,22},{41,50,33},{47,21,3},{3,33,39},{11,38,5},{26,20,28},{48,39,16},{34,29,25}};
        int radius = 21;
        int[] ints = solution1620.bestCoordinate(towers, radius);
        System.out.println(Arrays.toString(ints));
        int[] int1s = solution1620.bestCoordinate1(towers, radius);
        System.out.println(Arrays.toString(int1s));

    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        if (towers.length == 1 && towers[0][2] == 0) {
            return new int[]{0, 0};
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < towers.length; i++) {
            int x = towers[i][0];
            int y = towers[i][1];
            int v = towers[i][2];
            Set<String> set = new HashSet<>();
            process(map, x, y, v, radius, towers[i], set);
        }
        String res = "";
        int max = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                res = entry.getKey();
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                String[] s = res.split("_");
                String[] s1 = entry.getKey().split("_");
                if(Integer.valueOf(s1[0])<Integer.valueOf(s[0])){
                    res = entry.getKey();
                }else if(Integer.valueOf(s1[0]).equals(Integer.valueOf(s[0]))){
                    if(Integer.valueOf(s1[1])<Integer.valueOf(s[1])){
                        res = entry.getKey();
                    }
                }

            }
        }
        String[] s = res.split("_");
        return new int[]{Integer.valueOf(s[0]), Integer.valueOf(s[1])};
    }

    private void process(Map<String, Integer> map, int x, int y, int v, int radius, int[] tower, Set<String> set) {
        String s = x + "_" + y;
        if (set.contains(s)) {
            return;
        }
        int val = Math.abs(tower[1] - y) * Math.abs(tower[1] - y) + Math.abs(tower[0] - x) * Math.abs(tower[0] - x);
        double distance = Math.sqrt(val);
        if (val > radius*radius) {
            return;
        }
        if (map.containsKey(s)) {
            map.put(s, map.get(s) +  (int) Math.floor(v / (1 + distance)) );
        } else {
            map.put(s, (int) Math.floor(v / (1 + distance)));
        }
        set.add(s);
        process(map, x, y - 1, v, radius, tower, set);
        process(map, x, y + 1, v, radius, tower, set);
        process(map, x - 1, y, v, radius, tower, set);
        process(map, x + 1, y, v, radius, tower, set);
    }

    public int[] bestCoordinate1(int[][] towers, int radius) {
        int xMax = Integer.MIN_VALUE, yMax = Integer.MIN_VALUE;
        for (int[] tower : towers) {
            int x = tower[0], y = tower[1];
            xMax = Math.max(xMax, x);
            yMax = Math.max(yMax, y);
        }
        int cx = 0, cy = 0;
        int maxQuality = 0;
        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                int[] coordinate = {x, y};
                int quality = 0;
                for (int[] tower : towers) {
                    int squaredDistance = getSquaredDistance(coordinate, tower);
                    if (squaredDistance <= radius * radius) {
                        double distance = Math.sqrt(squaredDistance);
                        quality += (int) Math.floor(tower[2] / (1 + distance));
                    }
                }
                System.out.println(x + ":" + y + ":" + quality);
                if (quality > maxQuality) {
                    cx = x;
                    cy = y;
                    maxQuality = quality;
                }
            }
        }
        return new int[]{cx, cy};
    }

    public int getSquaredDistance(int[] coordinate, int[] tower) {
        return (tower[0] - coordinate[0]) * (tower[0] - coordinate[0]) + (tower[1] - coordinate[1]) * (tower[1] - coordinate[1]);
    }


}
