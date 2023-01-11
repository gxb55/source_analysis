package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/1/10 16:28
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * 通过次数468,938提交次数606,855
 */
public class Solution77 {
    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        int n = 4, k = 2;
        List<List<Integer>> combine = solution77.combine1(n, k);
        combine.forEach(x -> {
            System.out.println(x);
        });
        System.out.println("==================");
        List<List<Integer>> combine1 = solution77.combine(n, k);
        combine1.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        process(n, k, 1, temp, list);
        return list;
    }

    private void process(int n, int count, int index, List<Integer> temp, List<List<Integer>> list) {
        if (temp.size() == count) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            process(n, count, i + 1, temp, list);
            temp.remove(Integer.valueOf(i));
        }
    }


    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] vis = new boolean[n + 1];
        int index = 1;
        bfs(list, n, k, tempList, vis, index);
        return list;
    }

    private void bfs(List<List<Integer>> list, int n, int k, List<Integer> tempList, boolean[] vis, int index) {
        if (tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index; i <= n; i++) {
           /* if (vis[i]) {
                continue;
            }*/
            tempList.add(i);
          //  vis[i] = true;
            bfs(list, n, k, tempList, vis, i + 1);
            //vis[i] = false;
            tempList.remove(Integer.valueOf(i));
        }
    }
}
