package com.trip.algorithm.leet.some.leet2310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/10/13 10:14
 */
public class Solution1488 {
    public static void main(String[] args) {
        //  int[] rains = {1, 2, 0, 0, 2, 1};
        //  int[] rains = {1,2,0,1,2};
       // int[] rains = {1, 2, 3, 4};
       // int[] rains = {0,1,1};
        int[] rains = {1,0,2,0,3,0,2,0,0,0,1,2,3};
        int[] ints = avoidFlood(rains);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] avoidFlood(int[] rains) {
        int length = rains.length;
        int[] res = new int[length];
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int rain = rains[i];
            if (rain > 0) {
                res[i] = -1;
            } else if (rain == 0) {
                list.add(i);
            }
            if (rain != 0) {
                if (map.containsKey(rain)) {
                    if (list.isEmpty()) {
                        return new int[]{};
                    } else {
                        Integer integer = map.get(rain);
                        int finalI = i;
                        int t=-1;
                        for (int j = 0; j < list.size(); j++) {
                            Integer x = list.get(j);
                            if(x > integer && x < finalI){
                                t=j;
                                break;
                            }
                        }
                        if(t!=-1){
                            Integer remove = list.remove(t);
                            res[remove] = rain;
                        }else{
                            return new int[]{};
                        }
                    }
                    map.put(rain, i);
                } else {
                    map.put(rain, i);
                }
            }else{
                res[i] = 1;
            }
        }
        return res;
    }
}
