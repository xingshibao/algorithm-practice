package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 13:51
 *
 * 题目：二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class Question27 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmpTreeNode = root.left;
        root.left = root.right;
        root.right = tmpTreeNode;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
