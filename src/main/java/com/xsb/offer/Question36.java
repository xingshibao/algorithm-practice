package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-11 15:39
 *
 * 题目：二叉搜索树与双向链表
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class Question36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        mid(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void mid(Node cur) {
        if (cur == null) {
            return;
        }
        mid(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        mid(cur.right);
    }
}
