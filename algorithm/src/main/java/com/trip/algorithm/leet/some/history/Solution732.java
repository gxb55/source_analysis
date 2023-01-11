package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/6/6  21:01
 * @description 732
 * 732. 我的日程安排表 III
 * 当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
 * <p>
 * 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
 * <p>
 * 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
 * <p>
 * MyCalendarThree() 初始化对象。
 * int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * 输出：
 * [null, 1, 1, 2, 3, 3, 3]
 * <p>
 * 解释：
 * MyCalendarThree myCalendarThree = new MyCalendarThree();
 * myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
 * myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
 * myCalendarThree.book(5, 10); // 返回 3
 * myCalendarThree.book(25, 55); // 返回 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= start < end <= 109
 * 每个测试用例，调用 book 函数最多不超过 400次
 * 通过次数13,557提交次数19,055
 */
public class Solution732 {
    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        /**
         *  * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
         *  * 输出：
         *  * [null, 1, 1, 2, 3, 3, 3]
         */
        System.out.println(myCalendarThree.book(10, 20));
        System.out.println(myCalendarThree.book(50, 60));
        System.out.println(myCalendarThree.book(10, 40));
        System.out.println(myCalendarThree.book(5, 15));
        System.out.println(myCalendarThree.book(5, 10));
        System.out.println(myCalendarThree.book(25, 55));
    }
}

class MyCalendarThree {
    List<int[]> list = new ArrayList<>();

    public MyCalendarThree() {

    }

    public int book(int start, int end) {
        list.add(new int[]{start, end-1});
        return getLength();
    }

    public int getLength() {
        List<int[]> collect = list.stream().sorted((x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return x[0] - y[0];
            }
        }).collect(Collectors.toList());
        int max = 1;
        int last = -1;
        int cur = 1;
        for (int[] arr : collect) {
            if (last == -1) {
                last = arr[1];
            } else {
                if (last >= arr[0]) {
                    cur++;
                    last = arr[1];
                } else {
                    max = Math.max(max, cur);
                    cur = 1;
                }
            }
        }
        return max;
    }


}
class MyCalendarThree1 {
    private TreeMap<Integer, Integer> cnt;

    public MyCalendarThree1() {
        cnt = new TreeMap<Integer, Integer>();
    }

    public int book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
        }
        return ans;
    }
}
