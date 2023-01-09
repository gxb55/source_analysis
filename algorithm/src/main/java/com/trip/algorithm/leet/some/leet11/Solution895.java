package com.trip.algorithm.leet.some.leet11;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2022/11/30 09:49
 * @description Solution895
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-frequency-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution895 {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

    static class FreqStack {
        Map<Integer, Integer> timeMap;
        /**
         * 0 数字
         * 1 频率
         * 2 栈顶的距离
         */
        PriorityQueue<int[]> queue;
        int index;

        public FreqStack() {
            timeMap = new HashMap<>();
            index = 0;
            queue = new PriorityQueue<int[]>((x, y) -> {
                if (x[1] == y[1]) {
                    return y[2] - x[2];
                } else {
                    return y[1] - x[1];
                }
            });
        }

        public void push(int val) {
            Integer integer = timeMap.get(val);
            if (integer == null) {
                integer = 0;
            }
            timeMap.put(val, integer + 1);
            index++;
            queue.add(new int[]{val, integer + 1, index});
        }

        public int pop() {
            int[] poll = queue.poll();
            Integer integer = timeMap.get(poll[0]);
            if (integer == 1) {
                timeMap.remove(poll[0]);
            } else {
                timeMap.put(poll[0], integer - 1);
            }
            return poll[0];
        }
    }
}
