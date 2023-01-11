package com.trip.algorithm.leet.some.history;


import com.trip.algorithm.base.TreeNode;

/**
 * 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 二叉树: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * 输出: "1(2(4))(3)"
 * <p>
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 * <p>
 * 输入: 二叉树: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * 输出: "1(2()(4))(3)"
 * <p>
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 */
public class Leet_606 {
    public String tree2str(TreeNode root) {
        StringBuffer stringBuffer = new StringBuffer();
        preOrder(root, stringBuffer);
        String s1 = stringBuffer.toString();
        if (s1.length() > 2) {
            s1 = s1.substring(1, s1.length() - 1);
        }
        return s1;
    }

    /**
     * 二叉树[root,left,right]，
     * 则转换为root(left)(right)。
     * 如果只有left为空节点，则输出root()(right)；
     * 如果只有right为空节点则可以忽略右节点的()，输出为root(left)。
     *
     * @param root
     * @param sb
     * @return
     */
    private String preOrder(TreeNode root, StringBuffer sb) {
        if (root == null) {
            return "()";
        }
        sb.append("(" + root.val);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right != null) {
            sb.append(preOrder(root.left, sb));
            sb.append(preOrder(root.right, sb));
        }
        if (left != null && right == null) {
            sb.append(preOrder(root.left, sb));
        }
        if (left != null && right != null) {
            sb.append(preOrder(root.left, sb));
            sb.append(preOrder(root.right, sb));
        }
        sb.append(")");
        return "";
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode1.setLeft(new TreeNode(4));
        TreeNode treeNode12 = new TreeNode(3);
        treeNode.setLeft(treeNode1);
        treeNode.setRight(treeNode12);
        Leet_606 leet_606 = new Leet_606();
        String s = leet_606.tree2str(treeNode);
        System.out.println(s);
    }
}
