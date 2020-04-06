package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-06 14:21
 *
 * 题目：对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */
public class Question28 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    /**
     * leetcode官方解法
     */
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    public static void main(String[] args) {

    }
}
