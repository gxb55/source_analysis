package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/4/20  14:05
 * @description 388
 */
public class Solution388 {
    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        Solution388 solution388 = new Solution388();
        int i = solution388.lengthLongestPath(input);
        System.out.println(i);
    }

    public int lengthLongestPath(String input) {
        int begin = 0;
        int len = input.length();
        Map<Integer, String> map = new HashMap<>();
        int max = -1;
        while (begin < len) {
            int level = 0;
            int left = begin;
            int right = left;
            while (left < len && input.charAt(right) == '\n') {
                left++;
            }

            while (left < len && input.charAt(left) == '\t') {
                level++;
                left++;
            }
            right = left;
            while (right < len && input.charAt(right) != '\n') {
                right++;
            }
            String substring = input.substring(left, right);
            System.out.println(substring);
            String orDefault = map.getOrDefault(level - 1, null);
            map.put(level, orDefault == null ? substring : orDefault + "/" + substring);
            if (substring.indexOf(".") != -1) {
                max = Math.max(map.get(level).length(), max);
            }
            begin=right+1;
        }
        return max;
    }

    public int lengthLongestPath1(String s) {
        Map<Integer, String> map = new HashMap<>();
        int n = s.length();
        String ans = null;
        for (int i = 0; i < n; ) {
            int level = 0;
            while (i < n && s.charAt(i) == '\t' && ++level >= 0) {
                i++;
            }
            int j = i;
            boolean isDir = true;
            while (j < n && s.charAt(j) != '\n') {
                if (s.charAt(j++) == '.') {
                    isDir = false;
                }
            }
            String cur = s.substring(i, j);
            String prev = map.getOrDefault(level - 1, null);
            String path = prev == null ? cur : prev + "/" + cur;
            if (isDir) {
                map.put(level, path);
            } else if (ans == null || path.length() > ans.length()) {
                ans = path;
            }
            i = j + 1;
        }
        return ans == null ? 0 : ans.length();
    }
}

class Path {
    private List<Path> list;
    private boolean isFile;
}
