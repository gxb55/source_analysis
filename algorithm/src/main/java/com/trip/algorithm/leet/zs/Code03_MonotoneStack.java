package com.trip.algorithm.leet.zs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author xbguo
 * @createTime 2022年03月27日 18:25:00
 * 单调栈
 * <p>
 * 一个数组，左边离他最近值比他小的值，右边离他最近比他小的值；
 *
 * 设置一个栈，栈底到栈顶从小到大，按照顺序将数据压入栈中，如某个数压入时不满足此时的大小顺序要求，就需要将栈中的数弹出，此时记录这个数的左右情况，右边比这个数小的是当前准备压入的这个数，左边比他小的这个数是栈中当前数压着的那个。
 *
 * 当数组压完以后，栈中有剩余，则依次弹出，右边比当前数小的不存在，左边比当前数小的是栈中他压着的那个
 */
public class Code03_MonotoneStack {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 1, 3};
        int[][] nearLess = getNearLess(arr);
        Arrays.stream(nearLess).forEach(x -> {
            System.out.println(Arrays.toString(x));
        });
    }

    public static int[][] getNearLess(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int len = arr.length;
        int[][] result = new int[len][2];

        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int t = arr[i];
            // 栈底到栈顶 小 --- 大
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > t) {
                List<Integer> pop = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                int right = i;
                for (Integer integer : pop) {
                    result[integer][0] = left;
                    result[integer][1] = right;
                }
            }
            if (stack.isEmpty() || arr[stack.peek().get(0)] != t) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.add(list);
            } else {
                stack.peek().add(i);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            int right = -1;
            int left = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (int i : pop) {
                result[i][0] = left;
                result[i][1] = right;
            }
        }
        return result;
    }
}
