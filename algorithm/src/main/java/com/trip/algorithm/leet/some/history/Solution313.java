package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/6/17  17:21
 * @description TODO
 * 313. 超级丑数
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * <p>
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * <p>
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 示例 2：
 * <p>
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 * 通过次数49,080提交次数82,751
 */
public class Solution313 {
    public static void main(String[] args) {
        Solution313 solution313 = new Solution313();
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        int i = solution313.nthSuperUglyNumber(n, primes);
        System.out.println(i);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        Arrays.sort(primes);
        int prime = primes[0];
        int pow = (int) Math.pow(prime, n);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < primes.length; i++) {
            int t = primes[i];
            int cur = t;
            int len = 1;
            while (cur < pow) {
                list.add(t * len);
                len++;
                cur = cur * len;
            }
        }
        List<Integer> collect = list.stream().sorted(Integer::compareTo).collect(Collectors.toList());


        return 1;

    }

}
