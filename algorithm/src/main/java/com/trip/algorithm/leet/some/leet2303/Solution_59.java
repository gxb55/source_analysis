package com.trip.algorithm.leet.some.leet2303;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年03月26日 21:07:00
 */
public class Solution_59 {
    public static void main(String[] args) {
        /*MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());*/

        MaxQueue maxQueue = new MaxQueue();
      /*  System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());*/

        String methods = "[\"MaxQueue\",\"max_value\",\"pop_front\",\"max_value\",\"push_back\",\"max_value\",\"pop_front\",\"max_value\",\"pop_front\",\"push_back\",\"pop_front\",\"pop_front\",\"pop_front\",\"push_back\",\"pop_front\",\"max_value\",\"pop_front\",\"max_value\",\"push_back\",\"push_back\",\"max_value\",\"push_back\",\"max_value\",\"max_value\",\"max_value\",\"push_back\",\"pop_front\",\"max_value\",\"push_back\",\"max_value\",\"max_value\",\"max_value\",\"pop_front\",\"push_back\",\"push_back\",\"push_back\",\"push_back\",\"pop_front\",\"pop_front\",\"max_value\",\"pop_front\",\"pop_front\",\"max_value\",\"push_back\",\"push_back\",\"pop_front\",\"push_back\",\"push_back\",\"push_back\",\"push_back\",\"pop_front\",\"max_value\",\"push_back\",\"max_value\",\"max_value\",\"pop_front\",\"max_value\",\"max_value\",\"max_value\",\"push_back\",\"pop_front\",\"push_back\",\"pop_front\",\"max_value\",\"max_value\",\"max_value\",\"push_back\",\"pop_front\",\"push_back\",\"push_back\",\"push_back\",\"pop_front\",\"max_value\",\"pop_front\",\"max_value\",\"max_value\",\"max_value\",\"pop_front\",\"push_back\",\"pop_front\",\"push_back\",\"push_back\",\"pop_front\",\"push_back\",\"pop_front\",\"push_back\",\"pop_front\",\"pop_front\",\"push_back\",\"pop_front\",\"pop_front\",\"pop_front\",\"push_back\",\"push_back\",\"max_value\",\"push_back\",\"pop_front\",\"push_back\",\"push_back\",\"pop_front\"]";
        List<String> list = JSON.parseArray(methods, String.class);
        String params = "[[],[],[],[],[46],[],[],[],[],[868],[],[],[],[525],[],[],[],[],[123],[646],[],[229],[],[],[],[871],[],[],[285],[],[],[],[],[45],[140],[837],[545],[],[],[],[],[],[],[561],[237],[],[633],[98],[806],[717],[],[],[186],[],[],[],[],[],[],[268],[],[29],[],[],[],[],[866],[],[239],[3],[850],[],[],[],[],[],[],[],[310],[],[674],[770],[],[525],[],[425],[],[],[720],[],[],[],[373],[411],[],[831],[],[765],[701],[]]";
        List<String> list1 = JSON.parseArray(params, String.class);
        System.out.println(list);
        System.out.println(list1);
        for (int i = 0; i < list1.size(); i++) {
            String s = list.get(i);
            if (s.equals("MaxQueue")) {

            } else if (s.equals("max_value")) {
                System.out.println(maxQueue.max_value()+"_"+i);
            } else if (s.equals("pop_front")) {
                System.out.println(maxQueue.pop_front()+"_"+i);
            } else if (s.equals("push_back")) {
                int i1 = Integer.parseInt(list1.get(i).substring(1, list1.get(i).length() - 1));
                maxQueue.push_back(i1);
            }
        }
    }
}

class MaxQueue {
    LinkedList<int[]> list;
    LinkedList<Integer> linkedList;
    int count;

    public MaxQueue() {
        count = 0;
        list = new LinkedList<>();
        linkedList = new LinkedList<>();
    }

    public int max_value() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.peekFirst()[0];
    }

    public void push_back(int value) {
        if (list.isEmpty()) {
            list.addLast(new int[]{value, 1});
        } else {
            if (value > list.peekFirst()[0]) {
                list.clear();
                list.addLast(new int[]{value, count + 1});
            } else if (value < list.peekLast()[0]) {
                list.addLast(new int[]{value, 1});
            } else {
                int sum = 1;
                while (value > list.peekLast()[0]) {
                    sum = sum + list.pollLast()[1];
                }
                list.addLast(new int[]{value, sum});
            }
        }
        count++;
        linkedList.add(value);
        check();
    }

    private void check() {
        int cur=0;
        for (int[] a:list){
            cur=cur+a[1];
        }
        if(cur!=linkedList.size()){
            System.out.println("errot");
        }

    }

    public int pop_front() {
        if (linkedList.isEmpty()) {
            return -1;
        }
        check();
        count--;
        if (list.peekFirst()[1] == 1) {
            list.pollFirst();
        } else {
            list.peekFirst()[1]--;
        }
        return linkedList.pollFirst();
    }
}