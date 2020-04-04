package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-04 14:50
 *
 * 题目：链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class Question22 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tailK = head;
        while (k > 1) {
            tailK = tailK.next;
            if (tailK == null) {
                tailK = null;
                break;
            }
            k--;
        }
        if (tailK == null) {
            return null;
        }
        ListNode result = head;
        while (tailK.next != null) {
            result = result.next;
            tailK = tailK.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Question22 question22 = new Question22();
        ListNode node1 = question22.new ListNode(1);
        ListNode node2 = question22.new ListNode(2);
        ListNode node3 = question22.new ListNode(3);
        ListNode node4 = question22.new ListNode(4);
        ListNode node5 = question22.new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode kthFromEnd = question22.getKthFromEnd(node1, 6);
        if (kthFromEnd != null) {
            System.out.println(kthFromEnd.val);
        }
    }
}
