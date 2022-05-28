package com.trip.algorithm.leet.zs;

import java.util.LinkedList;

/**
 * @author xbguo
 * @createTime 2022年03月27日 17:12:00
 * 求数组arr中子数组
 * max-min <=num的有多少个
 *
 * 应用双端队列，构造一个可以动态的求出当前数组最大值的容器，qmax。同上在构造一个qmin。
 *   从left，right等于开始，如果当前区间的qmax-qmin符合条件，right向右扩充，当不符合条件时，计算上一步符合条件的所有子数组个数。个数公式为 left-right。
 *   计算公式是因为当前数组符合条件，那么当前问题的所有子数组肯定也符合条件。因为当前数组当减少一个元素，子数组的max 小于等于 原来的 max , min 大于等于原来的min。故相减结果符合小于等于sum。
 *   计算完毕后，left减右扩展。
 */
public class Code02_AllLessNumSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int num = 3;
        int num1 = getNum(arr, num);
        System.out.println(num1);
    }

    /**
     * @param arr 数组
     * @param num 差值
     * @return
     */
    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 窗口左边界
        int l = 0;
        int res = 0;
        //窗口右边界，左闭右开
        int r = 0;

        int len = arr.length;
        LinkedList<Integer> maxList = new LinkedList<>();
        LinkedList<Integer> minList = new LinkedList<>();
        while (l < len) {
            while (r < len) {
                int t = arr[r];
                while (!maxList.isEmpty() && arr[maxList.peek()] <= t) {
                    maxList.poll();
                }
                maxList.add(r);

                while (!minList.isEmpty() && arr[minList.peek()] >= t) {
                    minList.poll();
                }
                minList.add(r);

                if ((arr[maxList.peekFirst()] - arr[minList.peekFirst()]) > num) {
                    break;
                }
                r++;
            }
            res = res + (r - l);
            System.out.println(res);
            if (maxList.peekFirst() == l) {
                maxList.pollFirst();
            }
            if (minList.peekFirst() == l) {
                minList.pollFirst();
            }
            l++;
        }
        return res;
    }
}
