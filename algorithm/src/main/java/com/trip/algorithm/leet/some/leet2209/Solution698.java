package com.trip.algorithm.leet.some.leet2209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年09月21日 08:24:00
 */
public class Solution698 {
    public static void main(String[] args) {
       /* int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;*/
      /*  int[] nums = {4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9};
        int k = 5; */
        int[] nums = {2, 2, 2, 2, 3, 4, 5};
        int k = 4;

        Solution698 solution698 = new Solution698();
        boolean b = solution698.canPartitionKSubsets1(nums, k);
        boolean b1 = solution698.canPartitionKSubsets(nums, k);
        System.out.println(b);
        System.out.println(b1);
    }

    int[] nums;
    int n, t, k;

    public boolean canPartitionKSubsets(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        int tot = 0;
        for (int x : nums) {
            tot += x;
        }
        if (tot % k != 0) {
            return false; // 可行性剪枝
        }
        Arrays.sort(nums);
        n = nums.length;
        t = tot / k;
        return dfs(n - 1, 0, 0, new boolean[n]);
    }

    /**
     * @param idx 下标
     * @param cur 当前元素的和
     * @param cnt 当前的次数
     * @param vis 访问过的元素
     * @return
     */
    boolean dfs(int idx, int cur, int cnt, boolean[] vis) {
        if (cnt == k) {
            return true;
        }
        if (cur == t) {
            return dfs(n - 1, 0, cnt + 1, vis);
        }
        for (int i = idx; i >= 0; i--) {  // 顺序性剪枝
            if (vis[i] || cur + nums[i] > t) {
                continue;  // 可行性剪枝
            }
            vis[i] = true;
            if (dfs(i - 1, cur + nums[i], cnt, vis)) {
                return true;
            }
            vis[i] = false;
            if (cur == 0) {
                return false; // 可行性剪枝
            }
        }
        return false;
    }

    int k1;

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        k1 = k;
        int cur = sum / k;
        int len = nums.length;
        list.sort(Comparator.reverseOrder());
        boolean[] dp = new boolean[len];
        int index = 0;
        int t = 0;
        return process(list, index, cur, dp, t, k);

    }

    private boolean process(List<Integer> nums, int index, int cur, boolean[] dp, int temp, int dk) {
        if (k1 == 0) {
            return true;
        }
        if (temp == cur) {
            return process(nums, 0, cur, dp, 0, k1 - 1);
        }
        for (int i = index; i < nums.size(); i++) {
            if (dp[i] || (temp + nums.get(i) > cur)) {
                continue;
            }
            dp[i] = true;
            boolean process1 = process(nums, i + 1, cur, dp, temp + nums.get(i), k1);
            if (process1) {
                return true;
            }
            dp[i] = false;
        }
        return false;
    }
}
