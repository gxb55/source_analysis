package com.trip.algorithm.leet.some.Leet2308;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/8/3 15:31
 */
public class Solution722 {
    public static void main(String[] args) {
        Solution722 solution722 = new Solution722();
        //  String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        //  String[] source = {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
        // String[] source = {"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"};
        // String[] source = {"main() {", "/* here is commments", "  // still comments */", "   double s = 33;", "   cout << s;", "}"};
      //  String[] source = {"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"};
        String[] source = {"main() {", "/* here is commments", "  // still comments */", "   double s = 33;", "   cout << s;", "}"};
        //String[] source = {"a/*comment", "line", "more_comment*/b"};
        List<String> list = solution722.removeComments1(source);
        System.out.println(list);

        list = solution722.removeComments(source);
        System.out.println(list);
    }

    public List<String> removeComments1(String[] source) {
        List<String> res = new ArrayList<String>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else {
                        newLine.append(line.charAt(i));
                    }
                }
            }
            if (!inBlock && newLine.length() > 0) {
                res.add(newLine.toString());
                newLine.setLength(0);
            }
        }
        return res;
    }

    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        boolean flag = false;
        int t = 0;
        for (String s : source) {
            if (s.contains("//")) {
                int i = s.indexOf("//");
                String substring = s.substring(0, i);
                if (substring.length() > 0) {
                    list.add(substring);
                }
                continue;
            }
            if (flag) {
                boolean b = s.contains("*/");
                if (b) {
                    flag = false;
                    int i = s.indexOf("*/");
                    if (!s.endsWith("*/") && i != s.length()) {
                        String s1 = s.substring(i + 2);
                        if (t == 1) {
                            String s2 = list.remove(list.size() - 1) + s1;
                            list.add(s2);
                            t = 0;
                        }
                    }
                }
            } else {
                boolean b = s.contains("/*");
                if (b) {
                    int i = s.indexOf("/*");
                    String s1 = "";
                    if (!s.startsWith("/*") && i != 0) {
                        t = 1;
                        s1 = s.substring(0, i);
                    }
                    flag = true;
                    if (s.contains("*/")) {
                        if (!s.endsWith("*/")) {
                            i = s.indexOf("*/");
                            s1 = s1 + s.substring(i + 2);
                        }
                        flag = false;
                        t = 0;
                    }
                    if (s1.length() > 0) {
                        list.add(s1);
                    }

                } else {
                    list.add(s);
                }
            }
        }
        return list;
    }
}
