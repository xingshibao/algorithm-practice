package com.xsb.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shibao.xing
 * @since 2020-04-05 15:17
 *
 * 题目：从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class Question6 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int[] reversePrint(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.offer(head.val);
            head = head.next;
        }

        int[] result = new int[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            result[i++] = deque.pollLast();
        }
        return result;
    }
}
