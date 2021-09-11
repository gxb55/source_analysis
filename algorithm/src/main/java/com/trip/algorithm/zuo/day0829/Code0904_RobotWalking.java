package com.trip.algorithm.zuo.day0829;

/**
 * 机器人走路
 * 起始位置M
 * 终点位置P
 * 走K步
 * 全长N
 */
public class Code0904_RobotWalking {
    public static void main(String[] args) {
        int process = process(7, 2, 5, 3);
        int walk = walk(7, 5, 2, 3);
        System.out.println(process);
        System.out.println(walk);
    }

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
     * @param N 总长度 不变
     * @param K k步数 可变参数
     * @param M 初始位置 可以变
     * @param P 终点位置 不变
     * @return
     */
    public static int process(int N, int K, int M, int P) {
        // 走到终点了，步数也没有了结束了
        if (K == 0 && M == P) {
            return 1;
        }
        // 没有走到终点 没有步数了
        if (K == 0 && M != P) {
            return 0;
        }


        if (M == 0) {
            // 现在来到其实位置只能往右走
            return process(N, K - 1, M + 1, P);
        }

        if (M == N) {
            // 现在来到终点位置只能往左走
            return  process(N, K - 1, M - 1, P);
        }


        return process(N, K - 1, M + 1, P) + process(N, K - 1, M - 1, P);
    }
}
