package com.trip.algorithm.leet.some.history;

import java.util.*;

/**
 * @author xbguo
 * @date 2021/12/30  16:55
 * @description 1654. 到家的最少跳跃次数
 * 有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
 * <p>
 * 跳蚤跳跃的规则如下：
 * <p>
 * 它可以 往前 跳恰好 a 个位置（即往右跳）。
 * 它可以 往后 跳恰好 b 个位置（即往左跳）。
 * 它不能 连续 往后跳 2 次。
 * 它不能跳到任何 forbidden 数组中的位置。
 * 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
 * <p>
 * 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
 * 输出：3
 * 解释：往前跳 3 次（0 -> 3 -> 6 -> 9），跳蚤就到家了。
 * 示例 2：
 * <p>
 * 输入：forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
 * 输出：2
 * 解释：往前跳一次（0 -> 16），然后往回跳一次（16 -> 7），跳蚤就到家了。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= forbidden.length <= 1000
 * 1 <= a, b, forbidden[i] <= 2000
 * 0 <= x <= 2000
 * forbidden 中所有位置互不相同。
 * 位置 x 不在 forbidden 中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-jumps-to-reach-home
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * [8,3,16,6,12,20]
 * 15
 * 13
 * 11
 *
 * 1654
 */
public class Solution1654 {
    public static void main(String[] args) {
        Solution1654 solution1654 = new Solution1654();
        // int[] arr = {14, 4, 18, 1, 15};


        int[] arr = {1998};

        int a = 1999, b = 2000, x = 2000;

        int i = solution1654.minimumJumps(arr, a, b, x);
        System.out.println(i);
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int[] dp = new int[8000];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i : forbidden) {
            dp[i] = -1;
        }
        int step = 0;
        front = a;
        back = b;
        pos = x;
        doGetMinimumJumps(0, false, step, dp);
        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }


    private void doGetMinimumJumps(int cur, boolean flag, int step, int[] dp) {
        if (cur < 0 || cur > dp.length-1 || dp[cur] == -1 || step >= dp[cur]) {
            return;
        }
        dp[cur] = step;
        if (flag) {
            doGetMinimumJumps(cur - back, false, step + 1, dp);
        }
        doGetMinimumJumps(cur + front, true, step + 1, dp);
    }

    private int[] dp = new int[4001];
    private int front, back, pos;

    public int minimumJumps1(int[] forbidden, int a, int b, int x) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i : forbidden) {
            dp[i] = -1;
        }
        front = a;
        back = b;
        pos = x;
        jump(0, 0, false);
        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }

    public void jump(int cur, int step, boolean tag) {
        if (cur < 0 || cur > 4000 || step >= dp[cur]) return;
        dp[cur] = step;
        if (tag) {
            jump(cur - back, 1 + step, false);
        }
        jump(cur + front, 1 + step, true);
    }



    class Node {
        int p;
        int c;
        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    };

    public int minimumJumps2(int[] forbidden, int a, int b, int x) {
        if(x == 0) return 0;

        int MAX = 4000;
        Queue<Node> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int forbidd : forbidden) {
            set.add(forbidd);
        }
        // 往前跳和往后跳是两个Set集合
        Set<Integer> visitedF = new HashSet<>();
        Set<Integer> visitedB = new HashSet<>();

        q.offer(new Node(0, 0));
        int ans = 0;

        while(!q.isEmpty()) {
            int sz = q.size();
            ans++;
            for(int i=0; i<sz; i++) {
                Node cur = q.poll();

                int f = cur.p + a;
                if (f == x) return ans;
                if(f <= MAX && !set.contains(f) && !visitedF.contains(f)) {
                    visitedF.add(f);
                    q.offer(new Node(f, 0));
                }

                int back = cur.p - b;
                if (back == x) return ans;
                // 往后跳不能连续跳两次
                if (cur.c != 1 && back >= 0 && !set.contains(back) && !visitedB.contains(back)) {
                    visitedB.add(back);
                    q.offer(new Node(back, 1));
                }
            }
        }
        return -1;
    }
}
