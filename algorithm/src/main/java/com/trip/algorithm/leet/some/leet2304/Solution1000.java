package com.trip.algorithm.leet.some.leet2304;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/4/4 19:11
 */
public class Solution1000 {
    public static void main(String[] args) {
       /* int[] stones = {3, 5, 1, 2, 6};
        int k = 3; */

       /* int[] stones = {3,2,4,1};
        int k = 3;*/

        int[] stones = {3, 2, 4, 1};
        int k = 2;

       /* int[] stones = {3, 7, 2, 3};
        int k = 2;
*/
        int i = mergeStones(stones, k);
        System.out.println(i);
    }

    public static int mergeStones(int[] stones, int k) {
        int length = stones.length;
        if (length == 1) {
            return 0;
        } else if (k > length) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        int sum = 0;
        while (list.size() > k) {
            int index = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size() - k + 1; i++) {
                int cur = 0;
                for (int j = i; j < i + k; j++) {
                    cur += list.get(j);
                }
                if (cur < min) {
                    min = cur;
                    index = i;
                }
            }
            if (index != -1) {
                int cur = 0;
                for (int i = index; i < index + k; i++) {
                    cur += list.get(i);
                }
                for (int i = index; i < index + k; i++) {
                    if (i != index) {
                        list.remove(index + 1);
                    }
                }
                list.set(index, cur);
                sum = sum + cur;
            }
        }
        if (list.size() == k) {
            for (Integer integer : list) {
                sum += integer;
            }
            return sum;
        } else if (list.size() != 1) {
            return -1;
        }
        return sum;
    }

    private int[][][] memo;
    private int[] s;
    private int k;

    public int mergeStones1(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) // 无法合并成一堆
        {
            return -1;
        }

        s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + stones[i]; // 前缀和
        }
        this.k = k;
        memo = new int[n][n][k + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(memo[i][j], -1); // -1 表示还没有计算过
            }
        }
        return dfs(0, n - 1, 1);
    }

    private int dfs(int i, int j, int p) {
        if (memo[i][j][p] != -1) {
            return memo[i][j][p];
        }
        if (p == 1) // 合并成一堆
        {
            return memo[i][j][p] = i == j ? 0 : dfs(i, j, k) + s[j + 1] - s[i];
        }
        int res = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1) // 枚举哪些石头堆合并成第一堆
        {
            res = Math.min(res, dfs(i, m, 1) + dfs(m + 1, j, p - 1));
        }
        return memo[i][j][p] = res;
    }
}