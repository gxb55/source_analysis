package com.trip.algorithm.zuo.day0613.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

/**
 * k 方法进行最小生成树
 * @author Administrator
 */
public class Code04_KrusKal {
    // Union-Find Set
    public static class UnionFind{
        // key 某一个节点 value key节点往上的节点
        private HashMap<Node,Node> fatherMap;
        // key 某一个集合的代表节点 value key所在集合的节点个数
        private HashMap<Node,Integer> sizeMap;

        public UnionFind() {
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
        }

        /**
         * 初始化UnionFind 对象
         * @param nodes
         */
        public void makeSets(Collection<Node> nodes){
            fatherMap.clear();
            sizeMap.clear();
            for (Node node:nodes){
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        /**
         * 找到节点的父节点
         * a->b->c->d->e
         * e e
         * d e
         * c e
         * b e
         * a e
         * @param node
         * @return
         */
        public Node findFather(Node node){
            Stack<Node> stack = new Stack<>();
            while (node!=fatherMap.get(node)){
                stack.add(node);
                node = fatherMap.get(node);
            }
            while (!stack.isEmpty()){
                Node pop = stack.pop();
                fatherMap.put(pop,node);
            }
            return node;
        }

        /**
         * node1和node2 是否是一个节点 就看他们的父节点是否是一个
         * @param node1
         * @param node2
         * @return
         */
        public boolean isSameSet(Node node1,Node node2){
            return findFather(node1) ==findFather(node2);
        }

        public void union(Node a,Node b){
            if(a==null||b==null){
                return;
            }
            Node aFather = findFather(a);
            Node bFather = findFather(b);
            if(aFather!=bFather){
                Integer aSize = sizeMap.get(aFather);
                Integer bSize = sizeMap.get(bFather);
                Node max = aSize>=bSize?aFather:bFather;
                Node min = aSize>=bSize?bFather:aFather;
                sizeMap.put(max,aSize+bSize);
                fatherMap.put(min,max);
                sizeMap.remove(min);
            }
        }
    }


}
