package com.trip.algorithm.zuo.day0829;

/**
 * 机器人走路问题，老师的方法
 */
public class Code01_RobotWalk {
    public static void main(String[] args) {
        int x = way1(7, 5, 2, 3);
        int y = wayCache(7, 5, 2, 3);
        int z = wayDp(7, 5, 2, 3);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    /**
     * @param N 总长度
     * @param M 当前位置
     * @param K 剩余步数
     * @param P 终点不变
     * @return
     */
    public static int way1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return walk(N, M, K, P);
    }

    /**
     * @param n    总长度不变
     * @param cur  当前位置
     * @param rest 剩余步数
     * @param p    终点不变
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
     * @param N 总长度
     * @param M 当前位置
     * @param K 剩余步数
     * @param P 终点不变
     * @return
     */
    public static int wayCache(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        //[rest][cur]
        int dp[][] = new int[K + 1][N + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return walkCache(N, M, K, P, dp);
    }

    /**
     * @param n    总长度不变
     * @param cur  当前位置
     * @param rest 剩余步数
     * @param p    终点不变
     * @return 记忆化搜索
     */
    public static int walkCache(int n, int cur, int rest, int p, int[][] dp) {
        // 如果之前存过这个值就不再展开递归了
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }

        if (rest == 0) {
            dp[rest][cur] = cur == p ? 1 : 0;
            return dp[rest][cur];
        }
        if (cur == 1) {
            dp[rest][cur] = walkCache(n, cur + 1, rest - 1, p, dp);
            return dp[rest][cur];
        }
        if (cur == n) {
            dp[rest][cur] = walkCache(n, cur - 1, rest - 1, p, dp);
            return dp[rest][cur];
        }
        dp[rest][cur] = walkCache(n, cur + 1, rest - 1, p, dp) + walkCache(n, cur - 1, rest - 1, p, dp);
        return dp[rest][cur];
    }

    /**
     * @param N 总长度
     * @param M 当前位置
     * @param K 剩余步数
     * @param P 终点不变
     * @return
     */
    public static int wayDp(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return walkDp(N, M, K, P);
    }

    /**
     * @param N
     * @param cur
     * @param rest
     * @param P
     * @return
     * 任何一个普遍位置都可以由他左边和他右边的位置算出来
     * cur rest = walkDp(N,cur-1,rest-1,P ) + walkDp(N,cur+1,rest-1,P)
     * 然后把特殊位置处理了，比如边界和不可能到达的地方
     * 边界 cur>N
     * 不可能到达 cur<1
     */
    public static int walkDp(int N, int cur, int rest, int P) {
        // 是否到达终点
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }
        if (cur > N || cur < 1) {
            return 0;
        }

        return walkDp(N,cur-1,rest-1,P ) + walkDp(N,cur+1,rest-1,P);
    }

}
