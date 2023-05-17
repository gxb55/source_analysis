package com.trip.algorithm.leet.some.leet2305;

/**
 * @author xbguo
 * @date 2023/5/17 14:27
 * 输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
 * 输出：true
 * 解释：两个事件在 2:00 出现交集。
 * 示例 2：
 *
 * 输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
 * 输出：true
 * 解释：两个事件的交集从 01:20 开始，到 02:00 结束。
 * 示例 3：
 *
 * 输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/determine-if-two-events-have-conflict
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2446 {
    public static void main(String[] args) {
        Solution2446 solution2446 = new Solution2446();
       // String[] event1 = {"01:15","02:00"}, event2 = {"02:00","03:00"};
        String[] event1 = {"01:00","02:00"}, event2 = {"01:20","03:00"};
        boolean b = solution2446.haveConflict(event1,event2);
        System.out.println(b);
    }
    public boolean haveConflict(String[] event1, String[] event2) {


        Integer begin1=getTime(event1[0]);
        Integer end1=getTime(event1[1]);

        Integer begin2=getTime(event2[0]);
        Integer end2=getTime(event2[1]);
        return (Math.min(end1,end2) -Math.max(begin1,begin2))>=0;
    }

    private Integer getTime(String s) {
        String[] split = s.split(":");
        int a=0;
        if(split[0].startsWith("0")){
            a=a+60*Integer.valueOf(split[0].substring(1,2));
        }else{
            a=a+60*Integer.valueOf(split[0]);
        }

        if(split[1].startsWith("0")){
            a=a+Integer.valueOf(split[1].substring(1,2));
        }else{
            a=a+Integer.valueOf(split[1]);
        }
        return a;
    }
}
