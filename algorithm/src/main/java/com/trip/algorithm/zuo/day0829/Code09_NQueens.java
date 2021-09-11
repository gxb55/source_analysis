package com.trip.algorithm.zuo.day0829;

/**
 * N皇后问题
 * n*n的棋格，其中任意皇后不能同行同列同对角线
 * <p>
 * 4 2
 * 13 73712
 */
public class Code09_NQueens {
    public static void main(String[] args) {
        int res = num1(4);
        int res1 = num2(4);
        System.out.println(res);
        System.out.println(res1);
    }

    public static int num1(int n) {
        if (n <= 0 || n >= 32) {
            return 0;
        }
        int[] arr = new int[n];
        return process(arr, 0, n);
    }

    /**
     * @param arr 数字 下标就是行 对应的值是列
     * @param n   当前到第几个皇后了
     * @param sum 皇后总个数
     * @return
     */
    public static int process(int[] arr, int n, int sum) {
        if (n == sum) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < sum; i++) {
            if (isValid(arr, n, i)) {
                arr[n] = i;
                res += process(arr, n + 1, sum);
            }
        }
        return res;
    }

    /**
     * @param arr 数组
     * @param i   k 行
     * @param j   arr[k] 列
     * @return
     */
    private static boolean isValid(int[] arr, int i, int j) {
        for (int k = 0; k < i; k++) {

            if (j == arr[k] || Math.abs(k - i) == Math.abs(arr[k] - j)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 位运算加快整体速度
     *
     * @param n
     * @return
     */
    public static int num2(int n) {
        if (n <= 0 || n >= 32) {
            return 0;
        }
        /**
         * 假如是8皇后
         * 1-》000 ... 0000 0001
         * 1<<8 000... 1 0000 0000
         * 1<<8 -1 000... 0 1111 1111
         * 刚开始列限制，左斜线 右斜线限制都是0
         */
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process1(limit, 0, 0, 0);
    }

    /**
     * @param limit       原数
     * @param colLim      列限制
     * @param leftDialLim 左斜线限制
     * @param rightDiaLim 右斜线限制
     * @return
     */
    private static int process1(int limit, int colLim, int leftDialLim, int rightDiaLim) {
        // 如果原数跟 列限制一样即前面很多零 后面8个1则说明是一种合理的情况
        if (limit == colLim) {
            return 1;
        }
        /**
         * 假如
         * limit 1111 1111
         * colLim 0000 1000
         * leftDialLim 0001 0000
         * rightDiaLim  0000 0100
         * colLim | leftDialLim | rightDiaLim  0001 1100
         * ~(colLim | leftDialLim | rightDiaLim) 1110 0011
         * limit & (~(colLim | leftDialLim | rightDiaLim)
         * 1111 1111
         *    &
         * 1110 0011
         * 1110 0011
         * 是1的地方是可以放元素的，并且把这几位前面的那些数都剔除掉了
         */
        int pos = limit & (~(colLim | leftDialLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        // pos!=0 说明这个位置可以放皇后
        while (pos != 0) {
            //最右边可以放皇后的第一个位置
            mostRightOne = pos & (~pos + 1);
            // 除了最右边的，即最右边的被站位了，则剩下的可以有多少情况
            pos = pos - mostRightOne;
            res += process1(limit, (colLim | mostRightOne),
                     (mostRightOne | leftDialLim)<<1,
                    (mostRightOne | rightDiaLim) >>> 1);
        }
        return res;
    }
}
