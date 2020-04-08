package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-08 22:19
 *
 * 题目：反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class Question24 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode p = head.next;
        ListNode pNext = head.next.next;
        pre.next = null;
        while (p != null) {
            p.next = pre;
            pre = p;
            p = pNext;
            if (pNext != null) {
                pNext = pNext.next;
            } else {
                return pre;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Question24 question24 = new Question24();
        ListNode node1 = question24.new ListNode(1);
        ListNode node2 = question24.new ListNode(2);
        ListNode node3 = question24.new ListNode(3);
        ListNode node4 = question24.new ListNode(4);
        ListNode node5 = question24.new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode tmp = node1;
        while (tmp != null) {
            System.out.printf("%d->", tmp.val);
            tmp = tmp.next;
        }
        System.out.println();

        ListNode node = question24.reverseList(node1);
        while (node != null) {
            System.out.printf("%d->", node.val);
            node = node.next;
        }
    }
}
