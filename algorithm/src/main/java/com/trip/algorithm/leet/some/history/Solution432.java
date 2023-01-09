package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author xbguo
 * @date 2022/3/16  15:43
 * 432. 全 O(1) 的数据结构
 * 请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。
 * <p>
 * 实现 AllOne 类：
 * <p>
 * AllOne() 初始化数据结构的对象。
 * inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。
 * dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中。
 * getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
 * [[], ["hello"], ["hello"], [], [], ["leet"], [], []]
 * 输出
 * [null, null, null, "hello", "hello", null, "hello", "leet"]
 * <p>
 * 解释
 * AllOne allOne = new AllOne();
 * allOne.inc("hello");
 * allOne.inc("hello");
 * allOne.getMaxKey(); // 返回 "hello"
 * allOne.getMinKey(); // 返回 "hello"
 * allOne.inc("leet");
 * allOne.getMaxKey(); // 返回 "hello"
 * allOne.getMinKey(); // 返回 "leet"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= key.length <= 10
 * key 由小写英文字母组成
 * 测试用例保证：在每次调用 dec 时，数据结构中总存在 key
 * 最多调用 inc、dec、getMaxKey 和 getMinKey 方法 5 * 104 次
 * 通过次数15,955提交次数36,096
 */
public class Solution432 {
    public static void main(String[] args) {
        /**
         *
         * ["AllOne","inc","inc","getMaxKey","getMinKey","inc","getMaxKey","getMinKey"]
         * [[],["hello"],["hello"],[],[],["leet"],[],[]]
         *
         * ["AllOne","inc","inc","inc","inc","inc","dec","dec","getMaxKey","getMinKey"]
         * [[],     ["a"],["b"],["b"],["b"],["b"],["b"],["b"],[],[]]
         *
         * ["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
         * [[],     ["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"], [],["a"],[],[]]
         */
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMinKey());
        allOne.dec("a");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());

    }
}

class AllOne {
    private Map<String, Integer> map;
    private TreeMap<Integer, Set<String>> treeMap;

    public AllOne() {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
    }

    public void inc(String key) {
        Integer count = map.getOrDefault(key, 0);
        map.put(key, count + 1);
        if (count >= 1) {
            if (treeMap.get(count).size() == 1) {
                treeMap.remove(count);
            } else {
                treeMap.get(count).remove(key);
            }
        }
        Set<String> orDefault = treeMap.getOrDefault(count + 1, new TreeSet<>());
        orDefault.add(key);
        treeMap.put(count + 1, orDefault);
    }

    public void dec(String key) {
        Integer integer = map.get(key);
        if ((integer - 1) == 0) {
            map.remove(key);
        } else {
            map.put(key, integer - 1);
        }

        if (treeMap.get(integer).size() == 1) {
            treeMap.remove(integer);
        } else {
            treeMap.get(integer).remove(key);
        }
        if((integer - 1)!=0){
            Set<String> orDefault = treeMap.getOrDefault(integer - 1, new TreeSet<>());
            orDefault.add(key);
            treeMap.put(integer - 1, orDefault);
        }
    }

    public String getMaxKey() {
        if (map == null || map.size() == 0) {
            return "";
        }
        Integer integer = treeMap.lastKey();
        Set<String> strings = treeMap.get(integer);
        for (String s : strings) {
            return s;
        }
        return null;
    }

    public String getMinKey() {
        if (map == null || map.size() == 0) {
            return "";
        }
        Integer integer = treeMap.firstKey();
        Set<String> strings = treeMap.get(integer);
        for (String s : strings) {
            return s;
        }
        return null;
    }
}