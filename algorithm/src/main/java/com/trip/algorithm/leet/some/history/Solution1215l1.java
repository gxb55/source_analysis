package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo 郭晓兵
 * @date 2020-12-15 19:03
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1215l1 {
    public static void main(String[] args) {
        Solution1215l1 solution1215l1 = new Solution1215l1();
        int i = solution1215l1.monotoneIncreasingDigits2(5486);
        System.out.println(i);
    }

    public int monotoneIncreasingDigits(int N) {

        int temp = 0;
        for(int i=N;i>0;i--){
          List<String>  list = getList(i);
          Boolean flag = checkNum(list);
          if(flag){
              temp = i;
              break;
          }else{
              StringBuilder s = new StringBuilder();
               list.stream().forEach(x->s.append(x));
               i = Integer.parseInt(s.toString());
          }
        }

        return temp;
    }
    public int monotoneIncreasingDigits1(int N) {
        //332
        int ones = 111111111;
        int res = 0;
        for(int i=0;i<9;i++){
            while(res+ones>N){
                ones/=10;
            }
            res =res+ones;
            if(ones==0)
                break;
        }
        return res;
    }
    //392
    public int monotoneIncreasingDigits2(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }


    private Boolean checkNum(List<String> list) {
        boolean flag =true;
        for(int i=0;i<list.size();i++){
            if(i+1<list.size()){
                if(Integer.parseInt(list.get(i)) > Integer.parseInt(list.get(i+1)) ){
                    list.set(i+1,"0");
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private List<String> getList(int i) {
        List<String> list = new ArrayList<>();
        String temp = String.valueOf(i);
        while (true){
            if(temp.length()>1){
                String substring = temp.substring(0, 1);
                list.add(substring);
                temp =temp.substring(1);
            }else {
                break;
            }
        }
        list.add(temp);
        return list;
    }
}
