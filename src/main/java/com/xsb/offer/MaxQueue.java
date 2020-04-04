package com.xsb.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shibao.xing
 * @since 2020-04-04 12:01
 *
 * 题目：队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 */
class MaxQueue {

    private Deque<Integer> queue;

    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        deque = new ArrayDeque<>();
    }
    
    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peek();
    }
    
    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int r = queue.pollFirst();
        if (deque.peekFirst() == r) {
            deque.pollFirst();
        }
        return r;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(3);
        maxQueue.push_back(4);
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(5);
        System.out.println(maxQueue.max_value());
    }
}