package com.trip.algorithm.leet.l24.l10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/10/23 19:01
 * 输入： hours = [12,12,30,24,24]
 *
 * 输出： 2
 *
 * 解释：
 *
 * 构成整天的下标对分别是 (0, 1) 和 (3, 4)。
 *
 * 示例 2：
 *
 * 输入： hours = [72,48,24,3]
 *
 * 输出： 3
 *
 * 解释：
 */
public class Solution3185 {
    public static void main(String[] args) {
     //  int[] hours = {72,48,24,3};
       int[] hours = {13,11};
      //  int[] hours = {12,12,30,24,24};
        long l = countCompleteDayPairs(hours);
        System.out.println(l);
    }

    public static long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> map = new HashMap();
        for (int k : hours) {
            int t = k % 24;
            Integer orDefault = map.getOrDefault(t, 0);
            map.put(t, orDefault + 1);
        }
        long count=0;
        for (int i = 0; i < 24; i++) {
            Integer integer = map.get(i);
            if(integer==null){
                continue;
            }else {
                if(i==0||i==12){
                    for (int j = 1; j < integer; j++) {
                        count=count+j;
                    }
                } else {
                    Integer x = map.get(i);
                    Integer y = map.get(24-i);
                    if(x==null||y==null){
                        continue;
                    }else {
                        map.remove(i);
                        map.remove(24-i);
                        count=count+x*y;
                    }
                }
            }
        }

        return count;
    }
}
