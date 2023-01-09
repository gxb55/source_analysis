package com.trip.algorithm.leet.some.history;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

/**
 * @author xbguo
 * @date 2022/5/7  22:00
 * @description 433
 * 433. 最小基因变化
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * <p>
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
 * <p>
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * <p>
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * start.length == 8
 * end.length == 8
 * 0 <= bank.length <= 10
 * bank[i].length == 8
 * start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
 */
public class Solution433 {
    public static void main(String[] args) {
        Solution433 solution433 = new Solution433();
      /*  String start = "AACCGGTT", end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};*/
       /* String start = "AACCGGTT", end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};*/
       /* String start = "AAAAACCC", end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"}; */

        String start = "AACCGGTT", end = "AAACGGTA";
        String[] bank = {"AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA"};
        int i = solution433.minMutation(start, end, bank);
        System.out.println(i);
    }

    public int minMutation(String start, String end, String[] bank) {
        Optional<String> any = Arrays.stream(bank).filter(x -> x.equals(end)).findAny();
        if (!any.isPresent()) {
            return -1;
        }
        if (start.equals(end)) {
            return -1;
        }
        Character[] characters = new Character[start.length()];

        Set<String> set = new HashSet<>();

        for (String str : bank) {
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if (characters[i] != null) {
                    if (str.charAt(i) != characters[i]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                set.add(str);
            }
        }
        int index = 0;
        set.add(start);
        alreadySet.add(start);
        int process = process(index, set, start, end);
        return process == Integer.MAX_VALUE ? -1 : process;
    }

    private Set<String> alreadySet = new HashSet<>();

    private int process(int index, Set<String> set, String start, String end) {
        if (start.equals(end)) {
            return index;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < start.length(); i++) {
            String[] strings = getAllStr(start, i);
            for (String s : strings) {
                if (set.contains(s) && !alreadySet.contains(s)) {
                    alreadySet.add(s);
                    int process = process(index + 1, set, s, end);
                    if (process != -1) {
                        result = Math.min(result, process);
                    }
                    alreadySet.remove(s);
                }
            }
        }
        return result;
    }

    private String[] getAllStr(String start, int i) {
        char c = start.charAt(i);
        String b = "";
        String d = "";
        if (i != 0) {
            b = start.substring(0, i);
        }
        if (i != start.length() - 1) {
            d = start.substring(i + 1);
        }
        Character[] characters = {'A', 'C', 'G', 'T'};
        String[] strings = new String[3];
        int index = 0;
        for (int j = 0; j < characters.length; j++) {
            if (characters[j] != c) {
                strings[index++] = b + characters[j] + d;
            }
        }
        return strings;
    }

    public int minMutation1(String start, String end, String[] bank) {
        Set<String> cnt = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        char[] keys = {'A', 'C', 'G', 'T'};
        for (String w : bank) {
            cnt.add(w);
        }
        if (start.equals(end)) {
            return 0;
        }
        if (!cnt.contains(end)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<String>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (keys[k] != curr.charAt(j)) {
                            StringBuffer sb = new StringBuffer(curr);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && cnt.contains(next)) {
                                if (next.equals(end)) {
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
