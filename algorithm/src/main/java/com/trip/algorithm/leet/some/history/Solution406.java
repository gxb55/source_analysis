package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/4/22  16:46
 * @description 406
 * <p>
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 * 示例 2：
 * <p>
 * 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * 输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= people.length <= 2000
 * 0 <= hi <= 106
 * 0 <= ki < people.length
 * 题目数据确保队列可以被重建
 * 通过次数158,830提交次数212,418
 */
public class Solution406 {
    public static void main(String[] args) {
        Solution406 solution406 = new Solution406();
        int[][] arr = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = solution406.reconstructQueue(arr);

    }

    public int[][] reconstructQueue(int[][] people) {
        List<Person> list = new ArrayList<>();
        for (int[] arr : people) {
            list.add(new Person(arr[0], arr[1]));
        }
        int[][] result = new int[people.length][2];
        List<Person> list1 = new ArrayList<>();
        List<Person> collect = list.stream().sorted((x, y) -> {
            if (x.high == y.high) {
                return x.index - y.index;
            } else {
                return y.high - x.high;
            }
        }).collect(Collectors.toList());

        for (Person person : collect) {
            if (person.index == 0) {
                list1.add(0, person);
            } else {
                int index = person.index;
                int i = 0;
                for (; i < list1.size(); i++) {
                    Person person1 = list1.get(i);
                    if (person1.high >= person.high) {
                        index--;
                    }
                    if (index == 0) {
                        break;
                    }
                }
                if ((i + 1) >= list1.size()) {
                    list1.add(person);
                } else {
                    list1.add(i + 1, person);
                }

            }
        }
        System.out.println(list1);
        for (int i = 0; i <list1.size(); i++) {
            result[i][0]=list1.get(i).high;
            result[i][1]=list1.get(i).index;
        }
        return result;
    }
}

class Person {
    public int high;
    public int index;

    public Person() {
    }

    public Person(int high, int index) {
        this.high = high;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Person{" +
                "high=" + high +
                ", index=" + index +
                '}';
    }
}
