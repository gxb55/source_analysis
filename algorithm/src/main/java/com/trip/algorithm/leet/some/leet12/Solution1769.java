package com.trip.algorithm.leet.some.leet12;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/12/2 10:11
 * @description Solution1769
 * 1769. 移动所有球到每个盒子所需的最小操作数
 * 有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
 * <p>
 * 在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
 * <p>
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
 * <p>
 * 每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：boxes = "110"
 * 输出：[1,1,3]
 * 解释：每个盒子对应的最小操作数如下：
 * 1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
 * 2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
 * 3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共计 3 步操作。
 * 示例 2：
 * <p>
 * 输入：boxes = "001011"
 * 输出：[11,8,5,4,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == boxes.length
 * 1 <= n <= 2000
 * boxes[i] 为 '0' 或 '1'
 */
public class Solution1769 {
    public static void main(String[] args) {
        Solution1769 solution1769 = new Solution1769();
        //String boxes = "110";
        String boxes = "001011";
        int[] ints = solution1769.minOperations(boxes);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(solution1769.minOperations1(boxes)));
    }

    public int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        int len = chars.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum = sum + (i - j) * (chars[j] - '0');
            }
            for (int j = i; j < len; j++) {
                sum = sum + (j - i) * (chars[j] - '0');
            }
            result[i] = sum;
        }
        return result;
    }

    public int[] minOperations1(String boxes) {
        char[] chars = boxes.toCharArray();
        int len = chars.length;
        int[] result = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        int sum = 0;
        int t = 0;
        for (int i = 0; i < len; i++) {
            char aChar = chars[i];
            left[i] = sum;
            if (aChar == '1') {
                t++;
            }
            sum = sum + t;
        }
        sum = 0;
        t = 0;
        for (int i = len - 1; i >= 0; i--) {
            char aChar = chars[i];
            right[i] = sum;
            if (aChar == '1') {
                t++;
            }
            sum = sum + t;
        }
        for (int i = 0; i < len; i++) {
            result[i] = left[i] + right[i];
        }


        return result;
    }
}
