package com.trip.algorithm.leet.l24.l02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/2/19 17:41
 * @description TODO
 */
public class Solution590 {
    public static void main(String[] args) {
        Solution590 solution590 =new Solution590();
        Node node =new Node(1);
        node.children= Arrays.asList(new Node(3),new Node(2),new Node(4));
        node.children.get(0).children=Arrays.asList(new Node(5),new Node(6));
        List<Integer> postorder = solution590.postorder(node);
        System.out.println(postorder);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();

        process(list, root);
        if(root==null){
            return list;
        }
        list.add(root.val);
        return list;
    }

    private void process(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        if (null == children || children.isEmpty()) {
            return;
        }
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            process(list, node);
            list.add(node.val);
        }

    }

    static class Node {
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
    }

}
