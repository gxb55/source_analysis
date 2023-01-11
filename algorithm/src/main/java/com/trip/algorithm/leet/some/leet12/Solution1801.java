package com.trip.algorithm.leet.some.leet12;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2023/1/3 17:10
 * @description 1801
 * 0 表示这是一批采购订单 buy
 * 1 表示这是一批销售订单 sell
 * <p>
 * 如果该订单是一笔采购订单 buy ，
 * 则可以查看积压订单中价格 最低 的销售订单 sell 。
 * 如果该销售订单 sell 的价格
 * 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单，并将销售订单 sell
 * 从积压订单中删除。否则，采购订单 buy 将会添加到积压订单中。
 * <p>
 * 如果该订单是一笔销售订单 sell ，
 * 则可以查看积压订单中价格 最高 的采购订单 buy 。
 * 如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，
 * 则匹配并执行这两笔订单，并将采购订单 buy 从积压订单中删除。
 * 否则，销售订单 sell 将会添加到积压订单中。
 */
public class Solution1801 {
    public static void main(String[] args) {
        Solution1801 solution1801 = new Solution1801();
       /* int[][] orders = {
                {10, 5, 0},
                {15, 2, 1},
                {25, 1, 1},
                {30, 4, 0}
        };  */
        int[][] orders = {{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}};

        int numberOfBacklogOrders = solution1801.getNumberOfBacklogOrders(orders);
        System.out.println(numberOfBacklogOrders);
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        // 降序
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        // 升序
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
/**
 *  * 0 表示这是一批采购订单 buy
 *  * 1 表示这是一批销售订单 sell
 */
        boolean falg =false;
        for (int i = 0; i < orders.length; i++) {
            int price = orders[i][0];
            int count = orders[i][1];
            int type = orders[i][2];
            falg =false;
            if (type == 0) {
                while (count > 0 && !sellQueue.isEmpty()) {
                    int[] peek = sellQueue.peek();
                    if (peek[0] <= price) {
                        int res = count - peek[1];
                        if (res > 0) {
                            sellQueue.poll();
                            count = count - peek[1];
                        } else {
                            sellQueue.poll();
                            sellQueue.add(new int[]{peek[0], peek[1] - count, peek[2]});
                            falg=true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if(!falg){
                    buyQueue.add(new int[]{price, count, type});
                }
            } else {
                while (count > 0 && !buyQueue.isEmpty()) {
                    int[] peek = buyQueue.peek();
                    if (peek[0] >= price) {
                        int res = count - peek[1];
                        if (res > 0) {
                            buyQueue.poll();
                            count = count - peek[1];
                        } else {
                            buyQueue.poll();
                            buyQueue.add(new int[]{peek[0], peek[1] - count, peek[2]});
                            falg=true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if(!falg){
                    sellQueue.add(new int[]{price, count, type});
                }
            }
        }
        int res = 0;
        int mod = 1000000007;
        while (!sellQueue.isEmpty()) {
            res = res + sellQueue.poll()[1];
            res = res % mod;
        }
        while (!buyQueue.isEmpty()) {
            res = res + buyQueue.poll()[1];
            res = res % mod;
        }
        return res;
    }
}
