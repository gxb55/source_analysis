package com.trip.algorithm.leet.some.leet10;

/**
 * @auther: xbguo
 * @date: 2022/10/13 09:29
 * @description: Solution769
 * 769. 最多能完成排序的块
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * <p>
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 返回数组能分成的最多块数量。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: arr = [4,3,2,1,0]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
 * 示例 2:
 * <p>
 * 输入: arr = [1,0,2,3,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
 * 然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
 * <p>
 * <p>
 * 提示:
 * <p>
 * n == arr.length
 * 1 <= n <= 10
 * 0 <= arr[i] < n
 * arr 中每个元素都 不同
 * 通过次数27,208提交次数45,412
 */
public class Solution769 {
    public static void main(String[] args) {
        Solution769 solution769 = new Solution769();
        int[] arr = {4, 3, 2, 1, 0};
         arr = new int[]{1, 0, 2, 3, 4};
        /**
         * 输入：
         * [4,1,0,3,2,5,6]
         * 输出：
         * 4
         * 预期结果：
         * 3
         */
        arr = new int[]{4,1,0,3,2,5,6};
        int i = solution769.maxChunksToSorted(arr);
        System.out.println(i);
    }

    public int maxChunksToSorted(int[] arr) {
        int sum = 0;
        int lastVal = 0;
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (val == i&&lastIndex==0&&lastVal==0) {
                sum++;
            } else if (lastVal + val == lastIndex + i) {
                sum++;
                lastVal = 0;
                lastIndex = 0;
            } else {
                lastVal = lastVal + val;
                lastIndex = lastIndex + i;
            }
        }
        return sum;
    }

}
