package com.xsb.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shibao.xing
 * @since 2020-04-12 11:31
 *
 * 题目：栈的压入、弹出序列
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */
public class Question31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        if (pushed.length != popped.length) {
            return false;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int pushI = 0;
        int popI;
        for (popI = 0; popI < popped.length; popI++) {
            if (!stack.isEmpty()) {
                while (stack.peekLast() != popped[popI]) {
                    if (pushI < pushed.length) {
                        stack.offerLast(pushed[pushI++]);
                    } else {
                        break;
                    }
                }
            } else {
                while (pushI < pushed.length) {
                    stack.offerLast(pushed[pushI]);
                    if (pushed[pushI] == popped[popI]) {
                        pushI++;
                        break;
                    }
                    pushI++;
                }
            }
            if (stack.isEmpty() || stack.pollLast() != popped[popI]) {
                break;
            }
        }
        return pushI == pushed.length && popI == popped.length;
    }

    public static void main(String[] args) {
        Question31 question31 = new Question31();
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] poped = new int[]{4, 3, 5, 1, 2};
        boolean b = question31.validateStackSequences(pushed, poped);
        System.out.println(b);
    }
}
