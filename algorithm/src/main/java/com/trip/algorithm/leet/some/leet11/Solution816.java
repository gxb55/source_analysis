package com.trip.algorithm.leet.some.leet11;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: xbguo
 * @date: 2022/11/7 11:03
 * 示例 1:
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 示例 2:
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 * 解释:
 * 0.0, 00, 0001 或 00.01 是不被允许的。
 * 示例 3:
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * 示例 4:
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:
 * 1.0 是不被允许的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ambiguous-coordinates
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ["(1,2.3)","(1,23)","(1.2,3)","(12,3)"]
 * 预期结果：
 * ["(1, 2.3)","(1, 23)","(1.2, 3)","(12, 3)"]
 */
public class Solution816 {
    public static void main(String[] args) {
        Solution816 solution816 = new Solution816();
        String s = "(123)";
        s = "(00011)";
        s = "(0123)";
        s = "(123)";
        s = "100";
        List<String> list = solution816.ambiguousCoordinates(s);
        System.out.println(list);
    }


    public List<String> ambiguousCoordinates(String s) {
        s = s.replace("(", "").replace(")", "");
        int length = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<String> list = new ArrayList<>();
            List<String> list1 = new ArrayList<>();
            String substring = s.substring(0, i);
            String substring1 = s.substring(i, length);
            if (substring.length() > 0 && substring1.length() > 0) {
                process(substring, 1, list);
                process(substring1, 1, list1);
            }
            if (substring.matches(match)) {
                list.add(substring);
            }
            if (substring1.matches(match)) {
                list1.add(substring1);
            }
            getRes(res, list1, list);
        }
        return res;
    }
    String match = "([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])|(0)";
    String endMatch = "\\d*[1-9]";
    private void getRes(List<String> res, List<String> list1, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                stringBuilder.setLength(0);
                String s1 = list.get(i);
                String s = list1.get(j);
                stringBuilder.append("(").append(s1).append(", ").append(s).append(")");
                res.add(stringBuilder.toString());
            }
        }
    }

    private void process(String substring, int index, List<String> list) {
        if (index >= substring.length()) {
            return;
        }
        String begin = substring.substring(0, index);
        String end = substring.substring(index);
        String s = new StringBuilder(begin + "." + end).toString();
        boolean matches = s.matches(match);
        if (end.matches(endMatch)&&matches) {
            list.add(s);
        }
        process(substring, index + 1, list);
    }

        public List<String> ambiguousCoordinates1(String s) {
            int n = s.length() - 2;
            List<String> res = new ArrayList<String>();
            s = s.substring(1, s.length() - 1);
            for (int l = 1; l < n; ++l) {
                List<String> lt = getPos(s.substring(0, l));
                if (lt.isEmpty()) {
                    continue;
                }
                List<String> rt = getPos(s.substring(l));
                if (rt.isEmpty()) {
                    continue;
                }
                for (String i : lt) {
                    for (String j : rt) {
                        res.add("(" + i + ", " + j + ")");
                    }
                }
            }
            return res;
        }

        public List<String> getPos(String s) {
            List<String> pos = new ArrayList<String>();
            if (s.charAt(0) != '0' || "0".equals(s)) {
                pos.add(s);
            }
            for (int p = 1; p < s.length(); ++p) {
                if ((p != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0') {
                    continue;
                }
                pos.add(s.substring(0, p) + "." + s.substring(p));
            }
            return pos;
        }

}
