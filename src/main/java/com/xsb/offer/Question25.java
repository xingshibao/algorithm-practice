package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 15:22
 *
 * 题目：合并两个排序的链表
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class Question25 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode tmp = null;
        while (true) {
            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                    tmp = head;
                } else {
                    tmp.next = l1;
                    tmp = l1;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    tmp = head;
                } else {
                    tmp.next = l2;
                    tmp = l2;
                }
                l2 = l2.next;
            }

            if (l1 == null || l2 == null) {
                break;
            }
        }

        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return head;
    }

    public static void main(String[] args) {
        Question25 question25 = new Question25();

    }
}
