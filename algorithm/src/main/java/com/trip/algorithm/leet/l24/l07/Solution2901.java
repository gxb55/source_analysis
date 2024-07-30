package com.trip.algorithm.leet.l24.l07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/7/30 17:17
 */
public class Solution2901 {
    public static void main(String[] args) {
        int[][] variables = {{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}};
        int target = 2;

     /*   int[][] variables = {{30,5,43,2},{15,50,35,41},{45,34,41,32},{14,37,33,13},{6,8,1,53},{37,1,12,52},{42,37,2,52},{9,2,15,3},{31,12,21,24},{52,24,6,12},{51,35,21,52},{30,18,10,2},{27,31,50,27},{29,25,26,32},{15,38,43,17},{22,12,16,43},{48,9,15,6},{41,26,22,21},{41,49,52,26},{53,38,9,33}};
        int target = 1; */
       /* int[][] variables = {{4, 6, 5, 2}, {2,6,4,6}, {4, 6, 3, 6}, {2, 2, 6, 5}, {6, 5, 5, 2}};
        int target = 2;*/
        List<Integer> goodIndices = getGoodIndices(variables, target);
        System.out.println(goodIndices);
        long pow = (long) Math.pow(53, 23);
        System.out.println(pow);
    }

    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        // Math.pow(base, exponent)
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int d = variables[i][3];
            //((aibi % 10)ci) % mi == target
            int index = getIndex1(a, b, 10);
            int index1 = getIndex1(index, c, d);
            boolean flag = index1 == target;
            if (flag) {
                list.add(i);
            }
        }
        return list;

    }
    private static int getIndex1(int a, int b, int i) {
        int res=1;
        while (b!=0){
            if((b&1)==1){
                res=res*a%i;
            }
            a=a*a%i;
            b=b>>1;
        }
        return res;
    }
    // 5,7,8,10,17,18
    private static int getIndex(int a, int b, int i) {
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        for (int j = 1; j <= b; j++) {
            int v = (int) (Math.pow(a, j) % i);
            list.add(v);
            if (list.size() % 2 == 0) {
                int size = list.size();
                int left = 0;
                int right = size - 1;
                boolean flag1 = true;
                while (left < (size / 2)) {
                    if (list.get(left) != list.get(left + size / 2)) {
                        flag1 = false;
                        break;
                    }
                    left++;
                }
                if (flag1) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            int i1 = i % list.size();
            return list.get(i1);
        }
        return (int) (Math.pow(a, b) % i);
    }
}
