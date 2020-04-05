package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 14:39
 *
 * 题目：删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class Question18 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode tmp = head;
        ListNode preTmp = null;
        while (tmp != null) {
            if (tmp.val == val) {
                if (preTmp != null) {
                    preTmp.next = tmp.next;
                    tmp = tmp.next;
                } else {
                    head = head.next;
                    tmp = head;
                }
            } else {
                preTmp = tmp;
                tmp = tmp.next;
            }
        }

        return head;
    }

    private void print(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Question18 question18 = new Question18();
        ListNode node1 = question18.new ListNode(1);
        ListNode node2 = question18.new ListNode(1);
        ListNode node3 = question18.new ListNode(1);
        ListNode node4 = question18.new ListNode(1);
        ListNode node5 = question18.new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = question18.deleteNode(node1, 1);
        question18.print(listNode);
    }
}
