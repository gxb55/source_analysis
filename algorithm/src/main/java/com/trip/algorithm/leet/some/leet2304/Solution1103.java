package com.trip.algorithm.leet.some.leet2304;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author xbguo
 * @date 2023/4/3 19:16
 * 1053. 交换一次的先前排列
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 * <p>
 * 如果无法这么操作，就请返回原数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 * <p>
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 104
 * 通过次数20,869提交次数43,738
 */
public class Solution1103 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        //  int[] arr = {1,1,5};
        // int[] arr = {1,9,4,6,7};
     //   int[] arr = {3, 1, 1, 3};
        int[] ints = Solution1103.prevPermOpt1(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] prevPermOpt1(int[] arr) {
        a:
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int curVal = arr[i];
                OptionalInt first = Arrays.stream(arr).skip(i).filter(x -> x < curVal).max();
                if (first.isPresent()) {
                    for (int j = i; j < arr.length; j++) {
                        if (arr[j] == first.getAsInt()) {
                            int t = arr[i];
                            arr[i] = arr[j];
                            arr[j] = t;
                            break a;
                        }
                    }
                }
            }
        }
        return arr;
    }
}
