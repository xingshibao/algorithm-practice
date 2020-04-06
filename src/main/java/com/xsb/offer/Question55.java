package com.xsb.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shibao.xing
 * @since 2020-04-06 14:11
 *
 * 题目：平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class Question55 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pollFirst();
            int leftDepth = depth(treeNode.left);
            int rightDepth = depth(treeNode.right);
            if (Math.abs(leftDepth - rightDepth) > 1) {
                return false;
            }
            if (treeNode.left != null) {
                queue.offerLast(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offerLast(treeNode.right);
            }
        }
        return true;
    }

    public int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftDepth = depth(treeNode.left);
        int rightDepth = depth(treeNode.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {

    }
}
