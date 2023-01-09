package com.trip.algorithm.leet.some.leet11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/11/14 14:47
 * @description Solution401
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * <p>
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 */
public class Solution401 {
    public static void main(String[] args) {
        Solution401 solution401 = new Solution401();
        int x = 2;
        List<String> list = solution401.readBinaryWatch(x);
        System.out.println(list);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        int[] arr1 = new int[8];
        int[] arr2 = new int[8];
        int count = 0;
        int res = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1 << 4; i++) {
            Arrays.fill(arr1, 0);
            Arrays.fill(arr2, 0);
            count = 0;
            for (int j = 0; j < 4; j++) {
                if ((1 & (i >> j)) == 1) {
                    arr1[j] = 1;
                    count++;
                }
            }
            if (count > turnedOn) {
                continue;
            }
            if ((turnedOn - count) == 0) {
                getRes(list, arr1, arr2);
            } else {
                for (int j = 0; j < 1 << 6; j++) {
                    res = turnedOn - count;
                    for (int k = 0; k < 6; k++) {
                        if ((1 & (j >> k)) == 1) {
                            arr2[k] = 1;
                            res--;
                        }
                    }
                    if (res == 0) {
                        getRes(list, arr1, arr2);
                    }
                    Arrays.fill(arr2, 0);
                }
            }
        }
        return list;
    }

    private void getRes(List<String> list, int[] arr1, int[] arr2) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        Arrays.stream(arr1).forEach(x -> stringBuilder.append(x));
        Arrays.stream(arr2).forEach(x -> stringBuilder1.append(x));
        Integer hour = Integer.valueOf(stringBuilder.reverse().toString(), 2);
        Integer minute = Integer.valueOf(stringBuilder1.reverse().toString(), 2);

        if (minute > 60 || hour > 12) {
            return;
        }
        String minuteStr = "";
        if (minute > 9) {
            minuteStr = minute + "";
        } else {
            minuteStr = "0" + minute;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String s = stringBuilder2.append(hour).append(":").append(minuteStr).toString();
        list.add(s);
    }

    public List<String> readBinaryWatch1(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6, m = i & 63; // 用位运算取出高 4 位和低 6 位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }
}
