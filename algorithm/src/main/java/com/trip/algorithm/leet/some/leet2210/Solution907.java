package com.trip.algorithm.leet.some.leet2210;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xbguo
 * @createTime 2022年10月30日 15:58:00
 * 907. 子数组的最小值之和
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 */
public class Solution907 {
    public static void main(String[] args) {
        Solution907 solution907 = new Solution907();
        int[] arr = {3, 1, 2, 4};
        int i = solution907.sumSubarrayMins(arr);
        System.out.println(i);
        int j = solution907.sumSubarrayMins1(arr);
        System.out.println(j);

    }
    private static final int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];

        Stack<Integer> list = new Stack<>();
        for (int i = 0; i < length; i++) {
            int cur = arr[i];
            while (!list.isEmpty() && arr[list.peek()] >= cur) {
                list.pop();
            }
            if (list.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = list.peek();
            }
            list.add(i);
        }
        list.clear();
        for (int i = length - 1; i >= 0; i--) {
            int cur = arr[i];
            while (!list.isEmpty() && arr[list.peek()] > cur) {
                list.pop();
            }
            if (list.isEmpty()) {
                right[i] = length;
            } else {
                right[i] = list.peek();
            }
            list.add(i);
        }
        long ans = 0;
        for (int i = 0; i < length; i++) {
            ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return (int) ans;
    }

        public int sumSubarrayMins1(int[] arr) {
            // 处理边界情况
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int n = arr.length;
            // 每个元素辐射范围的左边界
            int[] left = new int[n];
            // 每个元素辐射范围的右边界
            int[] right = new int[n];
            Deque<Integer> stack = new LinkedList<>();

            // 第一次循环先找到所有元素的左边界
            for (int i = 0; i < n; i++) {
                // 向左找第一个小于等于E的元素
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                // 设立一个最左边界-1
                if (stack.isEmpty()) {
                    left[i] = -1;
                } else {
                    left[i] = stack.peek();
                }
                // 下标入栈，方便同时得到i和A[i]
                stack.push(i);
            }

            // 第二次循环找到所有元素的右边界
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                // 向右找第一个小于E的元素
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                // 设立一个最右边界n
                if (stack.isEmpty()) {
                    right[i] = n;
                } else {
                    right[i] = stack.peek();
                }
                // 下标入栈，方便同时得到i和A[i]
                stack.push(i);
            }
            System.out.println(Arrays.toString(left));
            System.out.println(Arrays.toString(right));
            // 按照贡献度计算即可
            // 注意此处left[i]和right[i]实际上记录的是左边界-1和右边界+1，和上面思路中有些区别，便于计算
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
            }
            return (int)ans;
        }
    }

