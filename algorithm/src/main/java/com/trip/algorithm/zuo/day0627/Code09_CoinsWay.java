package com.trip.algorithm.zuo.day0627;

/**
 * 找硬币的问题
 * 硬币数组是 3 7 8
 * 总钱数是52
 * 问能否找开，以及有多少种组合方式，每种硬币可以用多次
 *
 * @author Administrator
 */
public class Code09_CoinsWay {
    public static void main(String[] args) {
        int[] arr = {3, 7, 8};
        int aim = 18;
        int res = way1(arr, aim);
        int res2 = way2(arr, aim);
        System.out.println(res);
        System.out.println(res2);
        int i = way3(arr, aim);
        System.out.println(i);
    }

    /**
     * 递归求解
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int way1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int res = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            res += process1(arr, index + 1, rest - (arr[index] * zhang));
        }
        return res;
    }

    /**
     * 记忆化搜索，优化递归
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int way2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int i = process2(arr, 0, aim, dp);
        //print(dp);
        return i;
    }

    private static void print(int[][] dp) {
        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "  _");
            }
            System.out.println();
        }
    }


    public static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            int res = rest == 0 ? 1 : 0;
            dp[index][rest] = res;
            return dp[index][rest];
        }
        int res = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            res += process2(arr, index + 1, rest - (arr[index] * zhang), dp);
        }
        dp[index][rest] = res;
        return dp[index][rest];
    }


    public static int way3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        //在第n个领取的时候，即长度达到了零钱数组的最大，且aim为零的时候结果是1，所以dp[n][0]=1
        // 每一行只依赖他下面的哪行即 i依赖i+1所以是从 i->i+1
        //零钱aim本行不依赖，所以从左往右和从右往左无所谓
        // zhang数和递推中的算法是一样的
        dp[n][0] = 1;
        // 零钱数组
        for (int index = n-1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    //下左的位置
                    ways += dp[index + 1][rest - (arr[index] * zhang)];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }
}
