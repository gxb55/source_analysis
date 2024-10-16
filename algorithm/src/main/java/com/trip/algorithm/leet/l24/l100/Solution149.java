package com.trip.algorithm.leet.l24.l100;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/10/15 19:26
 * @description TODO
 */
public class Solution149 {
    public static void main(String[] args) {
        LRUCache lruCache =new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        int i = lruCache.get(2);
        System.out.println(i);

        int count=5;
        LinkedHashMap<Integer, Integer> integerIntegerLinkedHashMap = new LinkedHashMap<>(){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()>=count;
            }
        };


    }
}

class LRUCache {
    int capacity;
    Node head;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.head.k=-1;
        this.head.v=-1;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }else {
            remove(node);
            add(node);
            return node.v;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node!=null){
            node.v=value;
            remove(node);
            add(node);
        }else {
            if(map.size()>=capacity){
                map.remove(head.pre.k);
                remove(head.pre);
            }
            Node node1 = new Node();
            node1.v=value;
            node1.k=key;
            map.put(key,node1);
            add(node1);
        }
    }
    private void add(Node node) {
        Node next = head.next;

        head.next=node;
        node.pre=head;

        node.next=next;
        if(next!=null){
            next.pre=node;
        }


        if(head.pre==null){
            head.pre=node;
            node.next=head;
        }
    }

    /**
     * 从双向链表中删除该节点
     *
     * @param node 要删除的节点
     */
    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next=next;
        next.pre=pre;
    }
}

class Node {
    public Node pre;
    public Node next;
    public Integer k;
    public Integer v;
}