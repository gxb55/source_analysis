package com.trip.algorithm.leet.some.leet2302;

import java.util.*;

/**
 * @author xbguo
 * @date 2023/2/2 16:28
 * 1129. 颜色交替的最短路径
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
 * <p>
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 * <p>
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 示例 2：
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * 示例 3：
 * <p>
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * 示例 4：
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * 示例 5：
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 * 通过次数18,481提交次数40,121
 */
public class Solution1129 {
    public static void main(String[] args) {
        Solution1129 solution1129 = new Solution1129();
      /*  int n = 3;
        int[][] red_edges = {{0, 1}, {1, 2}};
        int[][] blue_edges = {}; */

     /*   int n = 3;
        int[][] red_edges = {{0, 1}};
        int[][] blue_edges = {{2, 1}};*/

     /*   int n = 3;
        int[][] red_edges = {{0,1},{0,2}};
        int[][] blue_edges = {{1,0}};  */
/*

        int n = 3;
        int[][] red_edges = {{0,1}};
        int[][] blue_edges = {{1,2}};
*/


       /* int n = 5;
        int[][] red_edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] blue_edges = {{1, 2}, {2, 3}, {3, 1}};*/
       /* int n = 4;
        int[][] red_edges = {{0, 3}, {1, 2}};
        int[][] blue_edges = {{0, 1}, {2, 3}};*/

      /*  int n = 4;
        int[][] red_edges = {{0, 3}, {1, 2}};
        int[][] blue_edges = {{0, 1}, {0, 2}};*/

        int n = 100;
        int[][] red_edges = {{23, 30}, {63, 11}, {92, 53}, {53, 51}, {74, 47}, {19, 13}, {25, 67}, {22, 62}, {15, 57}, {61, 7}, {84, 11}, {54, 1}, {1, 67}, {28, 12}, {93, 3}, {57, 78}, {43, 17}, {21, 12}, {48, 30}, {81, 19}, {76, 11}, {64, 61}, {37, 3}, {65, 54}, {81, 73}, {39, 4}, {29, 64}, {72, 59}, {37, 49}, {22, 19}, {52, 66}, {34, 85}, {62, 29}, {19, 68}, {43, 74}, {93, 50}, {91, 22}, {2, 69}, {6, 9}, {27, 44}, {19, 41}, {21, 99}, {18, 96}, {42, 26}, {88, 38}, {54, 2}, {31, 60}, {92, 1}, {12, 49}, {43, 58}, {31, 37}, {89, 83}, {15, 42}, {98, 15}, {96, 26}, {63, 20}, {54, 47}, {12, 94}, {10, 7}, {16, 6}, {14, 17}, {97, 6}, {6, 28}, {84, 33}, {17, 83}, {76, 0}, {29, 14}, {53, 24}, {61, 41}, {66, 10}, {2, 37}, {72, 81}, {85, 47}, {29, 36}, {94, 24}, {17, 42}, {53, 80}, {1, 38}, {56, 49}, {13, 96}, {64, 9}, {37, 31}, {45, 31}, {35, 12}, {91, 80}, {0, 39}, {38, 41}, {34, 18}, {36, 8}, {12, 86}, {9, 83}, {17, 18}, {31, 16}, {64, 81}, {17, 17}, {65, 75}, {32, 93}, {40, 6}, {8, 28}, {57, 84}, {24, 87}, {33, 75}, {86, 38}, {34, 33}, {79, 40}, {60, 35}, {99, 79}, {72, 9}};
        int[][] blue_edges = {{5, 78}, {33, 51}, {92, 13}, {32, 15}, {73, 8}, {40, 41}, {71, 16}, {86, 47}, {33, 94}, {57, 44}, {68, 9}, {89, 52}, {13, 97}, {40, 15}, {61, 79}, {51, 2}, {77, 86}, {66, 24}, {54, 12}, {42, 92}, {29, 44}, {11, 55}, {98, 35}, {63, 59}, {79, 95}, {33, 90}, {63, 85}, {78, 10}, {14, 7}, {8, 36}, {54, 41}, {95, 74}, {67, 72}, {83, 87}, {77, 81}, {66, 43}, {59, 58}, {34, 19}, {46, 34}, {24, 3}, {50, 0}, {47, 83}, {37, 87}, {92, 92}, {0, 94}, {25, 2}, {72, 97}, {79, 24}, {16, 15}, {31, 33}, {4, 46}, {65, 63}, {76, 18}, {64, 89}, {11, 85}, {68, 62}, {26, 91}, {47, 75}, {17, 43}, {70, 22}, {53, 98}, {55, 39}, {53, 48}, {45, 51}, {51, 24}, {79, 50}, {82, 73}, {27, 26}, {76, 11}, {1, 50}, {59, 63}, {42, 78}, {60, 35}, {47, 51}, {76, 72}, {96, 35}, {97, 12}, {87, 6}, {33, 40}, {15, 35}, {46, 37}, {57, 59}, {89, 48}, {3, 27}, {4, 61}, {34, 40}, {60, 61}, {32, 43}, {40, 12}, {60, 23}, {90, 64}, {81, 75}, {36, 61}, {47, 73}, {89, 29}, {34, 78}, {45, 74}, {75, 13}, {86, 76}, {13, 93}, {94, 56}, {93, 91}, {53, 19}, {95, 6}, {20, 12}, {2, 45}, {49, 33}, {20, 78}, {50, 56}, {79, 14}, {85, 32}, {65, 45}, {0, 48}, {81, 82}, {61, 87}, {50, 15}, {43, 70}, {86, 38}, {62, 2}, {89, 97}, {17, 14}, {52, 2}, {46, 87}, {0, 16}, {16, 54}, {86, 5}, {2, 69}, {80, 77}, {37, 3}, {89, 59}, {45, 32}, {47, 17}, {19, 29}, {69, 81}, {12, 28}, {52, 73}, {88, 1}, {10, 92}, {1, 80}, {21, 57}, {11, 74}, {19, 25}, {11, 15}, {25, 29}, {44, 88}, {86, 13}, {60, 22}, {97, 55}, {3, 95}, {73, 51}, {85, 56}, {58, 97}, {78, 16}, {42, 84}, {26, 98}, {46, 10}, {28, 18}, {14, 12}, {76, 26}, {79, 12}, {58, 40}, {72, 89}, {5, 81}, {41, 65}, {46, 28}, {18, 25}, {65, 5}, {0, 85}, {10, 65}, {28, 56}, {39, 49}, {22, 17}, {30, 26}, {53, 6}, {12, 12}, {16, 16}, {70, 52}, {96, 55}, {37, 10}, {72, 15}, {80, 84}, {50, 60}, {58, 1}, {76, 74}, {96, 45}, {42, 77}, {15, 22}, {99, 19}, {86, 48}, {98, 11}, {50, 4}, {71, 44}, {49, 10}, {4, 31}, {67, 52}, {52, 94}, {35, 75}, {83, 63}, {7, 7}, {99, 38}, {71, 67}, {18, 84}, {80, 46}, {80, 15}, {18, 86}, {10, 75}, {81, 93}, {67, 31}, {72, 69}, {18, 24}, {57, 42}, {93, 8}, {93, 58}};


        /*
[0,1,-1]
        预期结果：
[0,1,2]
*/

        int[] ints = solution1129.shortestAlternatingPaths2(n, red_edges, blue_edges);
        System.out.println(Arrays.toString(ints));

        ints = solution1129.shortestAlternatingPaths1(n, red_edges, blue_edges);
        System.out.println(Arrays.toString(ints));
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] arr : redEdges) {
            int x = arr[0];
            int y = arr[1];
            if (redMap.containsKey(x)) {
                redMap.get(x).add(y);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                redMap.put(x, list);
            }
        }
        for (int[] arr : blueEdges) {
            int x = arr[0];
            int y = arr[1];
            if (blueMap.containsKey(x)) {
                blueMap.get(x).add(y);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                blueMap.put(x, list);
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            count = Integer.MAX_VALUE;
            getRes(redMap, blueMap, 0, i, true, 0, 0);
            getRes(redMap, blueMap, 0, i, false, 0, 0);
            res[i] = count == Integer.MAX_VALUE ? -1 : count;
        }
        return res;
    }

    int count = Integer.MAX_VALUE;
    Set<String> set = new HashSet<>();

    private void getRes(Map<Integer, List<Integer>> redMap, Map<Integer, List<Integer>> blueMap, int begin, int end, boolean flag, int len, int index) {
        if (begin == end) {
            count = Math.min(count, len);
            return;
        }
        List<Integer> list;
        if (flag) {
            list = redMap.get(begin);
        } else {
            list = blueMap.get(begin);
        }
        if (list == null) {
            return;
        }
        for (int i = index; i < list.size(); i++) {
            Integer integer = list.get(i);
            String s = begin + "" + integer + (flag ? "red" : "blue");
            if (set.contains(s)) {
                continue;
            }
            set.add(s);
            getRes(redMap, blueMap, integer, end, !flag, len + 1, index);
            set.remove(s);
        }
    }

    /**
     * 对于某一个队列元素，节点编号为 xx，节点路径类型为 tt
     */

    public int[] shortestAlternatingPaths1(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] next = new List[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = new ArrayList<Integer>();
            }
        }
        for (int[] edge : redEdges) {
            next[0][edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            next[1][edge[0]].add(edge[1]);
        }
        int[][] dist = new int[2][n]; // 两种类型的颜色最短路径的长度
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();
        dist[0][0] = 0;
        dist[1][0] = 0;
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            //对于某一个队列元素，节点编号为 x，节点路径类型为 t
            int x = pair[0], t = pair[1];
            for (int y : next[1 - t][x]) {
                if (dist[1 - t][y] != Integer.MAX_VALUE) {
                    continue;
                }
                dist[1 - t][y] = dist[t][x] + 1;
                queue.offer(new int[]{y, 1 - t});
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }


    public int[] shortestAlternatingPaths2(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res = new int[n];
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] arr : redEdges) {
            int x = arr[0];
            int y = arr[1];
            if (redMap.containsKey(x)) {
                redMap.get(x).add(y);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                redMap.put(x, list);
            }
        }
        for (int[] arr : blueEdges) {
            int x = arr[0];
            int y = arr[1];
            if (blueMap.containsKey(x)) {
                blueMap.get(x).add(y);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                blueMap.put(x, list);
            }
        }
        int[][] dist = new int[2][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        //0 red; 1 blue; j 位置
        dist[0][0] = 0;
        dist[1][0] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        queue.add(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int color = poll[0];
            int num = poll[1];
            if (color == 0) {
                List<Integer> list = blueMap.get(num);
                if (list == null) {
                    continue;
                }
                for (int x : list) {
                    if (dist[1][x] != Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[1][x] = dist[color][num] + 1;
                    queue.add(new int[]{1, x});
                }
            } else {
                List<Integer> list = redMap.get(num);
                if (list == null) {
                    continue;
                }
                for (int x : list) {
                    if (dist[0][x] != Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[0][x] = dist[color][num] + 1;
                    queue.add(new int[]{0, x});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int val = Math.min(dist[0][i], dist[1][i]);
            res[i] = (val == Integer.MAX_VALUE ? -1 : val);
        }
        return res;
    }
}