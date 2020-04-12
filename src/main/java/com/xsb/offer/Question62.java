package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-12 09:23
 *
 * 题目：圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class Question62 {

    /**
     * 这种方法我是想不到
     * 用循环链表的笨方法去做，估计肯定超时
     */
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) %i;
        }
        return last;
    }
}
