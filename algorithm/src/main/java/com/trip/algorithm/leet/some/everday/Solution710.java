package com.trip.algorithm.leet.some.everday;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2022年06月26日 08:41:00
 * <p>
 * 710. 黑名单中的随机数
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * <p>
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
 * int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * 输出
 * [null, 0, 4, 1, 6, 1, 0, 4]
 * <p>
 * 解释
 * Solution solution = new Solution(7, [2, 3, 5]);
 * solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
 * // 0、1、4和6的返回概率必须相等(即概率为1/4)。
 * solution.pick(); // 返回 4
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 6
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 0
 * solution.pick(); // 返回 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 109
 * 0 <= blacklist.length <= min(105, n - 1)
 * 0 <= blacklist[i] < n
 * blacklist 中所有值都 不同
 * pick 最多被调用 2 * 104 次
 * 通过次数11,936提交次数30,097
 */
public class Solution710 {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {2, 3, 5};
        Solution710Inner solution710Inner = new Solution710Inner(n, arr);
        for (int i = 0; i < 10; i++) {
            System.out.println(solution710Inner.pick());
        }
    }
}

class Solution710Inner {
    private int l;
    private List<Integer> list = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();


    public Solution710Inner(int n, int[] blacklist) {
        int len = blacklist.length;
        int mid = n - len;
        this.l = mid;
        for (int index : blacklist) {
            if (index >= mid) {
                list.add(index);
            }
        }
        int w = mid;
        for (int index : blacklist) {
            if (!list.contains(index)) {
                while (list.contains(w)) {
                    w++;
                }
                map.put(index, w);
                w++;
            }
        }

    }

    public int pick() {
        int i = random.nextInt(l);
        return map.getOrDefault(i, i);
    }
}