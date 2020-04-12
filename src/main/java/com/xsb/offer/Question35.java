package com.xsb.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shibao.xing
 * @since 2020-04-12 13:44
 *
 * 题目：复杂链表的复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class Question35 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 空间换时间
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();
        Map<Node, Node> reverseMap = new HashMap<>();

        // 1.复制链表
        Node tmpHead = head;
        Node newHead = null;
        Node tmpNewNode = null;
        while (tmpHead != null) {
            if (newHead == null) {
                newHead = new Node(tmpHead.val);
                tmpNewNode = newHead;
            } else {
                Node node = new Node(tmpHead.val);
                tmpNewNode.next = node;
                tmpNewNode = node;
            }
            map.put(tmpNewNode, tmpHead);
            reverseMap.put(tmpHead, tmpNewNode);
            tmpHead = tmpHead.next;
        }

        // 2.赋值random指针
        Node tmpNewHead = newHead;
        while (tmpNewHead != null) {
            tmpNewHead.random = reverseMap.get(map.get(tmpNewHead).random);
            tmpNewHead = tmpNewHead.next;
        }

        return newHead;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // 1.复制链表
        Node tmpHead = head;
        while (tmpHead != null) {
            Node node = new Node(tmpHead.val + 100);
            node.next = tmpHead.next;
            tmpHead.next = node;
            tmpHead = node.next;
        }

        // 2.赋值random指针
        tmpHead = head;
        while (tmpHead != null) {
            Node newNodeHead = tmpHead.next;
            if (tmpHead.random != null) {
                newNodeHead.random = tmpHead.random.next;
            }
            tmpHead = newNodeHead.next;
        }

        // 3.链表拆分
        tmpHead = head;
        Node cloneHead = head.next;
        Node cloneNode = head.next;
        while (cloneNode != null) {
            tmpHead.next = cloneNode.next;
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
            }
            if (tmpHead.next != null) {
                cloneNode = tmpHead.next.next;
            } else {
                cloneNode = null;
            }
            tmpHead = tmpHead.next;
        }

        return cloneHead;
    }

    private void print(Node node) {
        Node tmpNode = node;
        while (tmpNode != null) {
            System.out.printf("%d->", tmpNode.val);
            tmpNode = tmpNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Question35 question35 = new Question35();
        Node node1 = question35.new Node(1);
        Node node2 = question35.new Node(2);
        Node node3 = question35.new Node(3);
        Node node4 = question35.new Node(4);
        Node node5 = question35.new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node n = question35.copyRandomList(node1);
        question35.print(n);
    }
}
