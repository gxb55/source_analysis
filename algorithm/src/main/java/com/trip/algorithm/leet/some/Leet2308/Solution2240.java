package com.trip.algorithm.leet.some.Leet2308;

import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2023/9/1 15:41
 * 1 <= total, cost1, cost2 <= 106
 */
public class Solution2240 {
    public static void main(String[] args) {
        Solution2240 solution2240 = new Solution2240();
      //  int total = 20, cost1 = 10, cost2 = 5;
      //  int total = 5, cost1 = 10, cost2 = 10;
       // int total = 100, cost1 = 1, cost2 = 1;
        int total = 10, cost1 = 2, cost2 = 5;
        long l = solution2240.waysToBuyPensPencils(total, cost1, cost2);
        System.out.println(l);
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        LinkedList<int[]> list = new LinkedList<>();
        int x=cost1;
        int y=cost2;
        cost1=Math.max(x,y);
        cost2=Math.min(x,y);
        int cur = 0;
        int t = 1;
        while (cur <= total) {
            list.addLast(new int[]{cur, t});
            cur = t * cost2;
            t++;
        }
        cur = 0;
        long count = 0;
        for (int i = 0; i <= total; i++) {
            int res = total - cur;
            if (res < 0||list.isEmpty()) {
                break;
            }
            while (!list.isEmpty()&&res < list.peekLast()[0]) {
                list.pollLast();
            }
            count = count + list.pollLast()[1];
            cur = cost1 * (i + 1);
        }
        return count;

    }
}
