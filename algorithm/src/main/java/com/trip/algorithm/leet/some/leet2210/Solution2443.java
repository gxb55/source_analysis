package com.trip.algorithm.leet.some.leet2210;

/**
 * @author xbguo
 * @createTime 2022年10月23日 18:03:00
 */
public class Solution2443 {
    public static void main(String[] args) {
        /**
         * 输入：num = 443
         * 输出：true
         * 解释：172 + 271 = 443 ，所以返回 true 。
         * 示例 2：
         *
         * 输入：num = 63
         * 输出：false
         * 解释：63 不能表示为非负整数及其反转后数字之和，返回 false 。
         * 示例 3：
         *
         * 输入：num = 181
         */
        Solution2443 solution2443 = new Solution2443();
        //int val=443;
       int val=63;
       // int val=181;
        boolean b = solution2443.sumOfNumberAndReverse(val);
        System.out.println(b);
    }

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 1; i <= num; i++) {
            int val=i;
            String s = new StringBuffer(i+"").reverse().toString();
            while (s.charAt(0) == '0') {
                s = s.substring(1);
            }
            int resetVal =Integer.valueOf(s);
            if((resetVal+val)==num){
                return true;
            }
        }
        return false;
    }

}
