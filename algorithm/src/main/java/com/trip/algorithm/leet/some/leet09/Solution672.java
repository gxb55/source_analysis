package com.trip.algorithm.leet.some.leet09;

import java.util.*;

/**
 * @Classname Solution672
 * @Description Solution672
 * @Date 2022/9/15 19:08
 * @Created by xbguo
 */
public class Solution672 {
    public static void main(String[] args) {
        System.out.println(1 << 4);
        Solution672 solution672 = new Solution672();
        int i = solution672.flipLights(3,1);
        System.out.println(i);

        int[] arr={7,1,5,3,6,4};
        int i1 = solution672.maxProfit(arr);
        System.out.println(i1);
    }
    Set<String> result = new HashSet<>();

    public int flipLights1(int n, int presses) {
        List<String> list = new ArrayList<>();
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        int begin=0;
        return 1;
    }

    /**
     *
     *  * 当n == 1时，开关1、3、4对其造成影响，也只有开和关两种状态
     *  * 当n == 2时，按照推理111的状态推理11，按一次有3种，按2次及以上有4种。
     *  * 当n == 3时，按一次有4种，按2次及以上有7种,3次及以上有8种。
     * @param n  灯的数量
     * @param presses 按压次数
     * @return
     */
    public int flipLights(int n, int presses) {
        //不按开关
        if (presses == 0) {
            return 1;
        }
        //特殊情况处理
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            //特殊情况
            return presses == 1 ? 3 : 4;
        } else {
            //n >= 3
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        int length = prices.length;
        // 分别对应 第i天是否持股
        int dp[][] = new int[length][2];
        // 第0天如果没持股则是0
        dp[0][0] = 0;
        // 第0天如果持股则需要支付 -prices[0] 钱
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        for (int i = 0; i < length; i++) {
            System.out.println(dp[i][0]+" "+dp[i][1]+" "+prices[i]);
        }
        return dp[length - 1][0];
    }
}
