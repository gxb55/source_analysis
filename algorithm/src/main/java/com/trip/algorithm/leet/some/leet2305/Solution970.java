package com.trip.algorithm.leet.some.leet2305;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年05月02日 17:45:00
 * 970. 强整数
 * 给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。
 * <p>
 * 如果某一整数可以表示为 xi + yj ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。
 * <p>
 * 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 20 + 30
 * 3 = 21 + 30
 * 4 = 20 + 31
 * 5 = 21 + 31
 * 7 = 22 + 31
 * 9 = 23 + 30
 * 10 = 20 + 32
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= x, y <= 100
 * 0 <= bound <= 106
 * 简单模拟控制循环退出，特殊情况特殊处理
 */
public class Solution970 {
    public static void main(String[] args) {
        //  int x = 2, y = 3, bound = 10;
      //  int x = 3, y = 5, bound = 15;
      //  int x = 1, y = 1, bound = 400000;
        int x = 1, y = 1, bound = 1;
        List<Integer> list = powerfulIntegers(x, y, bound);
        System.out.println(list);
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> list = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        if(x==1){
            for (int i = 0; i <=bound; i++) {
                int cur = (int) Math.pow(y, i);
                if(cur>bound||(cur+1)>bound){
                    break;
                }
                list.add(cur+1);
            }
            return list.stream().collect(Collectors.toList());
        }else if(y==1){
            for (int i = 0; i <=bound; i++) {
                int cur = (int) Math.pow(x, i);
                if(cur>bound||(cur+1)>bound){
                    break;
                }
                list.add(cur+1);
            }
            return list.stream().collect(Collectors.toList());
        }
        for (int i = 0; i < bound; i++) {
            int cur = (int) Math.pow(x, i);
            if (cur > bound) {
                break;
            }
            for (int j = 0; j < bound; j++) {
                if (map.get(j) == null) {
                    map.put(j, (int) Math.pow(y, j));
                }
                if ((cur + map.get(j)) > bound) {
                    break;
                }
                list.add(cur + map.get(j));
            }
        }
        return list.stream().collect(Collectors.toList());
    }
}
