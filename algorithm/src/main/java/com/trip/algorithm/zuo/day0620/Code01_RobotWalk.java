package com.trip.algorithm.zuo.day0620;

/**
 * @author Administrator
 * 机器人走路的问题，
 * 1-n，在1的时候只能往右走，在n的时候只能往左走，在中间的位置可以左右移动
 */
public class Code01_RobotWalk {
    public static void main(String[] args) {
        int walk = walk(7, 5, 2, 3);
        int waysCache = waysCache(7, 5, 2, 3);
        int dp = waysDp(7, 5, 2, 3);
        System.out.println(walk);
        System.out.println(waysCache);
        System.out.println(dp);
    }

    /**
     * @param N 不变 总共有多长
     * @param M 可变  当前位置
     * @param K 可变 剩余步数
     * @param P 不变 终点，机器人要去的位置
     * @return
     */
    public static int ways1(int N, int M, int K, int P) {
        if (N < 1 || M > N | K < 1 | P > N | M < 1 | P < 1) {
            return 0;
        }
        return walk(N, M, K, P);
    }

    /**
     * @param n    总长度
     * @param cur  当前位置
     * @param rest 剩余步数
     * @param p    停止的位置
     * @return
     */
    public static int walk(int n, int cur, int rest, int p) {
        // 剩余步数为0 看当前位置是否在目标位置，如果在说明是一种成功的算法
        if (rest == 0) {
            return cur == p ? 1 : 0;
        }
        //如果移动到了最左边，那只能往右边移动
        if (cur == 1) {
            return walk(n, cur + 1, rest - 1, p);
        }
        //如果移动到了最右边，那只能往左移动
        if (cur == n) {
            return walk(n, cur - 1, rest - 1, p);
        }
        // 如果在中间位置那既可以往左，也可以往右
        return walk(n, cur - 1, rest - 1, p) + walk(n, cur + 1, rest - 1, p);
    }


    /**
     * @param N 最大值
     * @param M 当前位置 依赖
     * @param K 步数 依赖
     * @param P 终点
     * @return
     */
    public static int waysCache(int N, int M, int K, int P) {
        if (N < 1 || M > N | K < 1 | P > N | M < 1 | P < 1) {
            return 0;
        }
        // 当前位置剩余步数的情况
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return walkCache(N, M, K, P, dp);
    }

    /**
     * @param n    总长度
     * @param cur  当前位置
     * @param rest 剩余步数
     * @param p    停止的位置
     * @return
     */
    public static int walkCache(int n, int cur, int rest, int p, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        if (rest == 0) {
            dp[cur][rest] = cur == p ? 1 : 0;
            return dp[cur][rest];
        }
        //如果移动到了最左边，那只能往右边移动
        if (cur == 1) {
            dp[cur][rest] = walkCache(n, cur + 1, rest - 1, p, dp);
            return dp[cur][rest];
        }
        //如果移动到了最右边，那只能往左移动
        if (cur == n) {
            dp[cur][rest] = walkCache(n, cur - 1, rest - 1, p, dp);
            return dp[cur][rest];
        }
        // 如果在中间位置那既可以往左，也可以往右
        dp[cur][rest] = walkCache(n, cur - 1, rest - 1, p, dp) + walkCache(n, cur + 1, rest - 1, p, dp);
        return dp[cur][rest];
    }

    /**
     * @param N 总长度
     * @param M 当前位置
     * @param K 剩余步数
     * @param P 目的位置
     * @return
     */
    public static int waysDp(int N, int M, int K, int P) {
        if (N < 1 || M > N | K < 1 | P > N | M < 1 | P < 1) {
            return 0;
        }
        return walkDp(N, M, K, P);
    }

    /**
     * @param n    最大长度
     * @param cur
     * @param rest
     * @param p    目的地
     * @return
     */
    private static int walkDp(int n, int cur, int rest, int p) {
        if (rest == 0) {
            return cur == p ? 1 : 0;
        }
        if (cur < 1 || cur > n) {
            return 0;
        }
        return walkDp(n, cur - 1, rest - 1, p) + walkDp(n, cur + 1, rest - 1, p);
    }


}
