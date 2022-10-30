package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年06月03日 11:20:00
 * 473. 火柴拼正方形
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * <p>
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 * <p>
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 108
 * 通过次数53,875提交次数116,192
 */
public class Solution473 {
    public static void main(String[] args) {
        Solution473 solution473 = new Solution473();
        int[] matchsticks = {1, 1, 2, 2, 2};
        boolean makesquare = solution473.makesquare(matchsticks);
        System.out.println(makesquare);
    }

    public boolean makesquare(int[] matchsticks) {
        int len = matchsticks.length;
        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int i = sum / 4;
        int[] arr = new int[4];

        Arrays.sort(matchsticks);
        return backtrack(matchsticks, 0, arr, arr.length, i);
    }


    private boolean backtrack(int[] nums, int index, int[] bucket, int k, int target) {

        // 结束条件：已经处理完所有球
        if (index == nums.length) {
            // 判断现在桶中的球是否符合要求 -> 路径是否满足要求
            for (int i = 0; i < k; i++) {
                if (bucket[i] != target) return false;
            }
            return true;
        }

        // nums[index] 开始做选择
        for (int i = 0; i < k; i++) {
            // 剪枝：放入球后超过 target 的值，选择一下桶
            if (bucket[i] + nums[index] > target) continue;
            // 做选择：放入 i 号桶
            bucket[i] += nums[index];

            // 处理下一个球，即 nums[index + 1]
            if (backtrack(nums, index + 1, bucket, k, target)) return true;

            // 撤销选择：挪出 i 号桶
            bucket[i] -= nums[index];
        }

        // k 个桶都不满足要求
        return false;
    }

}
