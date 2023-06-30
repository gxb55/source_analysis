package com.trip.algorithm.leet.some.leet2306;

/**
 * @author xbguo
 * @date 2023/6/25 14:07
 * 输入：radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
 * 输出：true
 * <p>
 * 输入：radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
 * 输出：false
 * 示例 3 ：
 * <p>
 * <p>
 * 输入：radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/circle-and-rectangle-overlapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 1415
 * 807
 * -784
 * -733
 * 623
 * -533
 * 1005
 */
public class Solution1401 {
    public static void main(String[] args) {
        //int radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1;
        //  int radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1;
        // int radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1;
        //  int radius = 2, xCenter = 8, yCenter = 6, x1 = 5, y1 = 1, x2 = 10, y2 = 4;
        int radius = 1415, xCenter = 807, yCenter = -784, x1 = -733, y1 = 623, x2 = -533, y2 = 1005;
        boolean b = checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2);
        System.out.println(b);
    }

    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x = 0;
        int y = 0;
        if (xCenter > x2 || xCenter < x1) {
            x=Math.min(Math.abs(x1-xCenter),Math.abs(x2-xCenter));
        }
        if(yCenter<y1||yCenter>y2){
           y=Math.min(Math.abs(y1-yCenter),Math.abs(y2-yCenter));
        }
        return x*x+y*y<=radius*radius;
    }
}
