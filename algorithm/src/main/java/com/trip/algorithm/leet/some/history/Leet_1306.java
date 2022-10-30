package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xbguo
 * @createTime 2022年05月28日 22:47:00
 * <p>
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * <p>
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 * <p>
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 * <p>
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 * 通过次数23,632提交次数40,643
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet_1306 {
    public static void main(String[] args) {
        Leet_1306 leet_1306 = new Leet_1306();
       /* int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 0; */

        int[] arr = {0, 3, 0, 6, 3, 3, 4};
        int start = 6;
        boolean b = leet_1306.canReach(arr, start);
        System.out.println(b);
    }

    public boolean canReach(int[] arr, int start) {
        int length = arr.length;

        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                indexs.add(i);
            }
        }
        boolean[] dp = new boolean[length];

        Queue<Integer> list = new LinkedList<>();
        list.add(start);
        while (!list.isEmpty()) {
            Integer integer = list.poll();
            dp[integer] = true;
            int val = arr[integer];
            int left = integer - val;
            int right = integer + val;
            if (left >= 0 && !dp[left]) {
                list.add(left);
            }
            if (right < length && !dp[right]) {
                list.add(right);
            }
        }
        for (Integer integer : indexs) {
            if (dp[integer]) {
                return true;
            }
        }
        return false;
    }
}
