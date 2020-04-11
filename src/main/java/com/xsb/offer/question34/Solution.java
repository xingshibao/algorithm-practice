package com.xsb.offer.question34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shibao.xing
 * @since 2020-04-11 14:33
 *
 * 题目：二叉树中和为某一值的路径
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
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

    private List<List<Integer>> l = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, sum, new LinkedList<>());
        return l;
    }

    private void pathSum(TreeNode root, int target, LinkedList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        target -= root.val;
        if (0 == target && root.left == null && root.right == null) {
            l.add(new ArrayList<>(result));
        }
        pathSum(root.left, target, result);
        pathSum(root.right, target, result);
        result.removeLast();
    }
}
