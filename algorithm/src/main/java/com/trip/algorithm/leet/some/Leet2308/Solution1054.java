package com.trip.algorithm.leet.some.Leet2308;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/8/30 11:00
 * 它可以 往前 跳恰好 a 个位置（即往右跳）。
 * 它可以 往后 跳恰好 b 个位置（即往左跳）。
 * 它不能 连续 往后跳 2 次。
 * <p>
 * 输入：forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
 * 输出：2
 * 解释：往前跳一次（0 -> 16），然后往回跳一次（16 -> 7），跳蚤就到家了。
 */
public class Solution1054 {
    public static void main(String[] args) {
        Solution1054 solution1054 = new Solution1054();
       /* int[] forbidden = {14, 4, 18, 1, 15};
        int a = 3, b = 15, x = 9;*/

     /*   int[] forbidden = {1,6,2,14,5,17,4};
        int a = 16, b = 9, x = 7; */

        int[] forbidden = {162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98};
        int a = 29, b = 98, x = 80;
        int i = solution1054.minimumJumps(forbidden, a, b, x);
        System.out.println(i);
        System.out.println(solution1054.minimumJumps1(forbidden, a, b, x));
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int low = 0;
        int high = 6000;
        LinkedList<int[]> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.stream(forbidden).forEach(z -> set.add(z));
        Set<Integer> vis = new HashSet<>();
        // 当前位置 方向 步数
        int[] arr = new int[]{0, 1, 0};
        list.add(arr);
        while (!list.isEmpty()) {
            int[] ints = list.pollFirst();
            int cur = ints[0];
            int director = ints[1];
            int step = ints[2];
            if (cur == x) {
                return step;
            }
            int curA = cur + a;
            if (curA >= low && curA <= high && !set.contains(curA) && vis.add(curA * 1)) {
                list.addLast(new int[]{curA, 1, step + 1});
            }
            int curB = cur - b;
            if (director != -1) {
                if (curB >= low && curB <= high && !set.contains(curB) && vis.add(curB * -1)) {
                    list.addLast(new int[]{curB, -1, step + 1});
                }
            }
        }
        return -1;

    }

    private void process(int[] dp, int cur, boolean backFlag, int total) {
        if (cur < 0 || cur >= dp.length || dp[cur] == -1 || total >= dp[cur]) {
            return;
        }
        dp[cur] = total;

        if (backFlag) {
            process(dp, cur - back, false, total + 1);
        }
        process(dp, cur + front, true, total + 1);
    }

    public int minimumJumps1(int[] forbidden, int a, int b, int x) {
        int[] dp = new int[800];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i : forbidden) {
            dp[i] = -1;
        }
        int step = 0;
        front = a;
        back = b;
        doGetMinimumJumps(0, false, step, dp);
        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }


    private void doGetMinimumJumps(int cur, boolean flag, int step, int[] dp) {
        if (cur < 0 || cur > dp.length - 1 || dp[cur] == -1 || step >= dp[cur]) {
            return;
        }
        dp[cur] = step;
        doGetMinimumJumps(cur + front, true, step + 1, dp);
        if (flag) {
            doGetMinimumJumps(cur - back, false, step + 1, dp);
        }

    }

    private int front, back;


    public int minimumJumps2(int[] forbidden, int a, int b, int x) {
        Queue<int[]> queue = new ArrayDeque<int[]>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.offer(new int[]{0, 1, 0});
        visited.add(0);
        int lower = 0, upper = Math.max(Arrays.stream(forbidden).max().getAsInt() + a, x) + b;
        Set<Integer> forbiddenSet = new HashSet<Integer>();
        for (int position : forbidden) {
            forbiddenSet.add(position);
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int position = arr[0], direction = arr[1], step = arr[2];
            if (position == x) {
                return step;
            }
            int nextPosition = position + a;
            int nextDirection = 1;
            if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                visited.add(nextPosition * nextDirection);
                queue.offer(new int[]{nextPosition, nextDirection, step + 1});
            }
            if (direction == 1) {
                nextPosition = position - b;
                nextDirection = -1;
                if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                    visited.add(nextPosition * nextDirection);
                    queue.offer(new int[]{nextPosition, nextDirection, step + 1});
                }
            }
        }
        return -1;
    }

}
