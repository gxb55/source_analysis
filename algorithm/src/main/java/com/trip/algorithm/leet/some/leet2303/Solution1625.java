package com.trip.algorithm.leet.some.leet2303;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2023年03月19日 08:38:00
 * 示例 1：
 * <p>
 * 输入：s = "5525", a = 9, b = 2
 * 输出："2050"
 * 解释：执行操作如下：
 * 初态："5525"
 * 轮转："2555"
 * 累加："2454"
 * 累加："2353"
 * 轮转："5323"
 * 累加："5222"
 * 累加："5121"
 * 轮转："2151"
 * 累加："2050"​​​​​​​​​​​​
 * 无法获得字典序小于 "2050" 的字符串。
 * 示例 2：
 * <p>
 * 输入：s = "74", a = 5, b = 1
 * 输出："24"
 * 解释：执行操作如下：
 * 初态："74"
 * 轮转："47"
 * 累加："42"
 * 轮转："24"​​​​​​​​​​​​
 * 无法获得字典序小于 "24" 的字符串。
 * 示例 3：
 * <p>
 * 输入：s = "0011", a = 4, b = 2
 * 输出："0011"
 * 解释：无法获得字典序小于 "0011" 的字符串。
 * 示例 4：
 * <p>
 * 输入：s = "43987654", a = 7, b = 3
 * 输出："00553311"
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lexicographically-smallest-string-after-applying-operations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1625 {
    public static void main(String[] args) {
        Solution1625 solution1625 = new Solution1625();
       /* String s = "5525";
        int a = 9, b = 2;*/

        /*String s = "74";
        int a = 5, b = 1;*/

        String s = "43987654";
        int a = 7, b = 3;
        String lexSmallestString = solution1625.findLexSmallestString(s, a, b);
        System.out.println(lexSmallestString);
    }

    public String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> set = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        set.add(s);
        queue.add(s);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            String trun = trun(poll, b);
            if (set.add(trun)) {
                queue.add(trun);
            }
            String add = add(poll, a);
            if (set.add(add)) {
                queue.add(add);
            }
        }
        return set.first();
    }

    public String findLexSmallestString1(String s, int a, int b) {
        TreeSet<String> visited = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            char[] ch = cur.toCharArray();
            for(int i = 1; i < ch.length; i += 2) {
                ch[i] = (char)((ch[i] - '0' + a) % 10 + '0');
            }
            String str = new String(ch);
            if(!visited.contains(str)) {
                visited.add(str);
                queue.offer(str);
            }
            String sub1 = cur.substring(0, b);
            String sub2 = cur.substring(b);
            String con = sub2 + sub1;
            if(!visited.contains(con)) {
                visited.add(con);
                queue.offer(con);
            }
        }
        return visited.first();
    }
    private void process(String s, int a, int b, int aCount, int bCount) {
        if (aCount == 0 && bCount == 0) {
            return;
        }
        if (s.compareTo(min) < 0) {
            min = s;
        }
        String s1 = s;
        String trun = trun(s, b);
        while (!trun.equals(s1)) {
            if (trun.compareTo(min) < 0) {
                min = trun;
            }
            trun = trun(trun, b);
        }
        if (aCount > 0) {
            process(add(s, a), a, b, aCount - 1, bCount);
        }
        if (bCount > 0) {
            process(trun(s, b), a, b, aCount, bCount - 1);
        }
    }

    private String trun(String s, int b) {
        String a1 = s.substring(0, s.length() - b);
        String a2 = s.substring(s.length() - b, s.length());
        return a2 + a1;
    }

    private String add(String s, int a) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                stringBuffer.append(s.charAt(i));
            } else {
                int v = s.charAt(i) - '0';
                String s1 = String.valueOf(v + a);
                stringBuffer.append(s1.substring(s1.length() - 1));
            }
        }

        return stringBuffer.toString();
    }

    String min;
}
