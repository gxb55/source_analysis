package com.trip.algorithm.leet.some;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年04月23日 17:36:00
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 * 通过次数198,520提交次数368,471
 */
public class Leet_207 {
    public static void main(String[] args) {
        Leet_207 leet_207 = new Leet_207();
        // int[][] arr = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        //int[][] arr = {{1, 0}, {1, 2}, {0, 1}};
        int[][] arr = {{0, 1}};
        boolean b = leet_207.canFinish(2, arr);
        System.out.println(b);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 下标代表课程i arr【i】 代表他的入度是多少
        int[] arr = new int[numCourses];
        //list.get(x) 代表x指向的课程有哪些，即x是他的先决课程
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            arr[p[0]]++;
            list.get(p[1]).add(p[0]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                queue.add(i);
            }
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            sum++;
            Integer integer = queue.pollLast();
            List<Integer> list1 = list.get(integer);
            for (int i : list1) {
                arr[i]--;
                if (arr[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return sum == numCourses;
    }
}
