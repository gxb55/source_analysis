package com.trip.algorithm.leet.some.leet2312;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/12/11 19:12
 */
public class Solution1631 {
    public static void main(String[] args) {
       // int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
       // int[][] heights ={{1,2,3},{3,8,4},{5,3,5}};
       // int[][] heights ={{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
      //  int[][] heights ={{1}};
        int[][] heights ={{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}}
                ;
        Solution1631 solution1631 = new Solution1631();
        int i = solution1631.minimumEffortPath(heights);
        System.out.println(i);
    }


    public int minimumEffortPath(int[][] heights) {
        if(heights.length==1&&heights[0].length==1){
            return 0;
        }
        Set<String> set = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        set.add("0_0");
        process(heights, 0, 0, set, list);
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
        if ((x - 1) >= 0) {
            String str = (x - 1) + "_" + y;
            if (set.add(str)&&!checkCanSkip(x,y,x-1,y,heights)) {
                list.add(new int[]{x - 1, y});
                process(heights, x - 1, y, set, list);
                set.remove(str);
                list.remove(list.size() - 1);
            }
        }
        if ((x + 1) < xLen) {
            String str = (x + 1) + "_" + y;
            if (set.add(str)&&!checkCanSkip(x,y,x+1,y,heights)) {
                list.add(new int[]{x + 1, y});
                process(heights, x + 1, y, set, list);
                set.remove(str);
                list.remove(list.size() - 1);
            }
        }
        if ((y - 1) >= 0) {
            String str = (x) + "_" + (y - 1);
            if (set.add(str)&&!checkCanSkip(x,y,x,y-1,heights)) {
                list.add(new int[]{x, y - 1});
                process(heights, x, y, set, list);
                set.remove(str);
                list.remove(list.size() - 1);
            }
        }
        if ((y + 1) < yLen) {
            String str = (x) + "_" + (y + 1);
            if (set.add(str)&&!checkCanSkip(x,y,x,y+1,heights)) {
                list.add(new int[]{x, y + 1});
                process(heights, x, y + 1, set, list);
                set.remove(str);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean checkCanSkip(int x, int y, int i, int y1, int[][] heights) {
        if(res==-1){
            return false;
        }
        int i1 = heights[x][y] - heights[i][y1];
        if(Math.abs(i1)>res){
            return true;
        }
        return false;
    }

    int res = -1;
}
