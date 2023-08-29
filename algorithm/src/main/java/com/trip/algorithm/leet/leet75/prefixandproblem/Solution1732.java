package com.trip.algorithm.leet.leet75.prefixandproblem;

/**
 * @author xbguo
 * @createTime 2023年08月27日 16:26:00
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * 示例 2：
 *
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 */
public class Solution1732 {
    public static void main(String[] args) {
        int[] gain = {-4,-3,-2,-1,4,3,2};
        int i = Solution1732.largestAltitude(gain);
        System.out.println(i);
    }
    public static int largestAltitude(int[] gain) {
        int cur=0;
        int max=0;
        // gain[i] 是点 i 和点 i + 1
        for (int x:gain){
            cur=x+cur;
            max=Math.max(cur,max);
        }
        return max;
    }
}
