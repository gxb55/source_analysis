package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/6/7  21:42
 * @description 1011
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], days = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], days = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 * 通过次数77,150提交次数124,384
 */
public class Solution1011 {
    public static void main(String[] args) {
        Solution1011 solution1011 = new Solution1011();
      /*  int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;*/

       /* int[] weights = {1, 2, 3, 1, 1};
        int days = 4; */

        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 10;
        int i = solution1011.shipWithinDays(weights, days);
        System.out.println(i);
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max=0;
        for (int a : weights) {
            max = Math.max(max,a);
            sum += a;
        }
        int l = max;
        int r = sum;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cur = 0;
            int temp = 1;
            for (int a : weights) {
                if (a > mid) {
                    temp++;
                    cur = 0;
                }
                if ((cur + a) > mid) {
                    temp++;
                    cur = 0;
                }
                cur = cur + a;
            }
            if (temp > days) {
                l = mid + 1;
            } else {
                if (res == 0) {
                    res = mid;
                } else {
                    res = Math.min(res, mid);
                }
                r = mid - 1;
            }
        }
        return l;
    }
}
