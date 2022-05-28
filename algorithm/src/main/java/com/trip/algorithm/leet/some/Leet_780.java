package com.trip.algorithm.leet.some;


/**
 * @author xbguo
 * @createTime 2022年04月09日 13:39:00
 * <p>
 * 780. 到达终点
 * 给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 false。
 * <p>
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: true
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * 示例 2:
 * <p>
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1
 * 输出: true
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= sx, sy, tx, ty <= 109
 * 通过次数12,239提交次数34,407
 */
public class Leet_780 {
    public static void main(String[] args) {
        Leet_780 leet_780 = new Leet_780();
        // int sx = 35, sy = 13, tx = 455955547, ty = 420098884;
        int sx = 1, sy = 1, tx = 3, ty = 5;
        boolean b = leet_780.reachingPoints1(sx, sy, tx, ty);
        System.out.println(b);
    }

    /**
     * (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
     *
     * @param sx
     * @param sy
     * @param tx
     * @param ty
     * @return
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }
        return process(sx, sy, tx, ty);
    }

    private boolean process(int sx, int sy, int tx, int ty) {
        System.out.println(sx + "----" + sy);
        if (sx == tx && sy == ty) {
            return true;
        }
        if (sx > tx || sy > ty) {
            return false;
        }
        return process(sx, sy + sx, tx, ty) || process(sx + sy, sy, tx, ty);
    }


    public boolean reachingPoints1(int sx, int sy, int tx, int ty) {

       /* while (sx < tx && sy < ty) {
            if (tx < ty) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }
        if (tx < sx || ty < sy) return false;
        return sx == tx ? (ty - sy) % tx == 0 : (tx - sx) % ty == 0;*/


        if (sx == tx && sy == ty) {
            return true;
        }
        while (ty > sy && tx > sx) {
            if (ty > tx) {
                ty = ty % tx;
            } else {
                tx = tx % ty;
            }
        }
        if (tx < sx || ty < sy) {
            return false;
        }
        if (sx == tx && sy == ty) {
            return true;
        }
        if (sx == tx && (ty - sy) % tx == 0) {
            return true;
        }
        if (sy == ty && (tx - sx) % ty == 0) {
            return true;
        }
        return false;
    }

}
