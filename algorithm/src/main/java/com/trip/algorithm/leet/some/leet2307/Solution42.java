package com.trip.algorithm.leet.some.leet2307;

/**
 * @author xbguo
 * @createTime 2023年07月23日 23:13:00
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution42 {
    public static void main(String[] args) {
      //  int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};
        int trap = trap(height);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int cur = height[0];
        left[0]=cur;
        for (int i = 1; i < length; i++) {
            int val = height[i];
            if (val > cur) {
                cur = val;
            }
            left[i] = cur;
        }
        cur = height[length - 1];
        right[length-1]=cur;
        for (int i = length - 2; i >= 0; i--) {
            int val = height[i];
            if (val > cur) {
                cur = val;
            }
            right[i] = cur;
        }
        int res = 0;
        for (int i = 1; i < length - 1; i++) {
            int val = height[i];
            int leftMaxVal = left[i - 1];
            int rightMaxVal = right[i + 1];
            if (val < leftMaxVal && val < rightMaxVal) {
                int t = Math.min(leftMaxVal, rightMaxVal);
                int temp = t - val;
                res += temp;
            }
        }
        return res;
    }
}
