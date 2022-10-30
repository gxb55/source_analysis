package com.trip.algorithm.leet.zs;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author xbguo
 * @createTime 2022年07月02日 19:42:00
 * 目录按级输出
 *
 *  String[] arr = {"a\\b\\c\\q\\w\\e\\z", "a\\d", "e", "a\\b\\f", "i\\p\\o"};
 * a
 *   b
 *     c
 *       q
 *         w
 *           e
 *             z
 *     f
 *   d
 * e
 * i
 *   p
 *     o
 */
public class Problem01_GetFolderTree {
    public static void main(String[] args) {
        String[] arr = {"a\\b\\c\\q\\w\\e\\z", "a\\d", "e", "a\\b\\f", "i\\p\\o"};
        Node node = generateFolderTree(arr);
        printProcess(node, 0);
    }

    public static Node generateFolderTree(String[] folderPaths) {
        Node node = new Node("");
        for (int i = 0; i < folderPaths.length; i++) {
            String[] split = folderPaths[i].split("\\\\");
            Node cur = node;
            for (String path : split) {
                if (!cur.treeMap.containsKey(path)) {
                    cur.treeMap.put(path, new Node(path));
                }
                cur = cur.treeMap.get(path);
            }
        }
        return node;
    }

    public static void printProcess(Node node, int level) {
        TreeMap<String, Node> treeMap = node.treeMap;
        print(node, level);
        for (Map.Entry<String, Node> entry : treeMap.entrySet()) {
            printProcess(entry.getValue(), level+1);
        }
    }

    private static void print(Node node, int level) {
        if(node.name.equals("")){
            return;
        }
        for (int i = 0; i < level-1; i++) {
            System.out.print("  ");
        }
        System.out.println(node.name);
    }

    static class Node {
        public String name;
        public TreeMap<String, Node> treeMap;

        public Node(String name) {
            this.treeMap = new TreeMap<>();
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", treeMap=" + treeMap +
                    '}';
        }
    }
}
