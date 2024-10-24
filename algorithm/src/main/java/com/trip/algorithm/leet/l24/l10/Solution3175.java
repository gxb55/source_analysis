package com.trip.algorithm.leet.l24.l10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/10/24 19:52
 * @description TODO
 */
public class Solution3175 {
    public static void main(String[] args) {
        int[] skills = {4, 2, 6, 3, 9};
        int k = 2;
        int winningPlayer = findWinningPlayer(skills, k);
        System.out.println(winningPlayer);
    }

    public static int findWinningPlayer(int[] skills, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < skills.length; i++) {
            map.put(skills[i], i);
            list.add(skills[i]);
        }
        Integer last = -1;
        int count = 0;
        while (true) {
            Integer x = list.get(0);
            Integer y = list.get(1);
            if (x > y) {
                if (last == -1) {
                    last = x;
                }
                if (last == x) {
                    count++;
                } else {
                    count = 1;
                }
                list.remove(y);
                list.addLast(y);
            } else {
                if (last == -1) {
                    last = y;
                }
                if (last == y) {
                    count++;
                } else {
                    count = 1;
                }
                list.remove(x);
                list.addLast(x);
            }
            if (count > k) {
                break;
            }
        }

        return map.get(last);
    }
}
