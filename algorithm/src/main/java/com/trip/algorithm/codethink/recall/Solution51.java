package com.trip.algorithm.codethink.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/1/17 14:48
 * 51. N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Solution51 {
    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        int n = 5;
        List<List<String>> list = solution51.solveNQueens(n);
        for (int i = 0; i < list.size(); i++) {
            List<String> list1 = list.get(i);
            for (int j = 0; j < list1.size(); j++) {
                System.out.println(Arrays.toString(list1.get(j).split(",")));
            }
            System.out.println("==================================");
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        process(0, n, list, temp);
        List<List<String>> res = new ArrayList<>();
        for (List<String> list1:list){
            List<String> list2 =  new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                String replace = list1.get(i).replace(",", "");
                list2.add(replace);
            }
            res.add(list2);
        }
        return res;
    }

    private void process(int curIndex, int len, List<List<String>> list, List<String> temp) {
        if (temp.size() == len) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = curIndex; i < len; i++) {
            String res = check(i, temp, len);
            if (res != null) {
                temp.add(res);
                process(0, len, list, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private String check(int index, List<String> list, int len) {
        List<List<String>> list1 = new ArrayList<>();
        list.forEach(x -> {
            String[] split = x.split(",");
            list1.add(List.of(split));
        });
        for (List<String> tempList : list1) {
            if (tempList.get(index).equals("Q")) {
                return null;
            }
        }
        // 行
        int row = list.size() - 1;
        // 列
        int col = index - 1;
        while (col >= 0 && row >= 0) {
            boolean q = list1.get(row).get(col).equals("Q");
            if (q) {
                return null;
            }
            col--;
            row--;
        }
        row = list.size() - 1;
        col = index + 1;
        while (row >= 0 && col < len) {
            boolean q = list1.get(row).get(col).equals("Q");
            if (q) {
                return null;
            }
            col++;
            row--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == index) {
                stringBuilder.append("Q").append(",");
            } else if (i == len - 1) {
                stringBuilder.append(".");
            } else {
                stringBuilder.append(".").append(",");
            }
        }
        return stringBuilder.toString();
    }
}
