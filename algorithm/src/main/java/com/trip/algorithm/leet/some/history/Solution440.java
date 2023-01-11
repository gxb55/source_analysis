package com.trip.algorithm.leet.some.history;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author xbguo
 * @date 2022/3/23  20:27
 * @description 440
 * 440. 字典序的第K小数字
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 示例 2:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 1
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= k <= n <= 109
 * 通过次数30,510提交次数73,866
 */
public class Solution440 {

    public int findKthNumber(int n, int k) {
        Set<Integer> set = new TreeSet<>((x, y) -> {
            String s = x.toString();
            String s1 = y.toString();
            return s.compareTo(s1);
        });
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        Optional<Integer> first = set.stream().skip(k).findFirst();
        return first.get();
    }

    public static void main(String[] args) {
        Solution440 solution440 = new Solution440();
        int n = 4289384;
        int k = 1922239;

        int kthNumber = solution440.findKthNumber1(n, k);
        System.out.println(kthNumber);
    }

    public int findKthNumber1(int n, int k) {
        int cur=1;//第一字典序小的(就是1)
        int prefix=1;// 前缀从1开始
        while(cur<k) {
            int tmp=count(n,prefix); //当前prefix峰的值
            if(tmp+cur>k) {// 找到了
                prefix*=10; //往下层遍历
                cur++;//一直遍历到第K个推出循环
            }else {
                prefix++;//去下个峰头(前缀)遍历
                cur+=tmp;//跨过了一个峰(前缀)
            }
        }//退出循环时 cur==k 正好找到
        return prefix;
    }

    private int count(int n, int prefix) {
        //不断向下层遍历可能一个乘10就溢出了, 所以用long
        long cur = prefix;
        long next = cur + 1;//下一个前缀峰头
        int count = 0;
        while (cur <= n) {
            count += Math.min(n + 1, next) - cur;//下一峰头减去此峰头
            // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
            // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层

            // 如果说现在prefix是10，next是20，那么现在分别变成100和200，
            // 1为前缀的子节点增加100个，十叉树又增加了一层，变成了三层
            cur *= 10;
            next *= 10; //往下层走
        }
        return count;
    }
}
