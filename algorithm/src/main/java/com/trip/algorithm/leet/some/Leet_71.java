package com.trip.algorithm.leet.some;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年04月10日 21:42:00
 * 71. 简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * <p>
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * <p>
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 * <p>
 * 输入：path = "/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 * 示例 3：
 * <p>
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 * <p>
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= path.length <= 3000
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * path 是一个有效的 Unix 风格绝对路径。
 * 通过次数141,082提交次数319,138
 */
public class Leet_71 {
    public static void main(String[] args) {
        Leet_71 leet_71 = new Leet_71();
        String str = "/a//b////c/d//././/..";
        String s = leet_71.simplifyPath("/../");
        System.out.println(s);
    }

    public String simplifyPath(String path) {
        List<Integer> list = new LinkedList<>();
        int i = path.indexOf("/", 0);
        while (i != -1) {
            list.add(i);
            i = path.indexOf("/", i + 1);
        }
        List<String> list1 = new ArrayList<>();
        for (int j = 0; j < list.size() - 1; j++) {
            list1.add(path.substring(list.get(j), list.get(j + 1)));
        }
        list1.add(path.substring(list.get(list.size() - 1)));

        List<String> result = new LinkedList<>();
        for (String str : list1) {
            if (str.equals("/")) {
                continue;
            } else if (str.equals("/.")) {
                continue;
            } else if (str.equals("/..")) {
                if(result.size()>0){
                    result.remove(result.size() - 1);
                }
            } else {
                result.add(str);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : result) {
            stringBuilder.append(s);
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

}
