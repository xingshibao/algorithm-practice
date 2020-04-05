package com.xsb.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shibao.xing
 * @since 2020-04-05 15:42
 *
 * 题目：包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/submissions/
 */
public class MinStack {

    private Deque<Integer> stack;

    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.offerLast(x);
        if (minStack.isEmpty()) {
            minStack.offerLast(x);
        } else {
            int i = minStack.peekLast();
            if (x > i) {
                minStack.offerLast(i);
            } else {
                minStack.offerLast(x);
            }
        }
    }

    public void pop() {
        stack.pollLast();
        minStack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        return minStack.peekLast();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
