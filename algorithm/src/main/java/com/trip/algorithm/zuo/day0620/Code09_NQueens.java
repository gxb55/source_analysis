package com.trip.algorithm.zuo.day0620;

/**
 * @author Administrator
 * 前提知识：位运算
 * ~ 取反，0-》1 1-》0
 * | 或；两个位置都为零的时候才是零
 * & 与：两个位置都为一的时候才是一
 * <p>
 * N 皇后问题
 * N*N的棋格上面排放皇后，任意皇后不能同列，同行，同对角线
 * 1.40
 */
public class Code09_NQueens {
    public static void main(String[] args) {
        int num = 4;
        int res = num(num);
        int res2 = num2(num);
        System.out.println(res);
        System.out.println(res2);

    }

    public static int num(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    /**
     * @param i      尝试到的下标位置
     * @param record 已经存放皇后的位置 下标i表示 行 record【i】表示列
     * @param n      皇后个数，不变，只做最后的递推出口
     * @return
     */
    public static int process(int i, int[] record, int n) {
        //base case 满足的时候说明找到了一种情况
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            // 找到了一个位置可以用来存放皇后，是否满足最后的要求，不一定,满足了0-i位置的
            if (isValid(record, i, j)) {
                //将记录存起来
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }


    /**
     * @param record 已经存放的皇后
     * @param i      行
     * @param j      列
     * @return record[t] == j 在同一列
     * t - i 行上面相差的数量
     * record[t] - j 列上面相差的数量
     * <p>
     * 返回的是i行皇后放在j列是否有效
     */
    private static boolean isValid(int[] record, int i, int j) {
        for (int t = 0; t < i; t++) {
            if (record[t] == j || Math.abs(t - i) == Math.abs(record[t] - j)) {
                return false;
            }
        }
        return true;
    }


    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        /**
         * e << 1 ,左位移1位：
         * limit最后想要的是什么
         * 多少皇后，右边就有多少个1
         * 如果是32 那就刚好是-1
         * 如果是8 那就是 1<<8 1往左移动八位即
         * 1 0000 0001
         * 1<<8 1 0000 0000
         * 1<<8 -1 0 1111 1111
         *
         */
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    /**
     * @param limit       不改动 表示皇后 的个数 比如八皇后就是 1111 1111
     * @param colLim      列的限制 1表示不能放皇后 0表示可以放皇后
     * @param leftDiaLim  左对角线的限制 1表示不能放皇后 0表示可以放皇后
     * @param rightDiaLim 右对角线的限制 1表示不能放皇后 0表示可以放皇后
     * @return
     */
    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        //colLim = 1111 1111 表示满了，这个时候符合要求结果集+1
        if (limit == colLim) {
            return 1;
        }
        /**
         * limit  0000000000.。。 1111 1111 多少个皇后最后就有多少个1
         * colLim         0000 1000
         * leftDiaLim     0001 0000
         * rightDiaLim    0000 0100
         * 这些数前面都是有若干个1，我们的目标是 前端都是零 后八位中，符合要求的变成1 即
         * 0000 0000 ..... 0001 1100
         *  colLim leftDiaLim rightDiaLim 行 左 右 皇后的限制，限制都为1
         *  colLim | leftDiaLim | rightDiaLim 总的限制 前面若干个1 0001 1100
         *  ~(colLim | leftDiaLim | rightDiaLim) 总限制取反 总的限制 前面若干个0 1110 0011
         * limit & (~(colLim | leftDiaLim | rightDiaLim))  000......1110 0011，其中1是符合要求的
         *
         * 假如条件不满足的时候
         * (~(colLim | leftDiaLim | rightDiaLim)) = 0000 0000
         * limit & (~(colLim | leftDiaLim | rightDiaLim)) 结果为0000 0000
         */
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            /**
             * pos 1110 0011
             * ~pos 0001 1100
             * ~pos + 1 0001 1101
             * pos & (~pos+1)
             * 1110 0011
             * 0001 1101
             * 0000 0001即从右到左第一个合适的位置
             */
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit,
                    mostRightOne | colLim,
                    (mostRightOne | leftDiaLim) << 1,
                    (mostRightOne | rightDiaLim) >>> 1);
        }
        return res;
    }
}
