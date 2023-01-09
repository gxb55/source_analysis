package com.trip.algorithm.leet.some.leet10;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: xbguo
 * @date: 2022/10/20 09:36
 * @description: Solution779
 * 779. 第K个语法符号
 * 我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * 示例 2:
 * <p>
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 示例 3:
 * <p>
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 */
public class Solution779 {
    public static void main(String[] args) {
        Solution779 solution779 = new Solution779();
        //  int n = 1, k = 1;
        // int n = 2, k = 1;
        // 30
        //434991989
        // int n = 10, k = 2;
        int n = 30, k = 434991989;
        int i = solution779.kthGrammar(n, k);
        int i1 = solution779.kthGrammar1(n, k);
        System.out.println("----------------------");
        System.out.println(i);
        System.out.println(i1);
    }

    public int kthGrammar(int n, int k) {
        String last = "0";
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(last);
        for (int i = 1; i < n; i++) {
            stringBuilder.setLength(0);
            for (int j = 0; j < last.length(); j++) {
                char c = last.charAt(j);
                if (c == '0') {
                    stringBuilder.append("01");
                } else {
                    stringBuilder.append("10");
                }
            }
            last = stringBuilder.toString();
          //  System.out.println(last);
        }
        return last.charAt(k - 1) - '0';
    }

    public int kthGrammar1(int n, int k) {
        List<int[]> list = new ArrayList<>();
        process(n, k - 1, true, list);
        int lastN = -1;
        int lastK = -1;
        int val = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int[] arr = list.get(i);
            if (lastK == -1 || lastN == -1) {
                lastK = arr[1];
                lastN = arr[0];
            } else {
                int t = arr[1];
                boolean b = t % 2 == 1;
                if (b) {
                    val = val == 0 ? 1 : 0;
                }
            }
        }
        return val;
    }

    private int process(int n, int k, boolean flag, List<int[]> list) {
        list.add(new int[]{n, k});
        if (k == 0) {
            if (flag) {
                return 0;
            } else {
                return 1;
            }
        }
        int last = k / 2;
        int r = k % 2;
        return process(n - 1, last, r == 1 ? true : false, list);
    }
}
