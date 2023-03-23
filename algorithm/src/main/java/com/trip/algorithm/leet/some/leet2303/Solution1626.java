package com.trip.algorithm.leet.some.leet2303;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/3/22 16:19
 * 1626. 无矛盾的最佳球队
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 * <p>
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 * <p>
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：scores = {1,3,5,10,15}, ages = {1,2,3,4,5}
 * 输出：34
 * 解释：你可以选中所有球员。
 * 示例 2：
 * <p>
 * 输入：scores = {4,5,6,5}, ages = {2,1,2,1}
 * 输出：16
 * 解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
 * 示例 3：
 * <p>
 * 输入：scores = {1,2,3,5}, ages = {8,9,10,1}
 * 输出：6
 * 解释：最佳的选择是前 3 名球员。
 */
public class Solution1626 {
    public static void main(String[] args) {
        Solution1626 solution1626 = new Solution1626();
        //  int[] scores = {1,3,5,10,15}, ages = {1,2,3,4,5};
        // int[] scores = {4, 5, 6, 5}, ages = {2, 1, 2, 1};
        //    int[] scores = {1,2,3,5}, ages = {8,9,10,1};

        //2656
        //预期结果：
        //3287
        int[] scores = {596, 277, 897, 622, 500, 299, 34, 536, 797, 32, 264, 948, 645, 537, 83, 589, 770}, ages = {18, 52, 60, 79, 72, 28, 81, 33, 96, 15, 18, 5, 17, 96, 57, 72, 72};

        int i = solution1626.bestTeamScore2(scores, ages);
        int j = solution1626.bestTeamScore1(scores, ages);
        System.out.println(i);
        System.out.println(j);
    }

    public int bestTeamScore1(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int bestTeamScore2(int[] scores, int[] ages) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            list.add(new Person(scores[i], ages[i]));
        }
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.score == o2.score) {
                    return o1.age - o2.age;
                }
                return o1.score - o2.score;
            }
        });
        int[] dp = new int[list.size()];
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            for (int j = i-1; j >=0; j--) {
                if (person.age >= list.get(j).age) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] = dp[i] + person.score;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            list.add(new Person(scores[i], ages[i]));
        }
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age == o2.age) {
                    return o2.score - o1.score;
                }
                return o2.age - o1.age;
            }
        });
        System.out.println(list);
        // 必须以当前结尾
        int[] dp = new int[list.size()];
        // 当前最大值
        int[] dp1 = new int[list.size()];
        dp[0] = list.get(0).score;
        int max = dp[0];
        System.out.println(list.get(0) + "-----" + dp[0]);
        for (int i = 1; i < list.size(); i++) {
            Person person = list.get(i);
            Person lastPerson = list.get(i - 1);
            int cur = 0;
            if (person.age == lastPerson.age) {
                cur = Math.max(cur, dp[i - 1] + person.score);
            } else if (person.score <= lastPerson.score) {
                cur = Math.max(cur, dp[i - 1] + person.score);
            } else {
                boolean flag = true;
                int index = i - 1;
                while (index >= 0) {
                    Person person1 = list.get(index);
                    if (person1.score >= person.score) {
                        cur = Math.max(cur, dp[index] + person.score);
                        flag = false;
                    }
                    index--;
                }
                if (flag) {
                    cur = Math.max(cur, person.score);
                }
            }
            dp[i] = cur;
            dp1[i] = Math.max(cur, dp1[i - 1]);
            max = Math.max(max, dp1[i]);
            System.out.println(person + "-----" + dp[i] + "-----" + dp1[i]);
        }
        return max;
    }

    class Person {
        int score;
        int age;

        public Person(int score, int age) {
            this.score = score;
            this.age = age;
        }

        public Person() {
        }

        @Override
        public String toString() {
            return "Person{" +
                    "score=" + score +
                    ", age=" + age +
                    '}';
        }
    }
}
