package com.trip.algorithm.leet.some.everday;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年07月03日 14:53:00
 * 556. 下一个更大元素 III
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 * <p>
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：21
 * 示例 2：
 * <p>
 * 输入：n = 21
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 通过次数28,565提交次数80,562
 */
public class Solution556 {
    public static void main(String[] args) {
        Solution556 solution556 = new Solution556();
        int n = 2147483486;
        int i = solution556.nextGreaterElement(n);
        System.out.println(i);
        int[] arr={6,5,8,7,6,3};
        solution556.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();

        int minIndex = -1;

        for (int i = chars.length - 1; i >= 1; i--) {
            if (chars[i] > chars[i - 1]) {
                minIndex = i-1;
                break;
            }
        }
        if (minIndex == -1) {
            return -1;
        }
        for (int i = chars.length - 1; i >minIndex; i--) {
            if(chars[i]>chars[minIndex]){
                char aChar = chars[minIndex];
                chars[minIndex]=chars[i];
                chars[i]=aChar;
                Arrays.sort(chars, minIndex+1, s.length());
                break;
            }
        }

        String s1 = new String(chars);
        long ans = Long.parseLong(s1);
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int min = -1;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                min = i - 1;
                break;
            }
        }
        // 当前已经是最大的序列了，则下一个序列是最小的
        if (min == -1) {
            int x = len / 2;
            for (int i = 0; i < x; i++) {
                swap(nums, i, len - i - 1);
            }
            return;
        }

        for (int i = len - 1; i > min; i--) {
            if (nums[i] > nums[min]) {
                swap(nums, i, min);
                Arrays.sort(nums, min + 1, len);
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int x = nums[i];
        nums[i] = nums[i1];
        nums[i1] = x;
    }
}
