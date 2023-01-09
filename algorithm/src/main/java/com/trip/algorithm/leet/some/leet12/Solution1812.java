package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2022/12/8 16:13
 * @description Solution1812
 * 输入：coordinates = "a1"
 * 输出：false
 * 解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
 * 示例 2：
 *
 * 输入：coordinates = "h3"
 * 输出：true
 * 解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
 * 示例 3：
 *
 * 输入：coordinates = "c7"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/determine-color-of-a-chessboard-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1812 {
    public static void main(String[] args) {
        Solution1812 solution1812 = new Solution1812();
        //String coordinates = "a1";
      //  String coordinates = "h3";
        String coordinates = "c7";
        boolean b = solution1812.squareIsWhite(coordinates);
        System.out.println(b);
    }

    public boolean squareIsWhite(String coordinates) {
        char[] chars = coordinates.toCharArray();
        int x = chars[0] - 'a';
        int y = chars[1] - '0';
        boolean flag = x % 2 == 0;
        if (flag) {
            return y % 2 == 0;
        } else {
            return (y + 1)% 2 == 0;
        }
    }
}
