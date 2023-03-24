package com.trip.algorithm.leet.some.leet2303;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年03月17日 08:46:00
 * 输入：nums = [4,5,2,1], queries = [3,10,21]
 * 输出：[2,3,4]
 * 解释：queries 对应的 answer 如下：
 * - 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
 * - 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
 * - 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,4,5], queries = [1]
 * 输出：[0]
 * 解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-subsequence-with-limited-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2389 {
    public static void main(String[] args) {

      /*  int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21}; */
       // ExecutorService executorService = Executors.newSingleThreadExecutor();
        int[] nums = {2, 3, 4, 5};
        int[] queries = {1};
        int[] ints = answerQueries(nums, queries);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        int sum1 = Arrays.stream(nums).sum();
        for (int i = 0; i < queries.length; i++) {
            int sum = queries[i];
            int cur = 0;
            int index = 0;
            if (sum >= sum1) {
                res[i] = nums.length;
            } else {
                for (int j = 0; j < nums.length; j++) {
                    if (cur > sum) {
                        break;
                    }
                    index++;
                    cur = cur + nums[j];
                }
                res[i] = --index;
            }
        }
        return res;
    }
}
