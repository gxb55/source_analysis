package com.trip.algorithm.leet.l24.l08;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/8/28 15:04
 */
public class Solution690 {
    public static void main(String[] args) {

    }

    /**
     * employees[i].id 是第 i 个员工的 ID。
     * employees[i].importance 是第 i 个员工的重要度。
     * employees[i].subordinates 是第 i 名员工的直接下属的 ID 列表
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> collect = employees.stream().collect(Collectors.toMap(x -> x.id, x -> x, (x, y) -> x));

        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(id);
        while (!list.isEmpty()) {
            int size = list.size();
            while (size > 0) {
                size--;
                Integer integer = list.pollFirst();
                Employee employee = collect.get(integer);
                for (Integer subordinate : employee.subordinates) {
                    list.addLast(subordinate);
                }
                count += employee.importance;
            }
        }
        return count;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};