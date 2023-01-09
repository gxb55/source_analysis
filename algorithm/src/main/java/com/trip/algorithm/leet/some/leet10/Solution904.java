package com.trip.algorithm.leet.some.leet10;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: xbguo
 * @date: 2022/10/17 15:20
 * @description: 904
 * 904. 水果成篮
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * <p>
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * <p>
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。
 * 每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 * 示例 2：
 * <p>
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 * 示例 3：
 * <p>
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 * 示例 4：
 * <p>
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= fruits.length <= 105
 * 0 <= fruits[i] < fruits.length
 * 通过次数85,434提交次数191,184
 */
public class Solution904 {
    public static void main(String[] args) {
        Solution904 solution904 = new Solution904();
        int[] arr = {1, 2, 1};
        arr = new int[]{0, 1, 2, 2};
        arr = new int[]{1, 2, 3, 2, 2};
        arr = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        arr = new int[]{3};
        int i = solution904.totalFruit(arr);
        System.out.println(i);
    }

    public int totalFruit(int[] fruits) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < fruits.length; i++) {
            int val = fruits[i];
            int len = 0;
            while (i < fruits.length && val == fruits[i]) {
                len++;
                i++;
            }
            i--;
            list.add(new int[]{val, len});
        }
        int max = 0;
        if (list.size() <= 2) {
            for (int[] arr : list) {
                max = max + arr[1];
            }
            return max;
        }


        for (int i = 0; i < list.size() - 1; i++) {
            int sum = 0;
            int[] ints = list.get(i);
            int[] ints1 = list.get(i + 1);
            int v1 = ints1[0];
            int v2 = ints[0];

            sum = sum + ints1[1] + ints[1];
            i++;
            i++;
            while (i < list.size() && (list.get(i)[0] == v2 || list.get(i)[0] == v1)) {
                sum = sum + list.get(i)[1];
                i++;
            }
            max = Math.max(max, sum);
            if (i == list.size()) {
                return max;
            }
            i--;
            int index = i;
            while (list.get(index)[0] == list.get(i)[0]) {
                i--;
            }
        }
        return max;
    }
}
