package com.trip.algorithm.leet.l24.l02;

import java.util.ArrayList;
import java.util.List;

public class Solution289 {
    public static void main(String[] args) {

    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        process(list, root);
        return list;
    }

    private void process(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        List<Node> children = root.children;
        if (children == null || children.isEmpty()) {
            return;
        }
        for (int i = 0; i < children.size(); i++) {
            process(list, children.get(i));
        }
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
