package com.trip.algorithm.leet.some.leet2305;

import com.trip.algorithm.leet.some.codeThink.Solution;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/5/19 09:25
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * 示例 3：
 * <p>
 * 输入："V"
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-tile-possibilities
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1079 {
    public static void main(String[] args) {
        Solution1079 solution1079 = new Solution1079();
        String s = "AAB";
      //  s = "AAABBC";
        int i = solution1079.numTilePossibilities(s);
        System.out.println(i);

    }
    public int numTilePossibilities2(String tiles) {

        boolean[] visited = new boolean[tiles.length()];
        Set<String> set = new HashSet<>();
        dfs(visited, set, tiles, new StringBuilder());
        return set.size() - 1;
    }

    public void dfs(boolean[] visited, Set<String> set, String tiles, StringBuilder sb) {

        set.add(sb.toString());

        for (int i = 0; i < tiles.length(); i++) {

            if (!visited[i]) {
                visited[i] = true;
                sb.append(tiles.charAt(i));
                dfs(visited, set, tiles, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }

        }
    }
    public int numTilePossibilities(String tiles) {
        System.out.println(tiles);
        char[] chars = tiles.toCharArray();
        Set<String> set = new HashSet<>();
        boolean[] vis = new boolean[tiles.length()];
        Arrays.fill(vis, false);
        Arrays.sort(chars);
        process(chars, 0, new StringBuilder(), set, vis);
        System.out.println(set);
        return set.size();
    }

    private void process(char[] chars, int index, StringBuilder sb, Set<String> set, boolean[] vis) {
        if (sb.length()>0) {
            set.add(sb.toString());
        }
        for (int i = 0; i < chars.length ; i++) {
            if(vis[i]){
                continue;
            }

            sb.append(chars[i]);
            vis[i] = true;
            process(chars, i + 1, sb, set, vis);
            sb.setLength(sb.length()-1);
            vis[i] = false;
        }
    }

    public int numTilePossibilities1(String tiles) {
        Map<Character, Integer> count = new HashMap<>();
        for (char t : tiles.toCharArray()) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        Set<Character> tile = new HashSet<>(count.keySet());
        return dfs(tiles.length(), count, tile) - 1;
    }

    private int dfs(int i, Map<Character, Integer> count, Set<Character> tile) {
        if (i == 0) {
            return 1;
        }
        int res = 1;
        for (char t : tile) {
            if (count.get(t) > 0) {
                count.put(t, count.get(t) - 1);
                res += dfs(i - 1, count, tile);
                count.put(t, count.get(t) + 1);
            }
        }
        return res;
    }

}
