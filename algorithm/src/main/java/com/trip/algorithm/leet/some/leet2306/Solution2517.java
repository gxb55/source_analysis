package com.trip.algorithm.leet.some.leet2306;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/6/1 09:23
 * 示例 1：
 * <p>
 * 输入：price = [13,5,1,8,21,2], k = 3
 * 输出：8
 * 解释：选出价格分别为 [13,5,21] 的三类糖果。
 * 礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
 * 可以证明能够取得的最大甜蜜度就是 8 。
 * 示例 2：
 * <p>
 * 输入：price = [1,3,1], k = 2
 * 输出：2
 * 解释：选出价格分别为 [1,3] 的两类糖果。
 * 礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
 * 可以证明能够取得的最大甜蜜度就是 2 。
 * 示例 3：
 * <p>
 * 输入：price = [7,7,7,7], k = 2
 * 输出：0
 * 解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-tastiness-of-candy-basket
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2517 {
    public static void main(String[] args) {
      /*  int[] price = {13, 5, 1, 8, 21, 2};
        int k = 3; */

      /*  int[] price = {1, 3, 1};
        int k = 2; */

        int[] price = {7, 7, 7, 7};
        int k = 2;
        int i = maximumTastiness(price, k);
        System.out.println(i);
    }

    public static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int length = price.length;
        if (length == 2) {
            return Math.abs(price[0] - price[1]);
        }
        int min = Math.abs(price[0] - price[1]);
        int max = Math.abs(price[length - 1] - price[0]);
        for (int i = 1; i < length; i++) {
            min = Math.min(Math.abs(price[i] - price[i - 1]), min);
        }
        int res = 0;
        while (min <= max) {
            int mid = (max + min) / 2;
            int last = price[0];
            int count = 1;
            for (int i = 1; i < length; i++) {
                if ((price[i] - last) >= mid) {
                    last = price[i];
                    count++;
                    if (count >= k) {
                        break;
                    }
                }
            }
            if (count >= k) {
                res = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return res;
    }
}
