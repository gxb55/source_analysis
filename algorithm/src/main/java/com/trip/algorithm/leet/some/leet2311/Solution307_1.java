package com.trip.algorithm.leet.some.leet2311;

/**
 * @author xbguo
 * @date 2023/11/15 19:18
 */
public class Solution307_1 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        NumArray1 numArray1 =new NumArray1(arr);
        numArray1.update(2,12);
        int i = numArray1.sumRange(2, 8);
        System.out.println(i);
    }

}

class NumArray1 {

    private Node node;

    public NumArray1(int[] nums) {
        node = Node.buildNode(nums, 0, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        Node.update(node, index, val);
    }

    public int sumRange(int left, int right) {
        int sum = Node.queryByLeftAndRight(node, left, right);

        return sum;
    }
}

class Node {
    public int left, right, sum;

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", sum=" + sum +
                '}';
    }

    public Node leftNode, rightNode;

    public static Node buildNode(int[] arr, int index, int left, int right) {
        Node node = new Node(left, right, arr[index]);
        if (left == right && left == index) {
            return node;
        }
        int mid = (left + right) / 2;
        node.setLeftNode(buildNode(arr, left, left, mid));
        node.setRightNode(buildNode(arr, mid + 1, mid + 1, right));
        node.sum = node.leftNode.sum + node.rightNode.sum;
        return node;
    }

    public static void update(Node node, int index, int val) {
        if(node==null){
            return;
        }
        if (node.left == node.right && node.left == index) {
            node.sum = val;
            return;
        }
        int mid = (node.left + node.right) / 2;
        if (index <= mid) {
            update(node.leftNode, index, val);
        } else {
            update(node.rightNode, index, val);
        }
        int sum=0;
        if(node.leftNode!=null){
            sum+=node.leftNode.sum;
        }
        if(node.rightNode!=null){
            sum+=node.rightNode.sum;
        }
        node.sum = sum;
    }

    public static int queryByLeftAndRight(Node node, int l, int r) {
        if (node.left >= l && node.right <= r) {
            return node.sum;
        }
        int mid = (node.left + node.right) / 2;
        int p1 = Integer.MIN_VALUE;
        int p2 = Integer.MIN_VALUE;
        if (l <= mid) {
            p1 = queryByLeftAndRight(node.leftNode, l, r);
        }
        if (mid < r) {
            p2 = queryByLeftAndRight(node.rightNode, l, r);
        }
        int sum = 0;
        if (p1 != Integer.MIN_VALUE) {
            sum += p1;
        }
        if (p2 != Integer.MIN_VALUE) {
            sum += p2;
        }
        return sum;
    }

    public Node(int left, int right, int sum) {
        this.left = left;
        this.right = right;
        this.sum = sum;
    }

    public Node() {
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}