package com.trip.algorithm.leet.some.leet2303;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年03月04日 18:18:00
 */
public class Solution146 {
    public static void main(String[] args) {
       /* LRUCache1 cache = new LRUCache1(2);
        cache.put(1, 1);
        cache.put(2, 1);
        cache.put(3, 1);
        int i = cache.get(1);
        System.out.println(i);*/

       /* LRUCache1 cache = new LRUCache1(1);
        cache.put(2, 1);
        int i = cache.get(2);
        System.out.println(i); */

      /*  LRUCache1 cache = new LRUCache1(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));*/

/*["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]*/

        LRUCache1 cache = new LRUCache1(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));


    }
}

class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int cap = 0;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > cap;
            }
        };
    }

    public int get(int key) {
        Integer integer = map.get(key);
        if (integer == null) {
            integer = -1;
        }
        return integer;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

}

class LRUCache1 {
    Map<Integer, LruNode<Integer, Integer>> map;
    LruNode<Integer, Integer> head;
    LruNode<Integer, Integer> tail;
    int cap;
    int cur;

    public LRUCache1(int capacity) {
        map = new HashMap<>(capacity);
        head = new LruNode<>(-1, -1);
        tail = new LruNode<>(-1, -1);

        head.next = tail;
        tail.pre = head;
        cap = capacity;
        cur = 0;
    }

    public int get(int key) {
        LruNode<Integer, Integer> integerLruNode = map.get(key);
        if (integerLruNode == null) {
            return -1;
        }
        moveToHead(integerLruNode);
        return integerLruNode.t;
    }

    public void put(int key, int value) {
        LruNode<Integer, Integer> integerIntegerLruNode = map.get(key);
        if (integerIntegerLruNode == null) {
            LruNode<Integer, Integer> integerIntegerLruNode1 = new LruNode<>(value, key);
            addToHead(integerIntegerLruNode1);
            cur++;
            map.put(key, integerIntegerLruNode1);
            if (cur > cap) {
                LruNode lruNode = removeTail();
                map.remove(lruNode.k);
                cur--;
            }

        } else {
            integerIntegerLruNode.t = value;
            moveToHead(integerIntegerLruNode);
        }
    }


    private void addToHead(LruNode node) {
        LruNode<Integer, Integer> next = head.next;
        head.next = node;
        node.pre = head;

        node.next = next;
        next.pre = node;
    }

    private void removeNode(LruNode node) {
        LruNode pre = node.pre;
        LruNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(LruNode node) {
        removeNode(node);
        addToHead(node);
    }

    private LruNode removeTail() {
        LruNode<Integer, Integer> pre = tail.pre;
        LruNode<Integer, Integer> pre1 = pre.pre;
        pre1.next = tail;
        tail.pre = pre1;
        return pre;
    }

    class LruNode<K, T> {
        public T t;
        public K k;
        public LruNode<K, T> pre;
        public LruNode<K, T> next;

        public LruNode(T t, K k) {
            this.t = t;
            this.k = k;
        }
    }
}

