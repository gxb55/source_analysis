package com.trip.algorithm.leet.some.leet2305;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年05月07日 17:28:00
 * 1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 * <p>
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 * 通过次数34,307提交次数69,965
 */
public class Solution1010 {
    public static void main(String[] args) {
         int[] time = {30,20,150,100,40};
       // int[] time = {60, 60, 60};
        int i = numPairsDivisibleBy60(time);
        System.out.println(i);
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int[] dp = new int[60];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < time.length; i++) {
            int i1 = time[i] % 60;
            dp[i1]++;
            if (!list.contains(i1)) {
                list.add(i1);
            }
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if ((list.get(i) + list.get(j)) == 60) {
                    count += dp[list.get(i)] * dp[list.get(j)];
                }
            }
            int v = dp[list.get(i)];
            if (list.get(i) == 30 && v > 0) {
                while (v > 1) {
                    count = count + v - 1;
                    v--;
                }
            }
            if (list.get(i) == 0 && v > 0) {
                while (v > 1) {
                    count = count + v - 1;
                    v--;
                }
            }
        }
        return count;
    }
}
