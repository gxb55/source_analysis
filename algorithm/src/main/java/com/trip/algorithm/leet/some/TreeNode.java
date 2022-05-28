package com.trip.algorithm.leet.some;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 */
@Getter
@Setter
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

