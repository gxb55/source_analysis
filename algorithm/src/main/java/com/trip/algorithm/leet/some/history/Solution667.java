package com.trip.algorithm.leet.some.history;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/4/11  21:45
 * @description 优美的排列 II
 * 667. 优美的排列 II
 * 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 * <p>
 * 假设该列表是 answer = [a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 1
 * 输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 * 示例 2：
 * <p>
 * 输入：n = 3, k = 2
 * 输出：[1, 3, 2]
 * 解释：[1, 3, 2] 包含 3 个范围在 1-3 的不同整数，并且 [2, 1] 中有且仅有 2 个不同整数：1 和 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k < n <= 104
 * <p>
 * <p>
 * 通过次数9,198提交次数14,754
 */
public class Solution667 {
    Boolean flag = false;

    public static void main(String[] args) {
        Solution667 solution667 = new Solution667();
        int[] ints = solution667.constructArray(10, 4);
        System.out.println(Arrays.toString(ints));
    }

    public int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        int l = n - k;
        for (int i = 0; i < l; i++) {
            arr[i] = i + 1;
        }
        int index = k;
        boolean flag = true;
        for (int i = l; i < n ; i++) {
            if (flag) {
                arr[i] = arr[i - 1] + index;
            } else {
                arr[i] = arr[i - 1] - index;
            }
            flag = !flag;
            index--;
        }
        return arr;
    }

    private List<Integer> process(List<Integer> list, List<Integer> tempList, int k) {
        if (tempList.size() == list.size()) {
            if (check(tempList, k)) {
                flag = true;
                return tempList;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (tempList.contains(list.get(i))) {
                continue;
            }
            tempList.add(list.get(i));
            if (!check1(tempList, k)) {
                tempList.remove(Integer.valueOf(list.get(i)));
                continue;
            }
            process(list, tempList, k);
            if (flag) {
                return tempList;
            }
            tempList.remove(Integer.valueOf(list.get(i)));
        }
        return tempList;
    }

    private boolean check(List<Integer> tempList, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < tempList.size(); i++) {
            int i1 = tempList.get(i) - tempList.get(i - 1);
            set.add(Math.abs(i1));
            if (set.size() > k) {
                return false;
            }
        }
        if (set.size() == k) {
            return true;
        }
        return false;
    }

    private boolean check1(List<Integer> tempList, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < tempList.size(); i++) {
            int i1 = tempList.get(i) - tempList.get(i - 1);
            set.add(Math.abs(i1));
            if (set.size() > k) {
                return false;
            }
        }
        return true;
    }
}
