package com.trip.algorithm.leet.some.leet2312;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/12/1 10:09
 */
public class Solution2661 {
    public static void main(String[] args) {
        Solution2661 solution2661 =new Solution2661();
       /* int[] arr = {1,3,4,2};
        int[][] mat = {{1,4},{2,3}};
        */
        int[] arr = {2,8,7,4,1,3,5,6,9};
        int[][] mat = {{3,2,5},{1,4,6},{8,7,9}};

        int i = solution2661.firstCompleteIndex(arr, mat);
        System.out.println(i);
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int xLen = mat.length;
        int yLen = mat[0].length;
        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();
        Map<Integer,int[]> map =new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                map.put(mat[i][j],new int[]{i,j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            int[] ints = map.get(i1);
            int x = ints[0];
            int y = ints[1];
            List<Integer> orDefault = xMap.getOrDefault(x, new ArrayList<>());
            orDefault.add(y);
            xMap.put(x,orDefault);

            List<Integer> orDefault1 = yMap.getOrDefault(y, new ArrayList<>());
            orDefault1.add(x);
            yMap.put(y,orDefault1);
            if(orDefault.size()==yLen||orDefault1.size()==xLen){
                return i;
            }
        }
        return arr.length;
    }
}
