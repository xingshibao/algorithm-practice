package com.xsb.offer.question3201;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author shibao.xing
 * @since 2020-04-11 13:55
 *
 * 题目：从上到下打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 层序遍历，不明白为啥是medium
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pollFirst();
            list.add(treeNode.val);
            if (treeNode.left != null) {
                queue.offerLast(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offerLast(treeNode.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
