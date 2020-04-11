package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-11 15:03
 *
 * 题目：二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class Question33 {

        public boolean verifyPostorder(int[] postorder) {
            return verifyPostorder(postorder, 0, postorder.length - 1);
        }

        private boolean verifyPostorder(int[] postorder, int s, int e) {
            if (s >= e) {
                return true;
            }

            int p = s;
            while (postorder[p] < postorder[e]) {
                p++;
            }
            int m = p;
            while (postorder[p] > postorder[e]) {
                p++;
            }
            return verifyPostorder(postorder, s, m - 1) && verifyPostorder(postorder, m, e - 1) && p == e;
        }
}
