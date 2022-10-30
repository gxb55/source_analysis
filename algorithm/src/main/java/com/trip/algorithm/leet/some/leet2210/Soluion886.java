package com.trip.algorithm.leet.some.leet2210;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年10月16日 11:47:00
 * 886. 可能的二分法
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * <p>
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 * <p>
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 * <p>
 * <p>
 * 通过次数25,894提交次数51,637
 */
public class Soluion886 {
    public static void main(String[] args) {
        Soluion886 soluion886 = new Soluion886();
       /* int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};*/
        int n = 3;
        int[][] dislikes =  {{1,2},{1,3},{2,3}};

    /*    int n = 5;
        int[][] dislikes =   {{1,2},{2,3},{3,4},{4,5},{1,5}};*/

        /*int n = 10;
        int[][] dislikes = {{5, 6}, {6, 7}, {8, 9}, {7, 8}};*/
        boolean b = soluion886.possibleBipartition1(n, dislikes);
        System.out.println(b);
        b = soluion886.possibleBipartition2(n, dislikes);
        System.out.println(b);
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<int[]>> collect = Arrays.stream(dislikes).sorted(Comparator.comparingInt(x -> x[0])).collect(Collectors.groupingBy(x -> x[0], Collectors.toList()));
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (Map.Entry<Integer, List<int[]>> e : collect.entrySet()) {
            List<Integer> collect1 = e.getValue().stream().map(x -> x[1]).collect(Collectors.toList());
            map.put(e.getKey(), collect1);
        }
        List<Integer> aList = new ArrayList<>();
        List<Integer> aNotList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        List<Integer> bNotList = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> integerList = entry.getValue();
            // 这个值ab都不能放
            if (aNotList.contains(key) && bNotList.contains(key)) {
                return false;
            }
            if (aNotList.contains(key)) {
                // 放入b中
                if (!bList.contains(key)) {
                    bList.add(key);
                    bNotList.addAll(integerList);
                }
                for (int a : integerList) {
                    if (aNotList.contains(a)) {
                        return false;
                    }
                    if (!aList.contains(a)) {
                        aList.add(a);
                        List<Integer> integers = map.get(a);
                        if (integers != null && integers.size() > 0) {
                            aList.addAll(integers);
                        }
                    }
                }
            } else {
                //放入a中
                // 放入b中
                if (!aList.contains(key)) {
                    aList.add(key);
                    aNotList.addAll(integerList);
                }
                for (int a : integerList) {
                    if (bNotList.contains(a)) {
                        return false;
                    }
                    if (!bList.contains(a)) {
                        bList.add(a);
                        List<Integer> integers = map.get(a);
                        if (integers != null && integers.size() > 0) {
                            bNotList.addAll(integers);
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition1(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; ++i) {
            if (color[i] == 0 && !dfs(i, 1, color, g)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int curnode, int nowcolor, int[] color, List<Integer>[] g) {
        color[curnode] = nowcolor;
        for (int nextnode : g[curnode]) {
            if (color[nextnode] != 0 && color[nextnode] == color[curnode]) {
                return false;
            }
            if (color[nextnode] == 0 && !dfs(nextnode, 3 ^ nowcolor, color, g)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 染色法 dfs
     *
     * @param n
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition2(int n, int[][] dislikes) {
        //所有数字最后会是神马颜色
        int[] arr = new int[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] a : dislikes) {
            list.get(a[0]).add(a[1]);
            list.get(a[1]).add(a[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0 && !dfs1(i, 1, list, arr)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs1(int curIndex, int curColor, List<List<Integer>> list, int[] arr) {
        arr[curIndex] = curColor;
        List<Integer> integers = list.get(curIndex);
        for (Integer index : integers) {
            if (arr[curIndex] == arr[index]) {
                return false;
            }
            if (arr[index] == 0 && !dfs1(index, curColor == 1 ? 2 : 1, list, arr)) {
                return false;
            }
        }

        return true;
    }

}
