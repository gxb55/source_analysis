package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/6/14 15:08
 * 1375. 二进制字符串前缀一致的次数
 * 给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）。
 * <p>
 * 给你一个下标从 1 开始的整数数组 flips ，其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转。
 * <p>
 * 二进制字符串 前缀一致 需满足：在第 i 步之后，在 闭 区间 [1, i] 内的所有位都是 1 ，而其他位都是 0 。
 * <p>
 * 返回二进制字符串在翻转过程中 前缀一致 的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：flips = [3,2,4,1,5]
 * 输出：2
 * 解释：二进制字符串最开始是 "00000" 。
 * 执行第 1 步：字符串变为 "00100" ，不属于前缀一致的情况。
 * 执行第 2 步：字符串变为 "01100" ，不属于前缀一致的情况。
 * 执行第 3 步：字符串变为 "01110" ，不属于前缀一致的情况。
 * 执行第 4 步：字符串变为 "11110" ，属于前缀一致的情况。
 * 执行第 5 步：字符串变为 "11111" ，属于前缀一致的情况。
 * 在翻转过程中，前缀一致的次数为 2 ，所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：flips = [4,1,2,3]
 * 输出：1
 * 解释：二进制字符串最开始是 "0000" 。
 * 执行第 1 步：字符串变为 "0001" ，不属于前缀一致的情况。
 * 执行第 2 步：字符串变为 "1001" ，不属于前缀一致的情况。
 * 执行第 3 步：字符串变为 "1101" ，不属于前缀一致的情况。
 * 执行第 4 步：字符串变为 "1111" ，属于前缀一致的情况。
 * 在翻转过程中，前缀一致的次数为 1 ，所以返回 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == flips.length
 * 1 <= n <= 5 * 104
 * flips 是范围 [1, n] 中所有整数构成的一个排列
 * 通过次数20,495提交次数30,880
 */
public class Solution1375 {
    public static void main(String[] args) {
     //   int[] flips = {4, 1, 2, 3};
        int[] flips = {3,2,4,1,5};

        int i = numTimesAllBlue(flips);
        System.out.println(i);
    }

    public static int numTimesAllBlue(int[] flips) {
        int count = 0;
        long sum = 0;
        long max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < flips.length; i++) {
            int flip = flips[i];
            sum += flip;
            max = Math.max(max, flip);
            list.add(flip);
            if (max == list.size()  && sum == ((1 + max) * max) / 2) {
                count++;
            }
        }
        return count;
    }
}
