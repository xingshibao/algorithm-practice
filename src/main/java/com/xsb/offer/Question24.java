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

    }
}
