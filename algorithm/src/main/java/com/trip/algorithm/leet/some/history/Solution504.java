package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/3/7  16:59
 * @description 七进制数
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: num = -7
 * 输出: "-10"
 * <p>
 * <p>
 * 提示：
 * <p>
 * -107 <= num <= 107
 * 通过次数58,671提交次数112,803
 */
public class Solution504 {
    public static void main(String[] args) {
        Solution504 solution504 = new Solution504();
        String s = solution504.convertToBase7(-7);
        System.out.println(s);
    }

    public String convertToBase7(int num) {
        String prefix = "";
        if (num < 0) {
            prefix = "-";
        }
        num = Math.abs(num);
        int[] arr = new int[100];
        if(num<7){
            return prefix+num+"";
        }
        while (num > 0) {
            int temp = num;
            int index = 0;
            while (temp >= 7) {
                temp = temp / 7;
                index++;
            }
            arr[index] = temp;
            num = (int) (num - (temp * Math.pow(7,index)));
        }
        boolean flag = false;
        for (int i = arr.length-1; i >=0; i--) {
            Integer integer = arr[i];
            if (integer > 0) {
                flag = true;
            }
            if (flag) {
                prefix = prefix + integer + "";
            }
        }

        return prefix;
    }
}
