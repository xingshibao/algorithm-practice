package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-05 15:55
 *
 * 题目：两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class Question52 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tmpA = headA;
        ListNode endA = null;
        int lenA = 0;
        while (tmpA != null) {
            lenA++;
            endA = tmpA;
            tmpA = tmpA.next;
        }

        ListNode tmpB = headB;
        ListNode endB = null;
        int lenB = 0;
        while (tmpB != null) {
            lenB++;
            endB = tmpB;
            tmpB = tmpB.next;
        }

        if (endA != endB) {
            return null;
        }

        tmpA = headA;
        tmpB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                tmpA = tmpA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                tmpB = tmpB.next;
            }
        }
        while (tmpA != tmpB) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return tmpA;
    }

    private int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }

    public static void main(String[] args) {
        Question52 question52 = new Question52();
        ListNode nodeA = question52.new ListNode(1);
        ListNode intersectionNode = question52.getIntersectionNode(nodeA, nodeA);
        System.out.println(intersectionNode.val);
    }
}
