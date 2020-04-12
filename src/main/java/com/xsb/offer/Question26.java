package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-12 13:06
 *
 * 题目：树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class Question26 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (subStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean subStructure(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }

        return subStructure(a.left, b.left) && subStructure(a.right, b.right);
    }
}
