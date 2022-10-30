package com.trip.algorithm.leet.some.history;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2022年04月23日 22:39:00
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 * <p>
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 * <p>
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 * 通过次数122,201提交次数220,549
 */
public class Leet_210 {
    public static void main(String[] args) {
        Leet_210 leet_210 = new Leet_210();
       /* int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};*/
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}};
        int[] order = leet_210.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || prerequisites == null) {
            int[] resultArr = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                resultArr[i] = i;
            }
            return resultArr;
        }
        int[] arr = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            arr[p[0]]++;
            list.get(p[1]).add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            // 这个节点的入度为零，可以先行学习
            if (arr[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result.add(poll);

            List<Integer> list1 = list.get(poll);
            for (int i = 0; i < list1.size(); i++) {
                arr[list1.get(i)]--;
                if (arr[list1.get(i)] == 0) {
                    queue.add(list1.get(i));
                }
            }
        }
        if (result.size() == numCourses) {
            int[] resultArr = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                resultArr[i] = result.get(i);
            }
            return resultArr;
        } else {
            return new int[]{};
        }


    }
}
