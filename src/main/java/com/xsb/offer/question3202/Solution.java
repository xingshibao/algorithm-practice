package com.xsb.offer.question3202;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题目：从上到下打印二叉树 II
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> levelList = new ArrayDeque<>();
        Deque<TreeNode> level2 = new ArrayDeque<>();
        levelList.add(root);
        List<Integer> list = new ArrayList<>();
        while (!levelList.isEmpty()) {
            TreeNode treeNode = levelList.pollFirst();
            list.add(treeNode.val);

            if (treeNode.left != null) {
                level2.add(treeNode.left);
            }
            if (treeNode.right != null) {
                level2.add(treeNode.right);
            }
            if (levelList.isEmpty()) {
                levelList.addAll(level2);
                level2.clear();
                result.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}