package com.trip.algorithm.zuo.day0613;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author Administrator
 * 并查集
 * 训练营第三期
 */
public class Code01_UnionFind {
    public static class Node<V> {
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> values) {
            for (V cur : values) {
                Node<V> node = new Node<>(cur);
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> cur) {
            // 先进后出 栈
            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }
            // cur头结点
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        /**
         * a和b是否是一个父类
         *
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                Integer aSetSize = sizeMap.get(aHead);
                Integer bSetSize = sizeMap.get(bHead);
                Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSetSize + bSetSize);
                sizeMap.remove(small);
            }
        }
        public int getSetNum(){
            return sizeMap.size();
        }
    }

    public static void main(String[] args) {
        // 先进先出
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (Object o : stack) {
            System.out.println(o);
        }
        System.out.println("--------");
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }

}
