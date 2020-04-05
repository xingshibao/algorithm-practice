package com.xsb.offer;

import java.util.Stack;

/**
 * @author shibao.xing
 * @since 2020-04-05 09:56
 *
 * 题目：用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {

    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    private int size;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        size++;
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stack1.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        int i = cQueue.deleteHead();
        System.out.println(i);

        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
