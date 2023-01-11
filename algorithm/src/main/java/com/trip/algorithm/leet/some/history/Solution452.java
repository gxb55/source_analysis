package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/4/15  20:34
 * @description 452
 */
public class Solution452 {
    public static void main(String[] args) {
        Solution452 solution452 = new Solution452();
        //int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
       // int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        //int[][] points = {{1,2},{2,3},{3,4},{4,5}};
        int[][] points = {{1,9},{7,16},{2,5},{7,12},{9,11},{2,10},{9,16},{3,9},{1,3}};
        int minArrowShots = solution452.findMinArrowShots(points);
        System.out.println(minArrowShots);
    }

    public int findMinArrowShots(int[][] points) {
        List<int[]> collect = Arrays.stream(points).sorted(Comparator.comparingInt(x -> x[0])).collect(Collectors.toList());
        List<Shot> list = new ArrayList<>();
        for (int[] arr : collect) {
            int min = arr[0];
            int max = arr[1];
            find(max, min, list);
        }
        return list.size();
    }

    private void find(int max, int min, List<Shot> list) {
        boolean flag = true;
        Shot temp = null;
        Shot res = null;
        for (Shot shot : list) {
            int l = -1;
            int r = -1;
            if(min <= shot.max && min >= shot.min && max >= shot.min && max <= shot.max){
                res = new Shot(min, max); flag = false;  temp = shot;
                break;
            }else if (min <= shot.max && min >= shot.min) {
                l = shot.max - min;
            }else if (max >= shot.min && max <= shot.max) {
                r = max - shot.min;
            }
            if (l != -1 || r != -1) {
                temp = shot;
                if (l > r) {
                    res = new Shot(min, shot.max);
                } else {
                    res = new Shot(shot.min, max);
                }
                flag = false;
                break;
            }

        }
        if (flag) {
            list.add(new Shot(min, max));
        } else {
            list.remove(temp);
            list.add(res);
        }
    }
}

class Shot {
    public int min;
    public int max;

    public Shot(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Shot() {
    }
}
