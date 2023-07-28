package com.trip.algorithm.leet.some.leet2307;

/**
 * @author xbguo
 * @date 2023/7/12 17:27
 * 输入：n = 521
 * 输出：4
 * 解释：(+5) + (-2) + (+1) = 4
 * 示例 2：
 *
 * 输入：n = 111
 * 输出：1
 * 解释：(+1) + (-1) + (+1) = 1
 * 示例 3：
 *
 * 输入：n = 886996
 * 输出：0
 * 解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/alternating-digit-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2544 {
    public static void main(String[] args) {
        int n=886996;
        int i = alternateDigitSum(n);
        System.out.println(i);
    }
    public static int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int res=0;
        boolean flag =true;
        for (int i = 0; i < chars.length; i++) {
            int cur=chars[i]-'0';
            if(flag){
                res+=cur;
            }else{
                res-=cur;
            }
            flag=!flag;
        }
        return res;
    }
}
