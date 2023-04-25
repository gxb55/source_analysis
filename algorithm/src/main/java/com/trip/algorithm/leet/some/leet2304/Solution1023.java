package com.trip.algorithm.leet.some.leet2304;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/4/14 11:20
 * 示例 1：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * 示例 3：
 * <p>
 * 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输入：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/camelcase-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1023 {
    public static void main(String[] args) {
        Solution1023 solution1023 = new Solution1023();
      /*  String[] q = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB"; */
/*
        String[] q = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBa";*/

        String[] q = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";

        List<Boolean> list = solution1023.camelMatch(q, pattern);
        System.out.println(list);
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int index = 0;
        char[] chars = pattern.toCharArray();
        int count = getCount(pattern);
        List<Boolean> list = new ArrayList<>();
        for (String str : queries) {
            if (getCount(str) != count) {
                list.add(false);
            } else {
                index = 0;
                for (Character character : str.toCharArray()) {
                    if (character == chars[index]) {
                        index++;
                    }
                    if (index >= pattern.length()) {
                        break;
                    }
                }
                if (index >= pattern.length()) {
                    list.add(true);
                } else {
                    list.add(false);
                }
            }
        }
        return list;
    }

    public int getCount(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (Character character : chars) {
            if (character >= 'A' && character <= 'Z') {
                count++;
            }
        }
        return count;
    }
}
